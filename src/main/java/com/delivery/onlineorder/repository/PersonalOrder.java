package com.delivery.onlineorder.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PersonalOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer personalOrderId;

	private String name;

	@Column(nullable = false)
	private String dish;

	private String drink;

	@Column(nullable = false)
	private Integer type;

	private String status;

	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_order_id", nullable = false,
			foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
	private GroupOrder groupOrder;

	public PersonalOrder() {
	}

	public PersonalOrder(String name, String dish, String drink, Integer type, String status, GroupOrder groupOrder) {
		this.name = name;
		this.dish = dish;
		this.drink = drink;
		this.type = type;
		this.status = status;
		this.groupOrder = groupOrder;
	}

	public Integer getPersonalOrderId() {
		return personalOrderId;
	}

	public void setPersonalOrderId(Integer personalOrderId) {
		this.personalOrderId = personalOrderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public GroupOrder getGroupOrder() {
		return groupOrder;
	}

	public void setGroupOrder(GroupOrder groupOrder) {
		this.groupOrder = groupOrder;
	}
}

