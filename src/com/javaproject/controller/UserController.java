package com.javaproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.javaproject.models.User;
import com.javaproject.services.UserService;
import com.javaproject.services.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service=new UserServiceImpl();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     * 
     */
    public UserController() {
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
			String firstname=request.getParameter("firstname");
			String lastname=request.getParameter("lastname");
			String gender=request.getParameter("gender");
			String dob=request.getParameter("dob");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String usertype=request.getParameter("usertype");
			String address=request.getParameter("address");
			
			System.out.println(action + "-" + username + "-" + password + " " + usertype);
			// Create Model
			User user = new User();
			//user.setId(Integer.parseInt(id));
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setGender(gender);

			// Parse the string to Date
			Date utlDate = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
			utlDate = sdf.parse(dob);
			} catch (ParseException e) {
			System.out.println(e);
			}
			user.setDob(utlDate);
						
			user.setUsername(username);
			user.setPassword(password);
			user.setUsertype(usertype);
			user.setAddress(address);
			// Service
			String result = service.addUser(user);
			System.out.println("result : " + result);
			if(result.equals("SUCCESS")) {
				request.setAttribute("msg","Registration success");
				rd=request.getRequestDispatcher("Register.jsp");
			}else if(result.equals("FAIL")) {
				request.setAttribute("msg","Registration fail");
				rd=request.getRequestDispatcher("Register.jsp");
			}else {
				request.setAttribute("msg","Registration fail");
				rd=request.getRequestDispatcher("Register.jsp");
			}
			
		}
		else if (action.equals("login")) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			
			User u = service.login(user);
//			System.out.println(u);
			if(u!=null) {
				session=request.getSession();
				session.setAttribute("username", username);
				//session.setMaxInactiveInterval(30);
				
				if(u.getUsertype().equals("admin")) {
					request.setAttribute("msg","Welcome, "+u.getUsername() +" you are logged in as "+u.getUsertype());
					rd =request.getRequestDispatcher("Admin.jsp");
					
				}else {
					request.setAttribute("msg","Welcome, "+u.getUsername() +" you are logged in as "+u.getUsertype());
					rd =request.getRequestDispatcher("dashboard.jsp");
				}
				
			}else {
				request.setAttribute("msg","invalid credentials");
				rd =request.getRequestDispatcher("login.jsp");

			}
		}
		else if (action.equals("getAll")) {
			
			List<User> list = service.getallUsers();
			System.out.println(list);
			rd=request.getRequestDispatcher("getallusers.jsp");
			request.setAttribute("list", list);
		}
		else if(action.equals("logout")) {
			session =request.getSession(false);
			String username=(String)session.getAttribute("username");
			session.removeAttribute("username");
			session.invalidate();
			
			rd=request.getRequestDispatcher("login.jsp");
				
		}
		else if (action.equals("update")) {
			
			String id=request.getParameter("id");
			String firstname=request.getParameter("firstname");
			String lastname=request.getParameter("lastname");
			String gender=request.getParameter("gender");
			String dob=request.getParameter("dob");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String usertype=request.getParameter("usertype");
			String address=request.getParameter("address");
			
			System.out.println(action + "-" + username + "-" + password + " " + usertype);
			// Create Model
			User user = new User();
			user.setId(Integer.parseInt(id));
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setGender(gender);

			// Parse the string to Date
			Date utlDate = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
			utlDate = sdf.parse(dob);
			} catch (ParseException e) {
			System.out.println(e);
			}
			user.setDob(utlDate);
						
			user.setUsername(username);
			user.setPassword(password);
			user.setUsertype(usertype);
			user.setAddress(address);
			// Service
			String result = service.updateUser(user);
			System.out.println("result : " + result);
			if(result.equals("SUCCESS")) {
				request.setAttribute("msg", "Updation Sucess");
				if(user.getUsertype().equals("admin")) {
					rd =request.getRequestDispatcher("Admin.jsp");
				}else {
					rd =request.getRequestDispatcher("dashboard.jsp");
				}
				
			}else if(result.equals("FAIL")) {
				request.setAttribute("msg", "Updation Fail");
				if(user.getUsertype().equals("admin")) {
					rd =request.getRequestDispatcher("Admin.jsp");
				}else {
					rd =request.getRequestDispatcher("dashboard.jsp");
				}
			}else {
				request.setAttribute("msg", "Updation Fail");
				if(user.getUsertype().equals("admin")) {
					rd =request.getRequestDispatcher("Admin.jsp");
				}else {
					rd =request.getRequestDispatcher("dashboard.jsp");
				}
			}
		}
		else if (action.equals("delete")) {
			
			String id = request.getParameter("id");
			// Create Model
			User user = new User();
			user.setId(Integer.parseInt(id));
			// Service
			String result = service.delUser(user);
			System.out.println("result : " + result);
			if(result.equals("SUCCESS")) {
				request.setAttribute("msg","Deletion success");
				rd=request.getRequestDispatcher("Admin.jsp");
			}else if(result.equals("FAIL")) {
				request.setAttribute("msg","Deletion fail");
				rd=request.getRequestDispatcher("Admin.jsp");
			}else {
				request.setAttribute("msg","Deletion fail");
				rd=request.getRequestDispatcher("Admin.jsp");
			}
			
		} 
		else if (action.equals("getByID")) {
			
			String id = request.getParameter("id");
			User user = service.getUserById(Integer.parseInt(id));
			System.out.println(user);
			request.setAttribute("user",user);
			rd =request.getRequestDispatcher("getbyid.jsp");
			
			
		} 
		else if (action.equals("getByName")) {
			
			String username = request.getParameter("username");
			User user = service.getUserByName(username);
			System.out.println(user);
			request.setAttribute("user",user);
			rd =request.getRequestDispatcher("getbyname.jsp");

			
		}else if(action.equals("searchByIdForUpdate")){
			//Read The id
			String id=request.getParameter("id");
			//Invoke the Service
			User u=service.getUserById(new Integer(id));
			//Dispatch it in update Page
			rd=request.getRequestDispatcher("updateUser.jsp");
			request.setAttribute("user", u);
		}
		else if(action.equals("searchBynameForUpdate")){
			UserDAO dao=new UserDAOImpl();
			session = request.getSession(false);
			String username = (String) session.getAttribute("username");
			System.out.println("user:"+username);
//			//Invoke the Service
			User u=new User();
			try {
				u = dao.getUserByName(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Dispatch it in update Page
			rd=request.getRequestDispatcher("update.jsp");
			request.setAttribute("user", u);
		}
		else {
			
		}
		
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
