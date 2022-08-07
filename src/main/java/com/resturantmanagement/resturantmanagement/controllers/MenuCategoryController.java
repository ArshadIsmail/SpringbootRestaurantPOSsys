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

import com.resturantmanagement.resturantmanagement.models.MenuCategory;
import com.resturantmanagement.resturantmanagement.services.MenuCategoryService;

@Controller
@RequestMapping("/menuCategory")
public class MenuCategoryController {

	@Autowired
	private MenuCategoryService menuCategoryService;

	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<MenuCategory> theMenuCategory = menuCategoryService.findAll();

		System.out.println(theMenuCategory);
		model.addAttribute("MenuCategory", theMenuCategory);

		return "menu_category/menu_category2";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		MenuCategory theMenuCategory = new MenuCategory();
		theModel.addAttribute("menuCategory", theMenuCategory);

		return "menu_category/create2";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("menuCategory") MenuCategory theMenuCategory) {

		menuCategoryService.save(theMenuCategory);

		return "redirect:/menuCategory/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("menuCategoryId") int theId, Model theModel) {

		MenuCategory theMenuCategory = menuCategoryService.findById(theId);
		theModel.addAttribute("menuCategory", theMenuCategory);

		return "/menu_category/create2";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("menuCategoryId") int theId, Model theModel) {

		MenuCategory theMenuCategory = menuCategoryService.findById(theId);

		if (theMenuCategory == null) {
			throw new RuntimeException("Menu categorys Id not found" + theId);
		}
		menuCategoryService.deleteById(theId);

		return "redirect:/menuCategory/findAll";

	}

}
