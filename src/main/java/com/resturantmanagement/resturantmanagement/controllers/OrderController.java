package com.resturantmanagement.resturantmanagement.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.resturantmanagement.resturantmanagement.models.Order;
import com.resturantmanagement.resturantmanagement.models.OrderMenu;
import com.resturantmanagement.resturantmanagement.models.OrderStatus;
import com.resturantmanagement.resturantmanagement.models.OrderType;
import com.resturantmanagement.resturantmanagement.models.Customer;
import com.resturantmanagement.resturantmanagement.models.Employee;
import com.resturantmanagement.resturantmanagement.models.Gender;
import com.resturantmanagement.resturantmanagement.models.MenuItem;
import com.resturantmanagement.resturantmanagement.models.MenuOrder;
import com.resturantmanagement.resturantmanagement.services.OrderService;
import com.resturantmanagement.resturantmanagement.services.OrderStatusService;
import com.resturantmanagement.resturantmanagement.services.OrderTypeService;
import com.resturantmanagement.resturantmanagement.services.CustomerService;
import com.resturantmanagement.resturantmanagement.services.EmployeeService;
import com.resturantmanagement.resturantmanagement.services.GenderService;
import com.resturantmanagement.resturantmanagement.services.MenuItemService;
import com.resturantmanagement.resturantmanagement.services.MenuOrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MenuItemService menuItemService;
	
	
	@Autowired
	private OrderStatusService orderStatusService;
	
	 
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private OrderTypeService orderTypeService;
	
	@Autowired
	private CustomerService customerService;
	
	//@Autowired
	//private MenuOrderService menuOrderService;
	
	
	
	
	//Listing all orders
	@GetMapping("/findAll")
	public String findAll(Model model) {
		
		
		//Getting list of MenuItems from menuItem service
				List<MenuItem> theMenuItems=menuItemService.findAll();
				
				//Binding into Model
				model.addAttribute("MenuItems",theMenuItems);
				
				
		//Getting list of Orders from order service
		List<Order> theOrders=orderService.findAll();

		
		//theOrders.forEach(System.out::println);
		//Binding into Model
		model.addAttribute("Orders",theOrders);
		
	
	    return "order/order_list";
		
	}
	
	
	
	//Add order form
	@GetMapping("/create")
	public String create(
			@RequestParam("orderNo") 
			int theOrderNo,
			Model theModel,
			HttpSession session) {
				
		
		int theDefaultCustomerId=1;
		int DefaultOrderTypeId=1;
		int DefaultEmployeeId=1;
		int DefaultOrderStatusId=1;


		System.out.println("Default Order");
		
		Customer theDefaultCustomer = customerService.findById(theDefaultCustomerId);
		OrderType theDefaultOrdertype= orderTypeService.findById(DefaultOrderTypeId);
		Employee theDefaultlEmployee =employeeService.findById(DefaultEmployeeId);
		OrderStatus theDefaultOrderStatus =orderStatusService.findById(DefaultOrderStatusId);

		
		Order theOrder = new Order();
		theOrder.setOrderNo(String.valueOf(theOrderNo));
		theOrder.setTotalPrice("0");
		theOrder.setOrderDate(null);
		theOrder.setDiscount("0");
		theOrder.setOrderType(theDefaultOrdertype);
		
		theOrder.setCustomer(theDefaultCustomer);
		theOrder.setEmployee(theDefaultlEmployee);
		theOrder.setServiceCharge("0");
		theOrder.setOrderStatus(theDefaultOrderStatus);
		theOrder.setDeliveryDate(null);
		theOrder.setFinalPrice("0");
	//	theOrder.setOrderMenu(null);
		theOrder.setDelivery(null);
		theOrder.setOrderDineIn(null);
		
		//System.out.println(theOrder);
		
		//Creating Default Order
	     Order SavedDefaultOrder=orderService.save(theOrder);
	     
	    // System.out.println(SavedDefaultOrder);
	     
	     int SavedDefaultOrderId =SavedDefaultOrder.getId();


	     
	        System.out.println("Saving a Menu Order");

	     //   MenuOrder menuOrder = new MenuOrder();
		//	MenuItem theMenuItem= menuItemService.findById(1);

//	      //  menuOrder.
//	        menuOrder.setMenuItem(theMenuItem);
//	         menuOrder.setOrder(SavedDefaultOrder);
//	    //    menuOrder.setOrder(SavedDefaultOrder);
//	        menuOrder.setTotalAmount("100");
//	        menuOrder.setUnits(5);
//	        
//	        menuOrderService.save(menuOrder);
			
//			MenuItem theMenuItem= menuItemService.findById(1);
//			
//			theOrderenu.setMenuItem(theMenuItem);
//			
//			Order theOrderdefault= orderService.findById(DefaultOrderStatusId);
//
//			theOrderdefault.setOrderMenuO(theOrderenu);
//			
//			theOrderenu.save(theOrderenu);
//			
//			theOrderenu.save(theOrderenu);


////////////TEST
//			if (session.getAttribute("order") == null) {
//                Order order = new Order();
//                List<Meal> mealList = new ArrayList<>();
//                mealList.add(mealRepository.findById(id).orElseThrow(NullPointerException::new));
//                order.setMeals(mealList);
//                order.setRealizationDate(LocalDateTime.now());
//                order.setOrderStatus(OrderStatus.ZAMOWIONE);
//                order.setPriority(0);
//                orderRepository.save(order);
//                session.setAttribute("order", order);
//            } else {
//                Order order = (Order) session.getAttribute("order");
//                List<Meal> mealList = order.getMeals();
//                mealList.add(mealRepository.findById(id).orElseThrow(NullPointerException::new));
//                order.setMeals(mealList);
//                order.setRealizationDate(LocalDateTime.now());
//                order.setPriority(0);
//                order.setOrderStatus(OrderStatus.ZAMOWIONE);
//                orderRepository.save(order);
//                session.setAttribute("order", order);
//            }
//
			Order theOrderdefault= orderService.findById(DefaultOrderStatusId);
			//System.out.println(SavedDefaultOrder);
            List<MenuItem>  menuList = new ArrayList<>();
            MenuItem theMenuItem2= menuItemService.findById(2);
            List<MenuItem>  menuListAll = menuItemService.findAll();

            menuList.add(theMenuItem2);
            
            
            SavedDefaultOrder.setMenuItems(menuListAll);
          //  theOrderdefault.setMenuItems(menuList)
           // System.out.println(theOrderdefault);
            orderService.save(SavedDefaultOrder);


		
		
//		 id:'1',
//   	     orderNo:"12434", 
//   	     noOfItems:'10', 
//   	     totalPrice:'500',
//   	     orderDate:null,
//		   discount:'10',
//		   orderType:{
//			   id:'1',
//			   name:null},//set in controller 
//		   customer:{
//			   id:'1',
//			   name:null},//set in controller 
//		   employee:{
//			   id:'1',
//			   name:null},//set in controller 
//		   serviceCharge:'10',
//		   orderStatus:{
//			   id:'1',
//			   name:null},//insert in controller
//		   deliveryDate:null,
//		   finalPrice:'1000', 
//		   orderMenu:[],//figure it out
//		   delivery:null,
//		   orderDineIn:null
		
		
		//theModel.addAttribute("order",theOrder);
		
	     
		
		List<Employee> employeeList =employeeService.findAll();
		List<OrderStatus> orderStatusList=orderStatusService.findAll();
		List<OrderType> orderTypeList=orderTypeService.findAll();
		List<Customer> customerList=customerService.findAll();

		List<MenuItem> menuItemList = menuItemService.findAll();
		
		theModel.addAttribute("employeeList",employeeList);
		theModel.addAttribute("orderStatusList",orderStatusList);		
		theModel.addAttribute("orderTypeList",orderTypeList);
		theModel.addAttribute("customerList",customerList);
			
		//theModel.addAttribute("SavedDefaultOrder",SavedDefaultOrder);

		//session.setAttribute("order", theOrderdefault);
			
		//return "order/order2";
		return "redirect:/order/update?orderId="+SavedDefaultOrderId+" ";
	}
	
	
	
	
	/*
	 * @PostMapping("/save") //save order public String
	 * save(@ModelAttribute("order") Order theOrder ) {
	 * 
	 * //Saving order
	 *  orderService.save(theOrder);
	 * 
	 * 
	 * //Redirecting return "redirect:/order/findAll";
	 * 
	 * }
	 */
	
	
//	@PostMapping("/save")  //save order
//	public String save(@ModelAttribute("order") Order theOrder ) {
//		
//		System.out.println("chkk here4");
//
//		System.out.println(theOrder);
//
//		//System.out.println(theOrder);
//		//Saving order
//	     orderService.save(theOrder);
//		
//		
//		//Redirecting
//		return "redirect:/order/findAll";
//		   
//	}
	
	@PostMapping("/save")  //save order
	public String save(@RequestBody  Order theRunningOrder) {
		
		
		
		//UPDATING ORDER??  find order b id??????
		
		//Take id here and findby and update data???
		
		System.out.println("testing4");
	//	System.out.println(theRunningOrder);
		
		
		
//		Customer theCustomer = customerService.findById(theRunningOrder.getCustomer().getId());
//		OrderType theOrdertype= orderTypeService.findById(theRunningOrder.getOrderType().getId());
//		Employee theEmployee =employeeService.findById(theRunningOrder.getEmployee().getId());
//		OrderStatus theOrderStatus =orderStatusService.findById(theRunningOrder.getOrderStatus().getId());
//
//		
//		Order theOrder = new Order();
//		theOrder.setId(theRunningOrder.getId());
//		theOrder.setOrderNo(theRunningOrder.getOrderNo());
//		theOrder.setTotalPrice("0");
//		theOrder.setOrderDate(null);
//		theOrder.setDiscount("0");
//		theOrder.setOrderType(theOrdertype);
//		
//		theOrder.setCustomer(theCustomer);
//		theOrder.setEmployee(theEmployee);
//		theOrder.setServiceCharge("0");
//		theOrder.setOrderStatus(theOrderStatus);
//		theOrder.setDeliveryDate(null);
//		theOrder.setFinalPrice("0");
//		theOrder.setOrderMenu(null);
//		theOrder.setDelivery(null);
//		theOrder.setOrderDineIn(null);
////		
////		
////		
//		System.out.println("chk here5");
////
////		//System.out.println(theOrder.getCustomer().getId());
////
////		System.out.println(theOrder);
////		//Saving order
//	     orderService.save(theOrder);
//		
		
		
		//Redirecting
		return "redirect:/order/findAll";
		   
	}
	
	
	
	//Update order
	@GetMapping("/update")
	public String edit(@RequestParam("orderId") int theId , Model theModel,HttpSession session) {
		
		
		List<MenuItem> menuItemList = menuItemService.findAll();
		theModel.addAttribute("menuItemList",menuItemList);

		
		System.out.println("testing");

		//Get the Order from the service layer
		Order theOrder = orderService.findById(theId);
		//Set as session object
		session.setAttribute("order", theOrder);

		System.out.println("test123");

		//System.out.println(theOrder);
		//Add to Model
		theModel.addAttribute("order",theOrder);
		
		
		List<Employee> employeeList =employeeService.findAll();
		List<OrderStatus> orderStatusList=orderStatusService.findAll();
		List<OrderType> orderTypeList=orderTypeService.findAll();
		List<Customer> customerList=customerService.findAll();


		
		theModel.addAttribute("employeeList",employeeList);
		theModel.addAttribute("orderStatusList",orderStatusList);		
		theModel.addAttribute("orderTypeList",orderTypeList);
		theModel.addAttribute("customerList",customerList);
		

		
		
		//Send to form to pre-populate	to update	
		return "/order/orderupdate" ;
		   
	}
	
	//Delete order
	@GetMapping("/delete")
	public String delete(@RequestParam("orderId") int theId , Model theModel) {
		
		//Get Employee
		Order theOrder = orderService.findById(theId);

		//Checking if order is null 
		if(theOrder==null) {
			throw new RuntimeException("Order Id not found" + theId);
		}
	    orderService.deleteById(theId);
		
			
		return "redirect:/order/findAll";
		   
	}
	
	
	//ajax test order
//		@PostMapping("/add")
//		public String add(@RequestParam("orderId") int theId , Model theModel) {
//			
//				System.out.println("Ajax called");
//			return "scccesss";
//			   
//		}
		
		@PostMapping("/add/{id}")
		public ResponseEntity<Void> saveOrUpdateCompany(@PathVariable Integer id,HttpSession session) {
			//crudService.saveOrUpdateCompany(company);
			
            Order order = (Order) session.getAttribute("order");
            
            System.out.println(order);

			System.out.println("Ajax called");

			return new ResponseEntity<Void>(HttpStatus.OK);
		}


}
