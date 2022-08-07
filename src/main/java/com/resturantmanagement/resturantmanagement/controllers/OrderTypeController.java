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

import com.resturantmanagement.resturantmanagement.models.OrderType;
import com.resturantmanagement.resturantmanagement.services.OrderTypeService;

@Controller
@RequestMapping("/orderType")
public class OrderTypeController {

	@Autowired
	private OrderTypeService orderTypeService;

	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<OrderType> theOrderTypes = orderTypeService.findAll();
		model.addAttribute("OrderTypes", theOrderTypes);

		return "order_type/order_type";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		OrderType theOrderType = new OrderType();
		theModel.addAttribute("orderType", theOrderType);

		return "order_type/create";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("orderType") OrderType theOrderType) {

		orderTypeService.save(theOrderType);

		return "redirect:/orderType/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("orderTypeId") int theId, Model theModel) {

		OrderType theOrderType = orderTypeService.findById(theId);
		theModel.addAttribute("orderType", theOrderType);

		return "/order_type/create";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("orderTypeId") int theId, Model theModel) {

		OrderType theOrderType = orderTypeService.findById(theId);

		if (theOrderType == null) {
			throw new RuntimeException("Employee Id not found" + theId);
		}
		orderTypeService.deleteById(theId);

		return "redirect:/orderType/findAll";

	}

}
