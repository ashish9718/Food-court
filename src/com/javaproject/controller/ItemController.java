package com.javaproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaproject.models.Item;
import com.javaproject.models.Menu;
import com.javaproject.services.UserService;
import com.javaproject.services.UserServiceImpl;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service=new UserServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		RequestDispatcher rd=null;
		HttpSession session=null;
		if(action.equals("insert")) {
			//String id=request.getParameter("id");
			String category_id=request.getParameter("category_id");
			String name=request.getParameter("name");
			String cost=request.getParameter("cost");
			
			System.out.println(action +  "-" + category_id + "-" + name + "-" + cost);
			// Create Model
			Item item = new Item();
			//item.setId(Integer.parseInt(id));
			item.setCategory_id(Integer.parseInt(category_id));
			item.setName(name);
			item.setCost(Float.parseFloat(cost));
			// Service
			String result = service.addItem(item);
			System.out.println("result : " + result);
			if(result.equals("SUCCESS")) {
				request.setAttribute("msg","Item added");
				rd=request.getRequestDispatcher("Admin.jsp");
			}else if(result.equals("FAIL")) {
				request.setAttribute("msg","Item addition failed");
				rd=request.getRequestDispatcher("Admin.jsp");
			}else {
				request.setAttribute("msg","Item addition failed");
				rd=request.getRequestDispatcher("Admin.jsp");
			}
			
		}
		else if (action.equals("getAll")) {
			
			List<Item> list = service.getAllItems();
			
			System.out.println(list);
			rd=request.getRequestDispatcher("getallitems.jsp");
			request.setAttribute("list", list);
		}
		else if (action.equals("update")) {
			
			String id=request.getParameter("id");
			String category_id=request.getParameter("category_id");
			String name=request.getParameter("name");
			String cost=request.getParameter("cost");
			
			System.out.println(action + "-" + id + "-" + category_id + "-" + name + "-" + cost);
			// Create Model
			Item item = new Item();
			item.setId(Integer.parseInt(id));
			item.setCategory_id(Integer.parseInt(category_id));
			item.setName(name);
			item.setCost(Float.parseFloat(cost));
			// Service
			String result = service.updateItem(item);
			System.out.println("result : " + result);
			if(result.equals("SUCCESS")) {
				request.setAttribute("msg", "Item Updated");
				rd =request.getRequestDispatcher("Admin.jsp");
			}else if(result.equals("FAIL")) {
				request.setAttribute("msg", "Item Updation Fail");
				rd =request.getRequestDispatcher("Admin.jsp");
			}else {
				request.setAttribute("msg", "Item Updation Fail");
				rd =request.getRequestDispatcher("Admin.jsp");
			}
		}
		else if (action.equals("delete")) {
			
			String id = request.getParameter("id");
			// Create Model
			Item item = new Item();
			item.setId(Integer.parseInt(id));
			// Service
			String result = service.delItem(item);
			System.out.println("result : " + result);
			if(result.equals("SUCCESS")) {
				request.setAttribute("msg","Item Deleted");
				rd=request.getRequestDispatcher("Admin.jsp");
			}else if(result.equals("FAIL")) {
				request.setAttribute("msg","Item Deletion fail");
				rd=request.getRequestDispatcher("Admin.jsp");
			}else {
				request.setAttribute("msg","Item Deletion fail");
				rd=request.getRequestDispatcher("Admin.jsp");
			}
			
		} 
		else if(action.equals("searchByIdForUpdate")){
			//Read The id
			String id=request.getParameter("id");
			//Invoke the Service
			Item u=service.getItemById(new Integer(id));
			//Dispatch it in update Page
			rd=request.getRequestDispatcher("update_item.jsp");
			request.setAttribute("item", u);
		}
//		else if (action.equals("getByID")) {
//			
//			String id = request.getParameter("id");
//			Item item = service.getItemById(Integer.parseInt(id));
//			System.out.println(item);
//			request.setAttribute("item",item);
//			rd =request.getRequestDispatcher("getitembyid.jsp");
//			
//		} 
		else if (action.equals("getBycategory")) {
			
			String category = request.getParameter("category");
			List<Item> list= (List<Item>) service.getItemByCategory(category);
			Menu menu=new Menu();
			menu.setCategory(category);
			System.out.println(list+" "+menu);
			request.setAttribute("list",list);
			request.setAttribute("menu", menu);
			rd =request.getRequestDispatcher("getitembycategory.jsp");
		}
		
		else {
			
		}
		
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
