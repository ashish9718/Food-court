package com.javaproject.services;

import java.sql.SQLException;
import java.util.List;

import com.javaproject.dao.UserDAO;
import com.javaproject.dao.UserDAOImpl;
import com.javaproject.models.Item;
import com.javaproject.models.Menu;
import com.javaproject.models.PlaceOrder;
import com.javaproject.models.User;

public class UserServiceImpl implements UserService {
	private UserDAO dao=new UserDAOImpl();

	@Override
	public String addUser(User user) {
		String result=null;
		try {
			
			result=dao.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

		@Override
	public User login(User user) {
		User result=null;
		try {
			result=dao.login(user);
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return result;
	}

	
	@Override
	public List<User> getallUsers() {
		List<User> result=null;
		try {
			result = dao.getallUsers();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public String delUser(User user) {
		String result=null;
		try {
			result=dao.delUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String updateUser(User user) {
		String result=null;
		try {
			result=dao.updateUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public User getUserByName(String name) {
		User result=null;
		try {
			result=dao.getUserByName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public User getUserById(int Id) {
		User result=null;
		try {
			result=dao.getUserById(Id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
//---------------------------------------------------------------------------------------------------------------------
	@Override
	public String addMenu(Menu menu)  {
		String result=null;
		try {
			
			result=dao.addMenu(menu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String delMenu(Menu menu) {
		String result=null;
		try {
			result=dao.delMenu(menu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String updateMenu(Menu menu) {
		String result=null;
		try {
			result=dao.updateMenu(menu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Menu> getAllMenus(){
		List<Menu> result=null;
		try {
			result = dao.getAllMenus();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public Menu getMenuByCategory(String category) {
		Menu menu=null;
		try {
			menu=dao.getMenuBycategory(category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public Menu getMenuById(int Id) {
		Menu menu=null;
		try {
			menu=dao.getMenuById(Id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}
//------------------------------------------------------------------------------------------------------------------------------
	@Override
	public String addItem(Item item) {
		String result=null;
		try {
			
			result=dao.addItem(item);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public String delItem(Item item) {
		String result=null;
		try {
			result=dao.delItem(item);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String updateItem(Item item) {
		String result=null;
		try {
			result=dao.updateItem(item);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<Item> getAllItems() {
		List<Item> result=null;
		try {
			result = dao.getAllItems();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public List<Item> getItemByCategory(String category) {
		List<Item> item=null;
		try {
			item=dao.getItemBycategory(category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}
	@Override
	public Item getItemById(int Id) {
		Item item=null;
		try {
			item=dao.getItemById(Id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}
//----------------------------------------------------------------------------------------------
	}
