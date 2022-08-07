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

import com.resturantmanagement.resturantmanagement.models.MenuStatus;
import com.resturantmanagement.resturantmanagement.services.MenuStatusService;

@Controller
@RequestMapping("/menuStatus")
public class MenuStatusController {

	@Autowired
	private MenuStatusService menuStatusService;

	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<MenuStatus> theMenuStatuses = menuStatusService.findAll();
		model.addAttribute("MenuStatuses", theMenuStatuses);

		return "menu_status/menu_status";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		MenuStatus theMenuStatus = new MenuStatus();
		theModel.addAttribute("menuStatus", theMenuStatus);

		return "menu_status/create";
	}

	@PostMapping("/save") // save menu status
	public String save(@ModelAttribute("menuStatus") MenuStatus theMenuStatus) {

		menuStatusService.save(theMenuStatus);

		return "redirect:/menuStatus/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("menuStatusId") int theId, Model theModel) {

		MenuStatus theMenuStatus = menuStatusService.findById(theId);
		theModel.addAttribute("menuStatus", theMenuStatus);

		return "/menu_status/create";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("menuStatusId") int theId, Model theModel) {

		MenuStatus theMenuStatus = menuStatusService.findById(theId);

		if (theMenuStatus == null) {
			throw new RuntimeException("menu statua Id not found" + theId);
		}
		menuStatusService.deleteById(theId);

		return "redirect:/menuStatus/findAll";

	}

}
