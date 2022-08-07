package com.resturantmanagement.resturantmanagement.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class OrderMenuPk implements Serializable {

	@Column(name="order_no")
	private int orderNo;
	
	@Column(name="menu_id")
	private int menuItemId;
	
	
	
	
	
	

	public OrderMenuPk() {
	}
	
	

	public OrderMenuPk(int orderNo, int menuItemId) {
		this.orderNo = orderNo;
		this.menuItemId = menuItemId;
	}



	//Unique native method
	//Witch generates hash code numbers for objects.
	//Based in object class
	//One of the 11 method of native object class method like hash_code,equals,to_string
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + menuItemId;
		result = prime * result + orderNo;
		return result;
	}

//	NOTE: Every class in java is child class of object class.So all classes Implements 11 methods
	//native methods in object class
	
	//Native method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderMenuPk other = (OrderMenuPk) obj;
		if (menuItemId != other.menuItemId)
			return false;
		if (orderNo != other.orderNo)
			return false;
		return true;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}
	
	
	
	
	
}
