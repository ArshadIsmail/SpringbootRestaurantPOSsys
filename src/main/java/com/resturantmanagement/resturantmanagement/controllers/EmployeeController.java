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
import com.resturantmanagement.resturantmanagement.models.Employee;
import com.resturantmanagement.resturantmanagement.models.EmployeeStatus;
import com.resturantmanagement.resturantmanagement.models.Gender;
import com.resturantmanagement.resturantmanagement.models.Shift;
import com.resturantmanagement.resturantmanagement.services.DesignationService;
import com.resturantmanagement.resturantmanagement.services.EmployeeService;
import com.resturantmanagement.resturantmanagement.services.EmployeeStatusService;
import com.resturantmanagement.resturantmanagement.services.GenderService;
import com.resturantmanagement.resturantmanagement.services.ShiftService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private GenderService genderService;
	
	@Autowired
	private EmployeeStatusService employeeStatusService;
	
	@Autowired
	private ShiftService shiftService;
	
	
	@Autowired
	private DesignationService designationService;
	
	 

	
	
	
	//Listing all employees
	@GetMapping("/findAll")
	public String findAll(Model model) {
		
		//Getting list of Employees from employee service
		List<Employee> theEmployees=employeeService.findAll();
		
		//Binding into Model
		model.addAttribute("Employees",theEmployees);
		
	
	    return "employee/employee2";
		
	}
	
	
	
	//Add employee form
	@GetMapping("/create")
	public String create(Model theModel) {
				
		
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee",theEmployee);
		
		List<Gender> genderList =genderService.findAll();
		List<EmployeeStatus> employeeStatusList=employeeStatusService.findAll();
		List<Shift> shiftList=shiftService.findAll();
		List<Designation> designationList=designationService.findAll();
		
		
		
		theModel.addAttribute("genderlist",genderList);
		theModel.addAttribute("employeeStatusList",employeeStatusList);
		theModel.addAttribute("shiftList",shiftList);
		theModel.addAttribute("designationList",designationList);


		
		return "employee/create";
	}
	
	
	
	
	@PostMapping("/save")  //save employee
	public String save(@ModelAttribute("employee") Employee theEmployee ) {
		
		//Saving employee
		employeeService.save(theEmployee);
		
		
		//Redirecting
		return "redirect:/employee/findAll";
		   
	}
	
	
	//Update employee
	@GetMapping("/update")
	public String update(@RequestParam("employeeId") int theId , Model theModel) {
		
		
		//Get the Employee from the service layer
		Employee theEmployee = employeeService.findById(theId);
		
		//Add to Model
		theModel.addAttribute("employee",theEmployee);
		
		
		List<Gender> genderList =genderService.findAll();
		List<EmployeeStatus> employeeStatusList=employeeStatusService.findAll();
		List<Shift> shiftList=shiftService.findAll();
		List<Designation> designationList=designationService.findAll();
		
		
		
		theModel.addAttribute("genderlist",genderList);
		theModel.addAttribute("employeeStatusList",employeeStatusList);
		theModel.addAttribute("shiftList",shiftList);
		theModel.addAttribute("designationList",designationList);



		
		//Send to form to pre-populate	to update	
		return "/employee/create" ;
		   
	}
	
	//Delete employee
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId , Model theModel) {
		
		//Get Employee
		Employee theEmployee = employeeService.findById(theId);

		//Checking if employee is null 
		if(theEmployee==null) {
			throw new RuntimeException("Employee Id not found" + theId);
		}
	    employeeService.deleteById(theId);
		
			
		return "redirect:/employee/findAll";
		   
	}

	

}
