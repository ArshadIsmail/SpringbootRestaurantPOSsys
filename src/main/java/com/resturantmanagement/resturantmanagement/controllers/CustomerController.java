package com.resturantmanagement.resturantmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.resturantmanagement.resturantmanagement.models.Customer;
import com.resturantmanagement.resturantmanagement.models.CustomerStatus;
import com.resturantmanagement.resturantmanagement.models.Gender;
import com.resturantmanagement.resturantmanagement.services.CustomerService;
import com.resturantmanagement.resturantmanagement.services.CustomerStatusService;
import com.resturantmanagement.resturantmanagement.services.GenderService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private GenderService genderService;

	@Autowired
	private CustomerStatusService customerStatusService;

	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<Customer> theCustomers = customerService.findAll();
		model.addAttribute("Customers", theCustomers);

		return "customer/customer2";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		List<Gender> genderList = genderService.findAll();
		List<CustomerStatus> customerStatusList = customerStatusService.findAll();
		theModel.addAttribute("genderlist", genderList);
		theModel.addAttribute("customerStatusList", customerStatusList);

		return "customer/create2";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer theCustomer) {

		customerService.save(theCustomer);
		return "redirect:/customer/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("customerId") int theId, Model theModel) {

		Customer theCustomer = customerService.findById(theId);
		theModel.addAttribute("customer", theCustomer);
		List<Gender> genderList = genderService.findAll();
		List<CustomerStatus> customerStatusList = customerStatusService.findAll();
		theModel.addAttribute("genderlist", genderList);
		theModel.addAttribute("customerStatusList", customerStatusList);

		return "/customer/create2";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId, Model theModel) {

		Customer theCustomer = customerService.findById(theId);

		if (theCustomer == null) {
			throw new RuntimeException("Customer Id not found" + theId);
		}

		customerService.deleteById(theId);

		return "redirect:/customer/findAll";

	}

}
