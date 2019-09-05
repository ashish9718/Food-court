package com.javaproject.models;

import java.util.Date;

public class OrderMaster {
	@Override
	public String toString() {
		return "OrderMaster [id=" + id + ", Username=" + Username + ", date=" + date + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public OrderMaster(int id, String username, Date date) {
		super();
		this.id = id;
		Username = username;
		this.date = date;
	}
	public OrderMaster() {
		
	}
	private int id;
	private String Username;
	private Date date; 
}
