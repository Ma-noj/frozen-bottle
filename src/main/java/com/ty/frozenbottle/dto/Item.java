package com.ty.frozenbottle.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double cost;
	private String name;
	private int quantity;
	private String category;

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private FoodOrder foodOrder;

	@ManyToOne()
	@JsonIgnore
	private FoodMenu foodMenu;

	public Item() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public FoodOrder getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}

	public FoodMenu getFoodMenu() {
		return foodMenu;
	}

	public void setFoodMenu(FoodMenu foodMenu) {
		this.foodMenu = foodMenu;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", cost=" + cost + ", name=" + name + ", quantity=" + quantity + ", category="
				+ category + ", foodOrder=" + foodOrder + ", foodMenu=" + foodMenu + "]";
	}

}
