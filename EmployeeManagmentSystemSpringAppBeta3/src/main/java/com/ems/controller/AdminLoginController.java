package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ems.entity.AdminEntity;
import com.ems.service.AdminServiceImp;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminLoginController {

	// Admin Service class object
	@Autowired
	private AdminServiceImp adServ;

	/*
	 * This method take us to the admin login page
	 * 
	 * Request Path: { "/admin" } return: adminLogin.html
	 * 
	 */
	@GetMapping("/admin")
	public String showLoginPage(Model model, HttpSession session) {
		// If an admin is already logged in, redirect to dashboard
		if (session.getAttribute("loggedInAdmin") != null) {
			return "redirect:/admin/dashboard";
		}
		return "adminLogin";
	}

	/*
	 * This method contains the business logic to login the user and create the
	 * session if everything is fine
	 * 
	 * Request Path: { "/admin/login" } return: "redirect:/admin/dashboard"
	 * 
	 */
	@PostMapping("/admin/login")
	public String handleAdminLogin(@RequestParam String username, @RequestParam String password, Model model,
			HttpSession session) {
		AdminEntity adminLogin = adServ.AdminLogin(username, password);
		if (adminLogin != null) {
			session.setAttribute("loggedInAdmin", adminLogin);
			return "redirect:/admin/dashboard";
		} else {
			model.addAttribute("errorMessage", "Invalid username or password.");
			return "adminLogin";
		}
	}
}
