
package com.javaproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.javaproject.models.*;
import com.javaproject.util.JDBCExample;

public class UserDAOImpl implements UserDAO{
	private Connection con=new JDBCExample().getCon();
//-------------------------------------------------------------------------------------------------------------------------------	
	@Override
	public String addUser(User user) throws SQLException {
		String res="FAIL";
		PreparedStatement ps = null;
		String sql = "INSERT INTO users(firstname,lastname,gender,dob,username,password,usertype,address)"
				+ " VALUE(?,?,?,?,?,?,?,?)";
		//Create Statement
		ps = con.prepareStatement(sql);
		//Set The parameter value
		//ps.setInt(1, user.getId());
		ps.setString(1, user.getFirstname());
		ps.setString(2, user.getLastname());
		ps.setString(3, user.getGender());
		long time=user.getDob().getTime();
		ps.setDate(4, new java.sql.Date(time));
		ps.setString(5, user.getUsername());
		ps.setString(6, user.getPassword());
		ps.setString(7, user.getUsertype());
		ps.setString(8, user.getAddress());
		//Execute The statement
		int r=ps.executeUpdate();
		if(r>0) {
			res = "SUCCESS";
		}
		return res;
	}

		@Override
	public List<User> getallUsers() throws SQLException {
		List<User> list=new ArrayList<User>();
		PreparedStatement ps = null;
		String sql = "SELECT * from users";
		ps = con.prepareStatement(sql);		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setGender(rs.getString("gender"));
			user.setDob(rs.getDate("dob"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setUsertype(rs.getString("usertype"));
			user.setAddress(rs.getString("address"));
			
			list.add(user);
		}
		return list;
	}

		@Override
		public User login(User user) throws SQLException {
			String res="FAIL";
			PreparedStatement ps = null;
			String sql = "SELECT * from users where username=? and password=? ";
			//Create Statement
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			//ps.setString(3, user.getUsertype());
			
			ResultSet rs=ps.executeQuery();    
			while(rs.next()) {
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));			
				user.setUsertype(rs.getString("usertype"));
			}
			return user;
		}

		@Override
		public String delUser(User user) throws SQLException {
			String res = "FAIL";
			PreparedStatement ps = null;
			String sql = "DELETE FROM users WHERE id=?";
			//Create Statement
			ps = con.prepareStatement(sql);
			//Set The parameter value
			ps.setInt(1, user.getId());		
			//Execute The statement
			int r=ps.executeUpdate();
			if(r>0) {
				res = "SUCCESS";
			}
			return res;
		}
		@Override
		public String updateUser(User user) throws SQLException {
			String res = "FAIL";
			PreparedStatement ps = null;
			String sql = "UPDATE users SET firstname=?,lastname=?,gender=?,dob=?,username=?,password=?,usertype=?,address=? WHERE id=?";
			//Create Statement
			ps = con.prepareStatement(sql);
			//Set The parameter value
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getGender());
			long time=user.getDob().getTime();
			ps.setDate(4, new java.sql.Date(time));
			ps.setString(5, user.getUsername());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getUsertype());
			ps.setString(8, user.getAddress());
			ps.setInt(9, user.getId());
			//Execute The statement
			int r=ps.executeUpdate();
			if(r>0) {
				res = "SUCCESS";
			}
			return res;
		}

		@Override
		public User getUserByName(String name) throws SQLException {
			User user = null;
			PreparedStatement ps = null;
			String sql = "SELECT * from users WHERE username=?";
			//Create Statement
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setGender(rs.getString("gender"));
				user.setDob(rs.getDate("dob"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUsertype(rs.getString("usertype"));
				user.setAddress(rs.getString("address"));
				
			}
			
			return user;
		}
		

		@Override
		public User getUserById(int Id) throws SQLException {
			
			User user=null;
			PreparedStatement ps = null;
			String sql = "SELECT * from users WHERE id=?";
			//Create Statement
			ps = con.prepareStatement(sql);
			ps.setInt(1, Id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setGender(rs.getString("gender"));
				user.setDob(rs.getDate("dob"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUsertype(rs.getString("usertype"));
				user.setAddress(rs.getString("address"));
				
			}
			
			return user;
		}
//-------------------------------------------------------------------------------------------------------------------------------------
		@Override
		public String addMenu(Menu menu) throws SQLException {
			String res="FAIL";
			PreparedStatement ps = null;
			String sql = "INSERT INTO menu(category)"
					+ " VALUE(?)";
			//Create Statement
			ps = con.prepareStatement(sql);
			//Set The parameter value
			ps.setString(1, menu.getCategory());
			//Execute The statement
			int r=ps.executeUpdate();
			if(r>0) {
				res = "SUCCESS";
			}
			return res;
		}

		@Override
		public String delMenu(Menu menu) throws SQLException {
			String res = "FAIL";
			PreparedStatement ps = null;
			String sql = "DELETE FROM menu WHERE id=?";
			//Create Statement
			ps = con.prepareStatement(sql);
			//Set The parameter value
			ps.setInt(1, menu.getId());		
			//Execute The statement
			int r=ps.executeUpdate();
			if(r>0) {
				res = "SUCCESS";
			}
			return res;
		}

		@Override
		public String updateMenu(Menu menu) throws SQLException {
			String res = "FAIL";
			PreparedStatement ps = null;
			String sql = "UPDATE menu SET category=? WHERE id=?";
			//Create Statement
			ps = con.prepareStatement(sql);
			//Set The parameter value
			ps.setString(1, menu.getCategory());
			ps.setInt(2, menu.getId());
			//Execute The statement
			int r=ps.executeUpdate();
			if(r>0) {
				res = "SUCCESS";
			}
			return res;

		}

		@Override
		public List<Menu> getAllMenus() throws SQLException {
			List<Menu> list=new ArrayList<Menu>();
			PreparedStatement ps = null;
			String sql = "SELECT * from menu";
			ps = con.prepareStatement(sql);		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setId(rs.getInt("id"));
				menu.setCategory(rs.getString("category"));
				list.add(menu);
			}
			return list;
		}

		@Override
		public Menu getMenuBycategory(String category) throws SQLException {
			Menu menu = null;
			PreparedStatement ps = null;
			String sql = "SELECT * from menu WHERE category=?";
			//Create Statement
			ps = con.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				menu = new Menu();
				menu.setId(rs.getInt("id"));
				menu.setCategory(rs.getString("category"));
			}
			
			return menu;
		}

		@Override
		public Menu getMenuById(int Id) throws SQLException {
			Menu menu = null;
			PreparedStatement ps = null;
			String sql = "SELECT * from menu WHERE id=?";
			//Create Statement
			ps = con.prepareStatement(sql);
			ps.setInt(1, Id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				menu = new Menu();
				menu.setId(rs.getInt("id"));
				menu.setCategory(rs.getString("category"));
			}
			
			return menu;
		}
		
		
//-------------------------------------------------------------------------------------------------------------------------------------
	
		
		@Override
		public String addItem(Item item) throws SQLException {
			String res="FAIL";
			PreparedStatement ps = null;
			String sql = "INSERT INTO item(category_id,name,cost)"
					+ " VALUE(?,?,?)";
			//Create Statement
			ps = con.prepareStatement(sql);
			//Set The parameter value
			//ps.setInt(1, item.getId());
			ps.setInt(1, item.getCategory_id());
			ps.setString(2, item.getName());
			ps.setFloat(3, item.getCost());
			//Execute The statement
			int r=ps.executeUpdate();
			if(r>0) {
				res = "SUCCESS";
			}
			return res;
		}

		@Override
		public String delItem(Item item) throws SQLException {
			String res = "FAIL";
			PreparedStatement ps = null;
			String sql = "DELETE FROM item WHERE id=?";
			//Create Statement
			ps = con.prepareStatement(sql);
			//Set The parameter value
			ps.setInt(1, item.getId());		
			//Execute The statement
			int r=ps.executeUpdate();
			if(r>0) {
				res = "SUCCESS";
			}
			return res;
		}

		@Override
		public String updateItem(Item item) throws SQLException {
			String res = "FAIL";
			PreparedStatement ps = null;
			String sql = "UPDATE item SET name=?,cost=? WHERE id=?";
			//Create Statement
			ps = con.prepareStatement(sql);
			//Set The parameter value
			ps.setString(1, item.getName());
			ps.setFloat(2, item.getCost());
			ps.setInt(3, item.getId());
			//Execute The statement
			int r=ps.executeUpdate();
			if(r>0) {
				res = "SUCCESS";
			}
			return res;

		}

		@Override
		public List<Item> getAllItems() throws SQLException {
			List<Item> list=new ArrayList<Item>();
			PreparedStatement ps = null;
			String sql = "SELECT * from item";
			//String sql = "SELECT item.id,item.name,menu.category,item.cost from item,menu where item.category_id=menu.id";
			ps = con.prepareStatement(sql);		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setCategory_id(rs.getInt("category_id"));
				item.setName(rs.getString("name"));
				item.setCost(rs.getFloat("cost"));
				list.add(item);
			}
			return list;
		}
		@Override
		public List<Item> getItemBycategory(String category) throws SQLException {
			List<Item> list=new ArrayList<Item>();
			PreparedStatement ps = null;
			ResultSet rs=null;
			String sql = "SELECT * from menu WHERE category=?";
			//Create Statement
			ps = con.prepareStatement(sql);
			ps.setString(1, category);
		    rs=ps.executeQuery();
			int id=0;
			if(rs.next()) {
				 id=rs.getInt("id");
			}
			String sqll = "SELECT * from item WHERE category_id=?";
			//Create Statement
			ps = con.prepareStatement(sqll);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setCategory_id(rs.getInt("category_id"));
				item.setName(rs.getString("name"));
				item.setCost(rs.getFloat("cost"));
				list.add(item);
			}
			
			return list;
		}
		@Override
		public Item getItemById(int Id) throws SQLException {
			Item item = null;
			PreparedStatement ps = null;
			String sql = "SELECT * from item WHERE id=?";
			//Create Statement
			ps = con.prepareStatement(sql);
			ps.setInt(1, Id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				item = new Item();
				item.setId(rs.getInt("id"));
				item.setCategory_id(rs.getInt("category_id"));
				item.setName(rs.getString("name"));
				item.setCost(rs.getFloat("cost"));
			}
			
			return item;
		}
//-------------------------------------------------------------------------------------------------------
		
		@Override
		public String placeOrder(ArrayList<PlaceOrder> placeorder) throws SQLException {
			String res="FAIL";
			PreparedStatement ps = null;
			
			for(PlaceOrder pl:placeorder) {
				System.out.println(pl);
				Item item=getItemById(pl.getItemid());
				System.out.println(item);
				
				String sql = "INSERT INTO placeorder(orderid, itemid, qty, cost, itemname)"
						+ " VALUE(?,?,?,?,?)";
				//Create Statement
				ps = con.prepareStatement(sql);
				//Set The parameter value
				//ps.setInt(1, item.getId());
				ps.setInt(1,pl.getOrderid());
				ps.setInt(2, pl.getItemid());
				ps.setInt(3, pl.getQty());
				ps.setFloat(4, item.getCost());
				ps.setString(5, item.getName());
				
				//Execute The statement
				int r=ps.executeUpdate();
				if(r>0) {
					res = "SUCCESS";
				}
				
			}
			
			return res;		
		}

		@Override
		public String deleteOrder(int orderid,String itemname) throws SQLException {
			String res = "FAIL";
			PreparedStatement ps = null;
			String sql = "DELETE FROM placeorder WHERE orderid=?&&itemname=?";
			//Create Statement
			ps = con.prepareStatement(sql);
			//Set The parameter value
			ps.setInt(1, orderid);	
			ps.setString(2, itemname);
			//Execute The statement
			int r=ps.executeUpdate();
			if(r>0) {
				res = "SUCCESS";
			}
			return res;
		}

		@Override
		public ArrayList<ArrayList<DisplayOrder>> viewOrder(String username ) throws SQLException {
			ArrayList<ArrayList<DisplayOrder>> list = new ArrayList<ArrayList<DisplayOrder>>();
			PreparedStatement ps = null;
			
			String SQL = "SELECT * from ordermaster where date = curdate() and username=?";
			ps = con.prepareStatement(SQL);
			ps.setString(1, username);
			//Execute The statement
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ArrayList<DisplayOrder> listt = new ArrayList<DisplayOrder>();
				
				String sql = "SELECT * from placeorder where orderid=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, rs.getInt("id"));
				ResultSet rss=ps.executeQuery();
				
				while(rss.next()) {
				DisplayOrder order = new DisplayOrder();
				order.setUsername(username);
				order.setItemname(rss.getString("itemname"));
				order.setItemcost(rss.getFloat("cost"));
				//order.setMenuname(menuname);
				order.setDate(rs.getDate("date"));
				order.setOrderid(rs.getInt("id"));
				order.setQty(rss.getInt("qty"));
				System.out.println(order);
				listt.add(order);
				
			}
				list.add(listt);
				System.out.println(list);
		}
				
			return list;
	}
		
		@Override
		public ArrayList<ArrayList<DisplayOrder>> viewOrderbyUsername(String username,int orderid ) throws SQLException {
			ArrayList<ArrayList<DisplayOrder>> list = new ArrayList<ArrayList<DisplayOrder>>();
			PreparedStatement ps = null;
			
			String SQL = "SELECT * from ordermaster where username=?&&id=?";
			ps = con.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setInt(2, orderid);
			//Execute The statement
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ArrayList<DisplayOrder> listt = new ArrayList<DisplayOrder>();
				
				String sql = "SELECT * from placeorder where orderid=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, rs.getInt("id"));
				ResultSet rss=ps.executeQuery();
				
				while(rss.next()) {
				DisplayOrder order = new DisplayOrder();
				order.setUsername(username);
				order.setItemname(rss.getString("itemname"));
				order.setItemcost(rss.getFloat("cost"));
				//order.setMenuname(menuname);
				order.setDate(rs.getDate("date"));
				order.setOrderid(rs.getInt("id"));
				order.setQty(rss.getInt("qty"));
				System.out.println(order);
				listt.add(order);
				
			}
				list.add(listt);
				System.out.println(list);
		}
				
			return list;
	}
		
		
		@Override
		public List<OrderMaster> getAllOrders() throws SQLException {
			List<OrderMaster> list=new ArrayList<OrderMaster>();
			PreparedStatement ps = null;
			String sql = "SELECT * from ordermaster";
			
			ps = con.prepareStatement(sql);		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				User u=getUserById(rs.getInt("userid"));
				OrderMaster om=new OrderMaster();
				om.setId(rs.getInt("id"));
				om.setUsername(u.getUsername());
				om.setDate(rs.getDate("date"));
				list.add(om);
			}
			return list;
		}
/*------------------------------------------------------------------------------------------------*/
		public boolean addOrder(String username) throws SQLException {
			boolean res=false;
			PreparedStatement ps = null;
			User u=getUserByName(username);
			String SQL = "INSERT INTO ordermaster( userid,date,username) "+ " VALUE(?,CURDATE(),?)";
			//Create Statement
			ps = con.prepareStatement(SQL);
			//Set The parameter value
			
			ps.setInt(1, u.getId());
			ps.setString(2, u.getUsername());
			//Execute The statement
			int r=ps.executeUpdate();
			if(r>0) {
				res =true;
			}
			return res;
		}

		public int getLastOrderId() throws SQLException {
			PreparedStatement ps = null;
			String SQL = "select * from ordermaster";
			int orderId = 0;
			ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				orderId = rs.getInt("id");
			return orderId;
		}

}
