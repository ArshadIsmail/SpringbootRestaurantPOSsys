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

import com.resturantmanagement.resturantmanagement.models.OrderStatus;
import com.resturantmanagement.resturantmanagement.services.OrderStatusService;

@Controller
@RequestMapping("/orderStatus")
public class OrderStatusController {

	@Autowired
	private OrderStatusService orderStatusService;

	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<OrderStatus> theOrderStatuses = orderStatusService.findAll();
		model.addAttribute("OrderStatuses", theOrderStatuses);

		return "order_status/order_status";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		OrderStatus theOrderStatus = new OrderStatus();
		theModel.addAttribute("orderStatus", theOrderStatus);

		return "order_status/create";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("orderStatus") OrderStatus theOrderStatus) {

		orderStatusService.save(theOrderStatus);
		return "redirect:/orderStatus/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("orderStatusId") int theId, Model theModel) {

		OrderStatus theOrderStatus = orderStatusService.findById(theId);
		theModel.addAttribute("orderStatus", theOrderStatus);

		return "/order_status/create";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("orderStatusId") int theId, Model theModel) {

		OrderStatus theOrderStatus = orderStatusService.findById(theId);

		if (theOrderStatus == null) {
			throw new RuntimeException("Employee Id not found" + theId);
		}
		orderStatusService.deleteById(theId);

		return "redirect:/orderStatus/findAll";

	}

}
