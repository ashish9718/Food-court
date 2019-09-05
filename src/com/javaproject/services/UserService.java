package com.javaproject.services;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.javaproject.dao.UserDAOImpl;
import com.javaproject.models.Item;
import com.javaproject.models.Menu;
import com.javaproject.models.PlaceOrder;
import com.javaproject.models.User;
public interface UserService {

	public String addUser(User user);
	public User login(User user);
	public List<User> getallUsers();
	
	public String delUser(User user);
	public String updateUser(User user);
	
	public User getUserByName(String name);
	public User getUserById(int Id);

	//menu methods
	public String addMenu(Menu menu);
	public String delMenu(Menu menu);
	public String updateMenu(Menu menu);
	public List<Menu> getAllMenus();
	public Menu getMenuByCategory(String category);
	public Menu getMenuById(int Id);

	//item methods
	public String addItem(Item item);
	public String delItem(Item item);
	public String updateItem(Item item);
	public List<Item> getAllItems();
	public List<Item> getItemByCategory(String category);
	public Item getItemById(int Id);

	
}
