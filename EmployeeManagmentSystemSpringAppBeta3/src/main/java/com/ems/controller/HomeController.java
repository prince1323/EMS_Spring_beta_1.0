package com.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController 
{
	
	/*
	 * This method take us the home page of the web app
	 * 
	 * Request Path: { "/" }  return: index.html
	 */
	@GetMapping("/")
	public String showLandingPage(Model model) {
		return "index";
	}
}
