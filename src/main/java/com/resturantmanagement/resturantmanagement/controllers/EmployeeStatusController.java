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

import com.resturantmanagement.resturantmanagement.models.EmployeeStatus;
import com.resturantmanagement.resturantmanagement.services.EmployeeStatusService;

@Controller
@RequestMapping("/employeeStatus")
public class EmployeeStatusController {

	@Autowired
	private EmployeeStatusService employeeStatusService;

	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<EmployeeStatus> theEmployeeStatuses = employeeStatusService.findAll();
		model.addAttribute("EmployeeStatuses", theEmployeeStatuses);

		return "employee_status/employee_status";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		EmployeeStatus theEmployeeStatus = new EmployeeStatus();
		theModel.addAttribute("employeeStatus", theEmployeeStatus);

		return "employee_status/create";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("employeeStatus") EmployeeStatus theEmployeeStatus) {

		employeeStatusService.save(theEmployeeStatus);

		return "redirect:/employeeStatus/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("employeeStatusId") int theId, Model theModel) {

		EmployeeStatus theEmployeeStatus = employeeStatusService.findById(theId);
		theModel.addAttribute("employeeStatus", theEmployeeStatus);

		return "/employee_status/create";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeStatusId") int theId, Model theModel) {

		EmployeeStatus theEmployeeStatus = employeeStatusService.findById(theId);

		if (theEmployeeStatus == null) {
			throw new RuntimeException("employee status Id not found" + theId);
		}
		employeeStatusService.deleteById(theId);

		return "redirect:/employeeStatus/findAll";

	}

}
