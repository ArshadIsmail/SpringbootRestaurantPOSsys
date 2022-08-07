package com.resturantmanagement.resturantmanagement.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name="menu_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")	
	private int id;
	
	
	
	
	//NOTE: write constructors and other things
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private float price;
	
	
	
	
	@Column(name="units_available")
	private int unitsAvailable;
	

	
	
	@Column(name="discount")
	private float discount;
	
	
	@Column(name="description")
	private String description;
	
	@Column(name="updated_at")
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date updatedAt;
	
	@Column(name="created_at")
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date createdAt;
	

	
		@ManyToOne(
				cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
				)
		@JoinColumn(name="category_id")
		private MenuCategory  menuCategory;
		
		
		
		
		
		@ManyToOne(
				cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
				)
		@JoinColumn(name="available_status_id")
		private MenuStatus menuStatus;//CREATE THIS TABLE

		@OneToMany(mappedBy="menuItem")
	    private Set<OrderMenu> orderMenu = new HashSet<>();
		
		@OneToMany(mappedBy="menuItem")
	    private Set<MenuOrder> menuOrder;
	    //= new HashSet<>();
		
		///////Test
//		   @ManyToMany(mappedBy="menuItem")
//		    private List<Order> orderss = new ArrayList<>();
//		   
//		   @ManyToMany(mappedBy = "menuItem", cascade = { CascadeType.ALL })
//		    private Set<Order> orders = new HashSet<Order>();

}



