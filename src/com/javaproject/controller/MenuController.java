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

import com.javaproject.models.Menu;
import com.javaproject.models.User;
import com.javaproject.services.UserService;
import com.javaproject.services.UserServiceImpl;

/**
 * Servlet implementation class MenuController
 */
@WebServlet("/MenuController")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service=new UserServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuController() {
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
			String category=request.getParameter("category");
			System.out.println(action + "-" + category);
			// Create Model
			Menu menu = new Menu();
			//menu.setId(Integer.parseInt(id));
			menu.setCategory(category);
			// Service
			String result = service.addMenu(menu);
			System.out.println("result : " + result);
			if(result.equals("SUCCESS")) {
				request.setAttribute("msg","Menu added");
				rd=request.getRequestDispatcher("Admin.jsp");
			}else if(result.equals("FAIL")) {
				request.setAttribute("msg","Menu addition failed");
				rd=request.getRequestDispatcher("Admin.jsp");
			}else {
				request.setAttribute("msg","Menu addition failed");
				rd=request.getRequestDispatcher("Admin.jsp");
			}
			
		}
		else if (action.equals("getAll")) {
			
			List<Menu> list = service.getAllMenus();
			System.out.println(list);
			rd=request.getRequestDispatcher("getallmenus.jsp");
			request.setAttribute("list", list);
		}
		else if (action.equals("update")) {
			
			String id=request.getParameter("id");
			String category=request.getParameter("category");
			System.out.println(action + "-" + id + "-" + category);
			// Create Model
			Menu menu = new Menu();
			menu.setId(Integer.parseInt(id));
			menu.setCategory(category);
			// Service
			String result = service.updateMenu(menu);
			System.out.println("result : " + result);
			if(result.equals("SUCCESS")) {
				request.setAttribute("msg", "Menu Updated");
				rd =request.getRequestDispatcher("Admin.jsp");
			}else if(result.equals("FAIL")) {
				request.setAttribute("msg", "Menu Updation Fail");
				rd =request.getRequestDispatcher("Admin.jsp");
			}else {
				request.setAttribute("msg", "Menu Updation Fail");
				rd =request.getRequestDispatcher("Admin.jsp");
			}
		}
		else if (action.equals("delete")) {
			
			String id = request.getParameter("id");
			// Create Model
			Menu menu = new Menu();
			menu.setId(Integer.parseInt(id));
			// Service
			String result = service.delMenu(menu);
			System.out.println("result : " + result);
			if(result.equals("SUCCESS")) {
				request.setAttribute("msg","Menu Deleted");
				rd=request.getRequestDispatcher("Admin.jsp");
			}else if(result.equals("FAIL")) {
				request.setAttribute("msg","Menu Deletion fail");
				rd=request.getRequestDispatcher("Admin.jsp");
			}else {
				request.setAttribute("msg","Menu Deletion fail");
				rd=request.getRequestDispatcher("Admin.jsp");
			}
			
		} 
		else if(action.equals("searchByIdForUpdate")){
			//Read The id
			String id=request.getParameter("id");
			//Invoke the Service
			Menu u=service.getMenuById(new Integer(id));
			//Dispatch it in update Page
			rd=request.getRequestDispatcher("update_menu.jsp");
			request.setAttribute("menu", u);
		}
		else if (action.equals("getByID")) {
			
			String id = request.getParameter("id");
			Menu menu = service.getMenuById(Integer.parseInt(id));
			System.out.println(menu);
			request.setAttribute("menu",menu);
			rd =request.getRequestDispatcher("getmenubyid.jsp");
			
			
		} 
		else if (action.equals("getBycategory")) {
			
			String category = request.getParameter("category");
			Menu menu = service.getMenuByCategory(category);
			System.out.println(menu);
			request.setAttribute("menu",menu);
			rd =request.getRequestDispatcher("getmenubycategory.jsp");
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
