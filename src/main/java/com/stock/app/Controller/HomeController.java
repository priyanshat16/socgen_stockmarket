package com.stock.app.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stock.app.Services.UserServiceImpl;
import com.stock.app.model.Role;
import com.stock.app.model.UserEntity;
import com.stock.app.model.UserRole;

@Controller
public class HomeController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home - Stock Exchange Manager");
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About - Stock Exchange Manager");
		return "about";
	}

	@RequestMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "Register - Stock Exchange Manager");
		model.addAttribute("user", new UserEntity());
		return "signup";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "Login - Stock Exchange Manager");
		model.addAttribute("user", new UserEntity());
		return "login";
	}
	
	@RequestMapping("/about/signup")
	public String signup1(Model model) {
		model.addAttribute("title", "Register - Stock Exchange Manager");
		model.addAttribute("user", new UserEntity());
		return "signup";
	}

	// handler for registering user
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") UserEntity user,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model)
			throws Exception {
		if (!agreement) {
			System.out.println("You have not agreed the terms and conditions");
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		System.out.println("Agreement" + agreement);
		System.out.println("USER" + user);

		user.setConfirmed(false);

		Role role = new Role();
		role.setRoleName("ROLE_USER");

		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);

		userRoles.add(userRole);

		this.userService.createUser(user, userRoles);
		return "signup";
	}

}
