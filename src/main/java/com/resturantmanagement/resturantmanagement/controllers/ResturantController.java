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

import com.resturantmanagement.resturantmanagement.models.Resturant;
import com.resturantmanagement.resturantmanagement.services.ResturantService;

@Controller
@RequestMapping("/resturant")
public class ResturantController {

	@Autowired
	private ResturantService resturantService;

	@GetMapping("/findAll")
	public String findAll(Model themodel) {

		List<Resturant> theResturants = resturantService.findAll();
		themodel.addAttribute("resturantDetails", theResturants);

		Resturant theResturant = resturantService.findById(1);
		themodel.addAttribute("resturant", theResturant);

		return "resturant/resturant";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		Resturant theResturant = new Resturant();
		theModel.addAttribute("resturant", theResturant);

		return "resturant/create";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("resturant") Resturant theResturant) {

		resturantService.save(theResturant);

		return "redirect:/resturant/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("resturantId") int theId, Model theModel) {

		Resturant theResturant = resturantService.findById(theId);
		theModel.addAttribute("resturant", theResturant);

		return "/resturant/create";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("resturantId") int theId, Model theModel) {

		Resturant theResturant = resturantService.findById(theId);

		if (theResturant == null) {
			throw new RuntimeException("Resturant Id not found" + theId);
		}
		resturantService.deleteById(theId);

		return "redirect:/resturant/findAll";

	}

}
