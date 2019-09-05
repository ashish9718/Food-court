package com.javaproject.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaproject.dao.UserDAO;
import com.javaproject.dao.UserDAOImpl;
import com.javaproject.models.DisplayOrder;
import com.javaproject.models.Item;
import com.javaproject.models.Menu;
import com.javaproject.models.OrderMaster;
import com.javaproject.models.PlaceOrder;
import com.javaproject.services.UserService;
import com.javaproject.services.UserServiceImpl;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = new UserServiceImpl();
	private UserDAO dao = new UserDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(false);
		
		if (action.equals("placeorder")) {
			String result = "FAIL";
			String itemId[] = request.getParameterValues("itemid");
			String qty[] = request.getParameterValues("qty");
			String username = request.getParameter("username");
			ArrayList<PlaceOrder> placeorder = new ArrayList<PlaceOrder>();
			if (itemId != null && qty != null) {
				try {
					if (dao.addOrder(username)) {
						int orderid = dao.getLastOrderId();

						for (int i = 0; i < itemId.length; i++) {
							PlaceOrder pd = new PlaceOrder();
							pd.setItemid(Integer.parseInt(itemId[i]));
							pd.setQty(Integer.parseInt(qty[i]));
							pd.setOrderid(orderid);
							placeorder.add(pd);
							System.out.println(pd);

						}
						System.out.println(placeorder);

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				result = dao.placeOrder(placeorder);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("result : " + result);
			if (result.equals("SUCCESS")) {
				request.setAttribute("msg", "Order Placed");
				rd = request.getRequestDispatcher("dashboard.jsp");
			} else if (result.equals("FAIL")) {
				request.setAttribute("msg", "Order fail");
				rd = request.getRequestDispatcher("dashboard.jsp");
			} else {
				request.setAttribute("msg", "Order fail");
				rd = request.getRequestDispatcher("dashboard.jsp");
			}

		} 
		else if (action.equals("deleteorder")) {
			String orderid=request.getParameter("orderid");
			String itemname=request.getParameter("itemname");
			String result="FAIL";
			try {
				result = dao.deleteOrder(Integer.parseInt(orderid),itemname);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("result : " + result);
			if(result.equals("SUCCESS")) {
				request.setAttribute("msg","Item Deleted");
				rd=request.getRequestDispatcher("dashboard.jsp");
			}else if(result.equals("FAIL")) {
				request.setAttribute("msg","Item Deletion fail");
				rd=request.getRequestDispatcher("dashboard.jsp");
			}else {
				request.setAttribute("msg","Item Deletion fail");
				rd=request.getRequestDispatcher("dashboard.jsp");
			}

		} 
		else if (action.equals("vieworder")) {
			String username = (String) session.getAttribute("username");
			System.out.println("user:"+username);
//			String username=request.getParameter("username");
//			System.out.println("username:" +username);
			List<ArrayList<DisplayOrder>> list = null;
			try {
				list = dao.viewOrder(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(list);
			rd = request.getRequestDispatcher("orderview.jsp");
			request.setAttribute("list", list);

		}
		
		else if (action.equals("getbill")) {
			String username = (String) session.getAttribute("username");
			System.out.println("user:"+username);
			List<ArrayList<DisplayOrder>> list = null;
			try {
				list = dao.viewOrder(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(list);
			rd = request.getRequestDispatcher("bill.jsp");
			request.setAttribute("list", list);

		}
		else if (action.equals("getallorders")) {
			List<OrderMaster> list=new ArrayList<OrderMaster>();
			try {
				 list=dao.getAllOrders();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(list);
			rd = request.getRequestDispatcher("getallorders.jsp");
			request.setAttribute("list", list);
			

		} 
		else if (action.equals("getorderbyusername")) {
		String username=request.getParameter("username");
		String orderid=request.getParameter("orderid");
		
		//System.out.println("username:" +username);
		List<ArrayList<DisplayOrder>> list = null;
		try {
			list = dao.viewOrderbyUsername(username,Integer.parseInt(orderid));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
		rd = request.getRequestDispatcher("getorderbyusername.jsp");
		request.setAttribute("list", list);

	}
	
		else if (action.equals("getmenu")) {
			List<Menu> list = service.getAllMenus();
			System.out.println(list);
			rd = request.getRequestDispatcher("ordermenu.jsp");
			request.setAttribute("menu", list);

		}
		else if (action.equals("getitemBycategory")) {

			String category = request.getParameter("category");
			List<Item> list = (List<Item>) service.getItemByCategory(category);
			System.out.println(list);
			request.setAttribute("list", list);
			rd = request.getRequestDispatcher("orderitem.jsp");
		}

		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
