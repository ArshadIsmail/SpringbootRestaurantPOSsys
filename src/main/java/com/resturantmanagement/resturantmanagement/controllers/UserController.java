package com.resturantmanagement.resturantmanagement.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.resturantmanagement.resturantmanagement.models.Employee;
import com.resturantmanagement.resturantmanagement.models.Order;
import com.resturantmanagement.resturantmanagement.models.Role;
import com.resturantmanagement.resturantmanagement.models.User;
import com.resturantmanagement.resturantmanagement.models.UserRole;
import com.resturantmanagement.resturantmanagement.models.UserStatus;
import com.resturantmanagement.resturantmanagement.repositories.RoleRepository;
import com.resturantmanagement.resturantmanagement.services.RoleService;
import com.resturantmanagement.resturantmanagement.services.UserService;
import com.resturantmanagement.resturantmanagement.services.UserStatusService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserStatusService userStatusService;

	// Modified method to Add a new user User
	@PostMapping("addNew")
	public String addNew(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
			RedirectAttributes redirectAttribute, Model theModel) {

		if (bindingResult.hasErrors()) {

			return "auth/auth-register";
		}

		user.setRoles(roleService.getDefaulRole());
		user.setUserStatus(userStatusService.getDefaulUserStatus());
		userService.save(user);

		theModel.addAttribute("SignUpSuccessMsg", "Successfully signed up.Login to access the system");

		return "auth/auth-login";

	}

	// Listing all users
	@GetMapping("/findAll")
	public String findAll(Model theModel) {

		List<User> theUsers = userService.findAll();
		theModel.addAttribute("Users", theUsers);

		return "user/user_list";

	}

	@GetMapping("/edit")
	public String edit(@RequestParam("userId") int theId, Model theModel) {

		User user = userService.findById(theId);

		boolean edit_allowed = false;
		// Checking whether admin or Same user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
			edit_allowed = true;

		} else {
			if (auth.getName().equals(user.getUsername())) {
				edit_allowed = true;

			}

		}

		// Find user details
		if (edit_allowed) {

			List<Role> roles = roleService.findAll();

			List<UserStatus> theUserStatus = userStatusService.findAll();

			theModel.addAttribute("user", user);
			theModel.addAttribute("rolesList", roles);
			theModel.addAttribute("theUserStatusList", theUserStatus);

			return "user/form_elements - Copy";
		} else {

			return "redirect:/user/findAll";

		}

	}

	@PostMapping("/update")
	public String updat(@ModelAttribute("user") User formUser, Model theModel) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		boolean currentUserDetailChange = false;

		User user = userService.findById(formUser.getId());

		// User changing his/her details
		if (auth.getName().equals(user.getUsername())) {
			currentUserDetailChange = true;
		}

		user.setUsername(formUser.getUsername());

		if (formUser.getPassword() != "") {
			user.setPassword(formUser.getPassword());
		}

		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
			user.setRoles(formUser.getRoles());
			user.setUserStatus(formUser.getUserStatus());

		} else {
			// do nothing

		}

		userService.save(user);

		if (currentUserDetailChange) {
			return "redirect:/logout";

		} else {
			return "redirect:/user/findAll";
		}

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("userId") int theId, Model theModel) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		boolean adminUser = false;
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
			adminUser = true;
		}

		if (adminUser) {
			userService.deleteById(theId);
			System.out.println("user is admin;So deleted");
			return "redirect:/user/findAll";
		} else {
			return "redirect:/user/findAll";

		}

	}
}
