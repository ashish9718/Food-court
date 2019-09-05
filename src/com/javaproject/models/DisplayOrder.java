package com.javaproject.models;

import java.util.Date;

public class DisplayOrder {
	
	@Override
	public String toString() {
		return "DisplayOrder [id=" + id + ", orderid=" + orderid + ", username=" + username + ", menuname=" + menuname
				+ ", itemname=" + itemname + ", itemcost=" + itemcost + ", qty=" + qty + ", date=" + date + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public Float getItemcost() {
		return itemcost;
	}
	public void setItemcost(Float itemcost) {
		this.itemcost = itemcost;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public DisplayOrder() {
		
	}
	public DisplayOrder(int id, int orderid, String username, String menuname, String itemname, Float itemcost, int qty,
			Date date) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.username = username;
		this.menuname = menuname;
		this.itemname = itemname;
		this.itemcost = itemcost;
		this.qty = qty;
		this.date = date;
	}
	private int id;
	private int orderid;
	private String username;
	private String menuname;
	private String itemname;
	private Float itemcost;
	private int qty;
	private Date date;
	
}
