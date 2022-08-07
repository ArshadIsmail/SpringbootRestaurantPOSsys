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

import com.resturantmanagement.resturantmanagement.models.OrderMenu;
import com.resturantmanagement.resturantmanagement.models.Gender;
import com.resturantmanagement.resturantmanagement.services.OrderMenuService;
import com.resturantmanagement.resturantmanagement.services.GenderService;

@Controller
@RequestMapping("/orderMenu")
public class OrderMenuController {

	@Autowired
	private OrderMenuService orderMenuService;

	@Autowired
	private GenderService genderService;

	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<OrderMenu> theOrderMenus = orderMenuService.findAll();
		model.addAttribute("OrderMenus", theOrderMenus);

		return "orderMenu/orderMenu";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		OrderMenu theOrderMenu = new OrderMenu();
		theModel.addAttribute("orderMenu", theOrderMenu);

		List<Gender> genderList = genderService.findAll();
		theModel.addAttribute("genderlist", genderList);

		return "orderMenu/create";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("orderMenu") OrderMenu theOrderMenu) {

		orderMenuService.save(theOrderMenu);

		return "redirect:/orderMenu/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("orderMenuId") int theId, Model theModel) {

		OrderMenu theOrderMenu = orderMenuService.findById(theId);
		theModel.addAttribute("orderMenu", theOrderMenu);

		List<Gender> genderList = genderService.findAll();
		theModel.addAttribute("genderlist", genderList);

		return "/orderMenu/create";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("orderMenuId") int theId, Model theModel) {

		OrderMenu theOrderMenu = orderMenuService.findById(theId);

		if (theOrderMenu == null) {
			throw new RuntimeException("OrderMenu Id not found" + theId);
		}
		orderMenuService.deleteById(theId);

		return "redirect:/orderMenu/findAll";

	}

}
