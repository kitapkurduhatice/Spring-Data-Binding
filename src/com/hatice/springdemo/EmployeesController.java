package com.hatice.springdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeesController {
	public static String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	public static Connection myConn;
	public static int updated;
	Employees employees;
	@RequestMapping("/")
	public String showHomePage() {
		return "main-menu";
	}

	@RequestMapping("/login")
	public String doLogin(@RequestParam("employeesId") String employeesId, Model model) {
		Employees employee = LoginService.getEmployees(Integer.valueOf(employeesId));

		if (employee != null) {
			model.addAttribute("employee", employee);
			return "employees-form";
		}
		model.addAttribute("mesaj", "Not exist employee");
		return "main-menu";
		
		
	}

	@RequestMapping("/save")
	public String saveEmployees(@ModelAttribute("employee") Employees employees,Model model) throws SQLException { // burada
																										// isimlendirme
																									// yapýlýyor..
		Employees e = updateEmployees(employees);
		if(updated==1) {
			model.addAttribute("message","Successful");
			model.addAttribute("employee",e);
		}
		else {
			model.addAttribute("message","Unsuccessful");
		}
		
		System.out.println("Employees : " + " " + e.getEmployeesId() + " " + e.getFirstName() + " " + e.getLastName()
				+ "-" + e.getSalary());
		return "employees-form";
	}

	public static Employees updateEmployees(Employees employees) throws SQLException {

		myConn = DriverManager.getConnection(dbUrl, "hr", "hr");
		PreparedStatement stmt = myConn.prepareStatement(
				"UPDATE employees SET first_name=?, last_name=?, salary=? Where employee_id=?");

		stmt.setString(1, employees.getFirstName());
		stmt.setString(2, employees.getLastName());
		stmt.setInt(3, employees.getSalary());
		stmt.setInt(4, employees.getEmployeesId());
		updated=stmt.executeUpdate();
		

		return employees;

	}

}
