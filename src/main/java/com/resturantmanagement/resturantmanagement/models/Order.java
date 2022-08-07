package com.resturantmanagement.resturantmanagement.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name="`order`")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="order_no")
	private String orderNo;
	
	@Column(name="no_of_items")
	private int noOfItems;

	@Column(name="total_price")
	private String totalPrice;

	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="discount")
	private String discount;
		
	
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH		
	})
	@JoinColumn(name="order_type_id")
	private OrderType orderType;
	
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH		
	})
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH		
	})
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@Column(name="service_charge")
	private String serviceCharge;
	
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,
			CascadeType.PERSIST,CascadeType.REFRESH		
	})
	@JoinColumn(name="status_id")
	private OrderStatus orderStatus;
	
	@Column(name="delivery_date")
	private Date deliveryDate;
	
	//@Column(name="comments")
	//private String comments;
	
	@Column(name="final_price")
	private String finalPrice;
		
	
	
	@OneToMany(mappedBy = "order")
	private Set<OrderMenu> orderMenu = new HashSet<>();
	
	@OneToMany(mappedBy = "order")
	private Set<MenuOrder> menuOrder ;
	//= new HashSet<>();

	@OneToOne(mappedBy="order", cascade=CascadeType.ALL)
	private Delivery delivery;
	
	@OneToOne(mappedBy="order", cascade=CascadeType.ALL)
	private OrderDineIn orderDineIn;
	
	////Test
	@ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "orderedItems",
            joinColumns = {@JoinColumn(name = "orderId")},
            inverseJoinColumns = {@JoinColumn(name = "menuId")}
    )
    private List<MenuItem> menuItems = new ArrayList<>();
	
	

//    @ManyToMany(cascade = {
//        CascadeType.ALL
//    })
//    @JoinTable(
//        name = "orderedItems",
//        joinColumns = {
//            @JoinColumn(name = "orderId")
//        },
//        inverseJoinColumns = {
//            @JoinColumn(name = "menuId")
//        }
//    )
//    Set < MenuItem > menuItems = new HashSet < MenuItem > ();

	
	
}
