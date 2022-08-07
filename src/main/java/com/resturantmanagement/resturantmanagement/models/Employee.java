package com.resturantmanagement.resturantmanagement.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee extends Auditable<String> {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="second_name")
	private String secondName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="employee_number")
	private String employeeNumber;
	
	@Column(name="created_at")
	private  Date createdAt;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="nic")
	private String nic;
	
	
	
	@Column(name="email")
	private String email;
	
	@ManyToOne(
			fetch=FetchType.EAGER,
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
			)
	@JoinColumn(name="designation_id")
	private Designation designation;
	
	
	@ManyToOne(
			fetch=FetchType.EAGER,
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
			)
	@JoinColumn(name="gender_id")
	private Gender gender;
	
	@ManyToOne(
			fetch=FetchType.EAGER,
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
			)
	@JoinColumn(name="shift_id")
	private Shift shift;
	
	@OneToOne(
			fetch=FetchType.EAGER,
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
			)
	@JoinColumn(name="address_id")
	private Address address;
	
	@ManyToOne(
			fetch=FetchType.EAGER,
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
			)
	@JoinColumn(name="status_id")
	private EmployeeStatus employeeStatus;
	
	
	
	
	
	
	

}
