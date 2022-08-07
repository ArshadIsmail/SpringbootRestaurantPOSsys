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

import com.resturantmanagement.resturantmanagement.models.MenuItem;
import com.resturantmanagement.resturantmanagement.models.MenuStatus;
import com.resturantmanagement.resturantmanagement.models.Gender;
import com.resturantmanagement.resturantmanagement.models.MenuCategory;
import com.resturantmanagement.resturantmanagement.services.MenuItemService;
import com.resturantmanagement.resturantmanagement.services.MenuStatusService;
import com.resturantmanagement.resturantmanagement.services.GenderService;
import com.resturantmanagement.resturantmanagement.services.MenuCategoryService;

@Controller
@RequestMapping("/menuItem")
public class MenuItemController {

	@Autowired
	private MenuItemService menuItemService;

	@Autowired
	private MenuCategoryService menuCatgoryService;

	@Autowired
	private MenuStatusService menuStatusService;

	@GetMapping("/findAll")
	public String findAll(Model model) {

		List<MenuItem> theMenuItems = menuItemService.findAll();
		model.addAttribute("MenuItems", theMenuItems);

		return "menu_item/menu_items";

	}

	@GetMapping("/create")
	public String create(Model theModel) {

		MenuItem theMenuItem = new MenuItem();
		theModel.addAttribute("menuItem", theMenuItem);

		List<MenuStatus> menuStatus = menuStatusService.findAll();
		List<MenuCategory> menuCategory = menuCatgoryService.findAll();

		theModel.addAttribute("menuCategoryList", menuCategory);
		theModel.addAttribute("menuStatusList", menuStatus);

		return "menu_item/create";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("menuItem") MenuItem theMenuItem) {

		menuItemService.save(theMenuItem);

		return "redirect:/menuItem/findAll";

	}

	@GetMapping("/update")
	public String update(@RequestParam("menuItemId") int theId, Model theModel) {

		MenuItem theMenuItem = menuItemService.findById(theId);
		theModel.addAttribute("menuItem", theMenuItem);

		List<MenuStatus> menuStatus = menuStatusService.findAll();
		theModel.addAttribute("menuStatusList", menuStatus);

		List<MenuCategory> menuCategory = menuCatgoryService.findAll();
		theModel.addAttribute("menuCategoryList", menuCategory);

		return "menu_item/create";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("menuItemId") int theId, Model theModel) {

		MenuItem theMenuItem = menuItemService.findById(theId);

		if (theMenuItem == null) {
			throw new RuntimeException("MenuItem Id not found" + theId);
		}
		menuItemService.deleteById(theId);

		return "redirect:/menuItem/findAll";

	}

}
