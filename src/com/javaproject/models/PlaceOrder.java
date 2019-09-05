package com.javaproject.models;

import java.util.Date;

public class PlaceOrder {

	@Override
	public String toString() {
		return "PlaceOrder [id=" + id + ", orderid=" + orderid + ", itemid=" + itemid + ", qty=" + qty + "]";
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
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public PlaceOrder(int id, int orderid, int itemid, int qty) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.itemid = itemid;
		this.qty = qty;
	}
	public PlaceOrder() {
		
	}
	private int id;
	private int orderid;
	private int itemid;
	private int qty;
	
	

}
