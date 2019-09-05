package com.javaproject.models;

public class Menu {
	
	private int id;
	private String category;
	
	public Menu(int id, String category) {
		super();
		this.id = id;
		this.category = category;
	}
	
	public Menu() {
		
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", category=" + category + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
