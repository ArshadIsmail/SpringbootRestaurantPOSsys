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

import com.resturantmanagement.resturantmanagement.models.DeliveryStatus;
import com.resturantmanagement.resturantmanagement.services.DeliveryStatusService;

@Controller
@RequestMapping("/deliveryStatus")
public class DeliveryStatusController {
	@Autowired
	private DeliveryStatusService deliveryStatusService;

	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<DeliveryStatus> theDeliveryStatuses = deliveryStatusService.findAll();
		model.addAttribute("DeliveryStatuses", theDeliveryStatuses);

		return "delivery_status/delivery_status";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		DeliveryStatus theDeliveryStatus = new DeliveryStatus();
		theModel.addAttribute("deliveryStatus", theDeliveryStatus);

		return "delivery_status/create";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("deliveryStatus") DeliveryStatus theDeliveryStatus) {

		deliveryStatusService.save(theDeliveryStatus);

		return "redirect:/deliveryStatus/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("deliveryStatusId") int theId, Model theModel) {

		DeliveryStatus theDeliveryStatus = deliveryStatusService.findById(theId);
		theModel.addAttribute("deliveryStatus", theDeliveryStatus);

		return "/delivery_status/create";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("deliveryStatusId") int theId, Model theModel) {

		DeliveryStatus theDeliveryStatus = deliveryStatusService.findById(theId);

		if (theDeliveryStatus == null) {
			throw new RuntimeException("DeliveryStatus Id not found" + theId);
		}
		deliveryStatusService.deleteById(theId);

		return "redirect:/deliveryStatus/findAll";

	}
}
