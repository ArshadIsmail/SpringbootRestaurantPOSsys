package com.resturantmanagement.resturantmanagement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="resturant")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Resturant {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="no")
	private String no;
	
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String  city;
	
	@Column(name="phone")
	private String phone;
	
	
	
	
	
	
	
	

}
