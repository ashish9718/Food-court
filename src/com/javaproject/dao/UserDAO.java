package com.javaproject.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaproject.models.*;

public interface UserDAO {
	//user methods
	public String addUser(User user) throws SQLException;
	public User login(User user) throws SQLException;
	public List<User> getallUsers() throws SQLException;
	
	public String delUser(User user) throws SQLException;
	public String updateUser(User user) throws SQLException;
	
	public User getUserByName(String name) throws SQLException;
	public User getUserById(int Id) throws SQLException;
	
	//public String updateinfo(User user) throws SQLException;
	
	//menu methods
	public String addMenu(Menu menu) throws SQLException;
	public String delMenu(Menu menu) throws SQLException;
	public String updateMenu(Menu menu) throws SQLException;
	public List<Menu> getAllMenus() throws SQLException;
	public Menu getMenuBycategory(String name) throws SQLException;
	public Menu getMenuById(int Id) throws SQLException;
	
	//item methods
	public String addItem(Item item) throws SQLException;
	public String delItem(Item item) throws SQLException;
	public String updateItem(Item item) throws SQLException;
	public List<Item> getAllItems() throws SQLException;
	public List<Item> getItemBycategory(String name) throws SQLException;
	public Item getItemById(int Id) throws SQLException;
	

	//place order
	public String placeOrder(ArrayList<PlaceOrder> placeorder) throws SQLException;
	public String deleteOrder(int orderid,String itemname) throws SQLException;
	public ArrayList<ArrayList<DisplayOrder>> viewOrder(String username) throws SQLException;
	
	public List<OrderMaster> getAllOrders() throws SQLException;
	//
	public boolean addOrder(String username) throws SQLException ;
	public int getLastOrderId() throws SQLException ;
	public ArrayList<ArrayList<DisplayOrder>> viewOrderbyUsername(String username,int orderid) throws SQLException;
		
	
	}
