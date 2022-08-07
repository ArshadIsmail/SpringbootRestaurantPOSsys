package com.resturantmanagement.resturantmanagement.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="delivery")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="address")
	private String address;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH		
	})
	@JoinColumn(name="delivery_employee_id")
	private Employee employee;
	
	@Column(name="delivery_date")
	private Date deliveryDate;
	
	
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH		
	})
	@JoinColumn(name="delivery_status_id")
	private DeliveryStatus deliveryStatus;
	
	
	@OneToOne(cascade= {CascadeType.ALL	
	})
	@JoinColumn(name="order_id")
	private Order order;
	
}
