package com.delivery.onlineorder.repository;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
public class GroupOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private String status;

	//	@OneToMany
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "groupOrder")
	@org.hibernate.annotations.ForeignKey(name = "none")
	private List<PersonalOrder> personalOrders;

	public GroupOrder() {
	}

	public GroupOrder(String status, List<PersonalOrder> personalOrders) {
		this.status = status;
		this.personalOrders = personalOrders;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PersonalOrder> getPersonalOrders() {
		return personalOrders;
	}

	public void setPersonalOrders(List<PersonalOrder> personalOrders) {
		this.personalOrders = personalOrders;
	}
}