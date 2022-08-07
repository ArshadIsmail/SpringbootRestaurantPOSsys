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

import com.resturantmanagement.resturantmanagement.models.CustomerStatus;
import com.resturantmanagement.resturantmanagement.services.CustomerStatusService;

@Controller
@RequestMapping("/customerStatus")
public class CustomerStatusController {
	@Autowired
	private CustomerStatusService customerStatusService;

	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<CustomerStatus> theCustomerStatuses = customerStatusService.findAll();
		model.addAttribute("CustomerStatuses", theCustomerStatuses);

		return "customer_status/customer_status";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		CustomerStatus theCustomerStatus = new CustomerStatus();
		theModel.addAttribute("customerStatus", theCustomerStatus);

		return "customer_status/create";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("customerStatus") CustomerStatus theCustomerStatus) {

		customerStatusService.save(theCustomerStatus);
		return "redirect:/customerStatus/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("customerStatusId") int theId, Model theModel) {

		CustomerStatus theCustomerStatus = customerStatusService.findById(theId);
		theModel.addAttribute("customerStatus", theCustomerStatus);

		return "/customer_status/create";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("customerStatusId") int theId, Model theModel) {

		CustomerStatus theCustomerStatus = customerStatusService.findById(theId);

		if (theCustomerStatus == null) {
			throw new RuntimeException("Employee Id not found" + theId);
		}
		customerStatusService.deleteById(theId);

		return "redirect:/customerStatus/findAll";

	}

}
