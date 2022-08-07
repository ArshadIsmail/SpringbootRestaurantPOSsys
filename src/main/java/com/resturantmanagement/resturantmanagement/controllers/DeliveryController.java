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

import com.resturantmanagement.resturantmanagement.models.Delivery;
import com.resturantmanagement.resturantmanagement.models.DeliveryStatus;
import com.resturantmanagement.resturantmanagement.models.Gender;
import com.resturantmanagement.resturantmanagement.services.DeliveryService;
import com.resturantmanagement.resturantmanagement.services.DeliveryStatusService;
import com.resturantmanagement.resturantmanagement.services.GenderService;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	private DeliveryService deliveryService;

	@Autowired
	private GenderService genderService;

	@Autowired
	private DeliveryStatusService deliveryStatusService;

	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<Delivery> theDeliverys = deliveryService.findAll();
		model.addAttribute("Deliverys", theDeliverys);

		return "delivery/delivery";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		return "redirect:/delivery/findAll";

	}

	@PostMapping("/save")
	public String save(@ModelAttribute("delivery") Delivery theDelivery) {

		deliveryService.save(theDelivery);
		return "redirect:/delivery/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("deliveryId") int theId, Model theModel) {

		return "redirect:/delivery/findAll";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("deliveryId") int theId, Model theModel) {

		return "redirect:/delivery/findAll";
//		   
	}

}
