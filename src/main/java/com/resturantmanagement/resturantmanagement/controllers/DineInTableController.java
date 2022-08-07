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

import com.resturantmanagement.resturantmanagement.models.DineInTable;
import com.resturantmanagement.resturantmanagement.services.DineInTableService;

@Controller
@RequestMapping("/dineInTable")
public class DineInTableController {

	@Autowired
	DineInTableService dineInTableService;

	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<DineInTable> theDineInTables = dineInTableService.findAll();
		model.addAttribute("DineInTables", theDineInTables);

		return "dine_in_table/dine_in_table";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		DineInTable theDineInTable = new DineInTable();
		theModel.addAttribute("dineInTable", theDineInTable);

		return "dine_in_table/create";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("dineInTable") DineInTable theDineInTable) {

		dineInTableService.save(theDineInTable);

		return "redirect:/dineInTable/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("dineInTableId") int theId, Model theModel) {

		DineInTable theDineInTable = dineInTableService.findById(theId);
		theModel.addAttribute("dineInTable", theDineInTable);

		return "/dine_in_table/create2";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("dineInTableId") int theId, Model theModel) {

		DineInTable theDineInTable = dineInTableService.findById(theId);

		if (theDineInTable == null) {
			throw new RuntimeException("Employee Id not found" + theId);
		}
		dineInTableService.deleteById(theId);

		return "redirect:/dineInTable/findAll";

	}

}
