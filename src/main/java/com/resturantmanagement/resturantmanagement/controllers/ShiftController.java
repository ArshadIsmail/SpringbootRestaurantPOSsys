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

import com.resturantmanagement.resturantmanagement.models.Shift;
import com.resturantmanagement.resturantmanagement.services.ShiftService;

@Controller
@RequestMapping("/shift")
public class ShiftController {

	@Autowired
	private ShiftService shiftService;

	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<Shift> theShifts = shiftService.findAll();
		model.addAttribute("Shifts", theShifts);

		return "shift/shift";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		Shift theShift = new Shift();
		theModel.addAttribute("shift", theShift);

		return "shift/create";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("shift") Shift theShift) {

		shiftService.save(theShift);

		return "redirect:/shift/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("shiftId") int theId, Model theModel) {

		Shift theShift = shiftService.findById(theId);
		theModel.addAttribute("shift", theShift);

		return "/shift/create";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("shiftId") int theId, Model theModel) {

		Shift theShift = shiftService.findById(theId);

		if (theShift == null) {
			throw new RuntimeException("Shift Id not found" + theId);
		}
		shiftService.deleteById(theId);

		return "redirect:/shift/findAll";

	}

}
