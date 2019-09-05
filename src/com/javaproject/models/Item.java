package com.javaproject.models;

public class Item {
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", category_id=" + category_id + ", cost=" + cost + ", name=" + name + "]";
	}
	public Item() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Item(int id, int category_id, float cost, String name) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.cost = cost;
		this.name = name;
	}
	private int id;
	private int category_id;
	private float cost;
	private String name;
	
}
