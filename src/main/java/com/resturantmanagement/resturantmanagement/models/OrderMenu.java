package com.resturantmanagement.resturantmanagement.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order_menu")
public class OrderMenu{

	
	@EmbeddedId
	private OrderMenuPk id;
	
	
	@ManyToOne
	@MapsId("orderNo")//Variable name in order menu pk
	@JoinColumn(name="order_no")
	private Order order;
	
	@ManyToOne
	@MapsId("menuItemId")//Variable name in order menu pk
	@JoinColumn(name="menu_id")
	private MenuItem menuItem;
	
	@Column(name="units")
	private int units;
	
	@Column(name="total_amount")
	private String totalAmount;

	public OrderMenu() {
		
	}

	public OrderMenu(Order order, MenuItem menuItem, int units, String totalAmount) {
		super();
		this.order = order;
		this.menuItem = menuItem;
		this.units = units;
		this.totalAmount = totalAmount;
	}

	public OrderMenuPk getId() {
		return id;
	}

	public void setId(OrderMenuPk id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	//To print an object we need to  convert to  java String.. to_string method
	//So it prints like this eg:-[{Raja,1234},{Rani,1245}]
	//To create sql form this statement
	@Override
	public String toString() {
		return "OrderMenu [id=" + id + ", order=" + order + ", menuItem=" + menuItem + ", units=" + units
				+ ", totalAmount=" + totalAmount + "]";
	}
	
	
	
	
}
