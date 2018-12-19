package com.delivery.onlineorder.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer menuId;

	private String name;

	@Lob
	private String dishes;

	@Lob
	private String drinks;

	public Menu() {
	}

	public Menu(String name, String dishes, String drinks) {
		this.name = name;
		this.dishes = dishes;
		this.drinks = drinks;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDishes() {
		return dishes;
	}

	public void setDishes(String dishes) {
		this.dishes = dishes;
	}

	public String getDrinks() {
		return drinks;
	}

	public void setDrinks(String drinks) {
		this.drinks = drinks;
	}
}
