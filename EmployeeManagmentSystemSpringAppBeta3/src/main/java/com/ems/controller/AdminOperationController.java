package com.ems.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.ems.entity.AdminEntity;
import com.ems.entity.DepartmentEntity;
import com.ems.entity.EmployeeEntity;
//import com.ems.service.AdminServiceImp;
import com.ems.service.EmployeeServiceImpl;
import com.ems.service.IDepartmentServiceImpl;
import com.ems.service.IProjectServiceImpl;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminOperationController {

//	// Admin Service class object
//	@Autowired
//	private AdminServiceImp adServ;

	// Employee Service class object
	@Autowired
	private EmployeeServiceImpl empSer;
	
	// Department Service class object
	@Autowired
	private IDepartmentServiceImpl deptSer;
	
	// Project Service class object
	@Autowired
	private IProjectServiceImpl projSer;

	/*
	 * This method will show the admin dashboard view to the admin on the successful
	 * login.
	 * 
	 * Request Path: { "/admin/dashboard" } Return: adminDashboard.html
	 * 
	 * In this method we'll fetch the employee count detail and set as an attribute
	 * to the Model class In this method we'll fetch the department count detail and
	 * set as an attribute to the Model class In this method we'll fetch the project
	 * count detail and set as an attribute to the Model class
	 */
	@GetMapping("/admin/dashboard")
	public String showAdminDashBoard(Model model, HttpSession session) { // Inject HttpSession

		// Check if admin is logged in
		AdminEntity loggedInAdmin = (AdminEntity) session.getAttribute("loggedInAdmin");
		
		if (loggedInAdmin == null) {
			// If not logged in, redirect to login page
			return "redirect:/admin";
		}

		// Add admin details to model for display on dashboard if needed
		model.addAttribute("adminUsername", loggedInAdmin.getUsername());

		// Add employee counts to model for display on dashboard if needed
		Integer totalEmp = empSer.getEmployeesCount().get();
		model.addAttribute("totalEmployees", totalEmp);

		// Add department counts to model for display on dashboard if needed
		Integer totalDept = deptSer.getDepartmentCount().get();;
		model.addAttribute("totalDepartment", totalDept);
		
		

		// Add department counts to model for display on dashboard if needed
		Integer totalProj = projSer.getProjectCount().get();
		model.addAttribute("totalProject", totalProj);

		return "adminDashboard";
	}

	/*
	 * This method will give me the employee list contains their details.
	 * 
	 * Request Path: { "/admin/employeeList" } return: adminEmployeeList.html
	 * 
	 */

	@GetMapping("/admin/employeeList")
	public String showAdminEmployeeListBoard(Model model, HttpSession session) { // Inject HttpSession
		// Check if admin is logged in
		AdminEntity loggedInAdmin = (AdminEntity) session.getAttribute("loggedInAdmin");
		if (loggedInAdmin == null) {
			return "redirect:/admin";
		}
		
		// Add admin details to model for display on dashboard if needed
		model.addAttribute("adminUsername", loggedInAdmin.getUsername());
		
		Optional<List<EmployeeEntity>> empls = empSer.getAllEmployees();
		model.addAttribute("employees", empls.get());
		return "adminEmployeeList";
	}

	/*
	 * This method will give me the department list contains their details.
	 * 
	 * Request Path: { "/admin/departmentList" } return: adminDepartmentList.html
	 * 
	 */

	@GetMapping("/admin/departmentList")
	public String showAdminDepartmentListBoard(Model model, HttpSession session) { // Inject HttpSession
		// Check if admin is logged in
		AdminEntity loggedInAdmin = (AdminEntity) session.getAttribute("loggedInAdmin");
		if (loggedInAdmin == null) {
			// If not logged in, redirect to login page
			return "redirect:/admin";
		}
		// Add admin details to model for display on dashboard if needed
		model.addAttribute("adminUsername", loggedInAdmin.getUsername());
		
		Optional<List<DepartmentEntity>> depList = deptSer.getDepartmentList();
		model.addAttribute("departments", depList.get());
		return "adminDepartmentList";
	}

	/*
	 * This method will give me the form to add the new employee to the
	 * organization.
	 * 
	 * Request Path: { "/admin/addEmployee" } return: addEmployeeForm.html
	 * 
	 * Once the user will click on the add employee button then the request will go
	 * to { "/admin/saveEmployee" }
	 * 
	 */

	@GetMapping("/admin/addEmployee")
	public String showAdminAddEmployeeForm(Model model, HttpSession session) {
		AdminEntity loggedInAdmin = (AdminEntity) session.getAttribute("loggedInAdmin");
		if (loggedInAdmin == null) {
			return "redirect:/admin";
		}
		model.addAttribute("employee", new EmployeeEntity());
		return "addEmployeeForm";
	}

	/*
	 * This method will save the employee in the database if everything is fine.
	 * 
	 * Request Path: { "/admin/saveEmployee" } return: adminDashboard.html
	 */

	@PostMapping("/admin/saveEmployee")
	public String addEmployeeOperation(ServletRequest req, @ModelAttribute("employee") EmployeeEntity emp, Model model,
			HttpSession session) {

		AdminEntity loggedInAdmin = (AdminEntity) session.getAttribute("loggedInAdmin");
		if (loggedInAdmin == null) {
			return "redirect:/admin";
		}
		empSer.addEmployee(emp);
		req.getRequestDispatcher("/admin/dashboard");
		return "redirect:/admin/employeeList";
	}

	/*
	 * This method simply invalidate the session and logs out the user and then
	 * redirect the user to /admin
	 * 
	 * Request Path: { "/admin/logout" } return: "redirect:/admin"
	 */

	@GetMapping("/admin/logout")
	public String adminLogout(HttpSession session) {
		session.invalidate(); // Invalidate the session
		return "redirect:/admin"; // Redirect to login page
	}
	
	
	//Edit employee
	@GetMapping("/employees/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
	    Optional<EmployeeEntity> emp = empSer.getEmployeeById(id);
	    model.addAttribute("employee", emp.get());
	    return "editEmployee"; 
	}
	
	@PostMapping("/employees/update")
	public String updateEmployee(@ModelAttribute("employee") EmployeeEntity employee) {
	    empSer.updateEmployee(employee);
	    return "redirect:/admin/employeeList";
	}
	
	
	// delete employee
	@GetMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
	    empSer.deleteEmployeeById(id);
	    return "redirect:/admin/employeeList";
	}
}
