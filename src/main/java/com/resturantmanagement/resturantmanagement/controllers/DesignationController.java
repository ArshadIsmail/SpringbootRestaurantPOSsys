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

import com.resturantmanagement.resturantmanagement.models.Designation;
import com.resturantmanagement.resturantmanagement.services.DesignationService;

@Controller
@RequestMapping("/designation")
public class DesignationController {
	@Autowired
	private DesignationService designationService;

	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<Designation> theDesignations = designationService.findAll();
		model.addAttribute("Designations", theDesignations);

		return "designation/designation";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		Designation theDesignation = new Designation();
		theModel.addAttribute("designation", theDesignation);

		return "designation/create";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("designation") Designation theDesignation) {

		designationService.save(theDesignation);

		return "redirect:/designation/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("designationId") int theId, Model theModel) {

		Designation theDesignation = designationService.findById(theId);
		theModel.addAttribute("designation", theDesignation);

		return "/designation/create";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("designationId") int theId, Model theModel) {

		Designation theDesignation = designationService.findById(theId);

		if (theDesignation == null) {
			throw new RuntimeException("Designation Id not found" + theId);
		}
		designationService.deleteById(theId);

		return "redirect:/designation/findAll";

	}
}
