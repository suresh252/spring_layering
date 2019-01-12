package com.naukri.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;

import com.naukri.daos.EmployeeHiberDao;
import com.naukri.pojos.Employee;
import com.naukri.validation.Validation;

public class EmployeeSerivice {
	
	/*
	public String saveEmployee(Employee emp) {
		System.out.println("Entered into saveEmployee :: EmployeeService");

		System.out.println("================");
		System.out.println(emp.getEmpId());
		System.out.println(emp.getName());
		System.out.println(emp.getDesignation());
		System.out.println(emp.getMobile());
		System.out.println(emp.getPassword());
		System.out.println("================");
		
		Validation valid = new Validation();

		if (valid.nullCheck(emp.getMobile()) || valid.nullCheck(emp.getName())) {

			return "home";
		}
		if(valid.isValid(emp.getMobile())) {
			
			return "home";
		}
		EmployeeHiberDao dao = new EmployeeHiberDao();

		dao.saveEmployee(emp);
		System.out.println("Exited from saveEmployee :: EmployeeService");

		return "login";
	}

	public String loginEmployee(Employee emp, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("Entered into loginEmployee :: EmployeeService");

		System.out.println(emp.getMobile());
		System.out.println(emp.getPassword());

		// Validation Logic
		Validation valid = new Validation();
		if (valid.nullCheck(emp.getMobile()) || valid.nullCheck(emp.getPassword())) {
			model.addAttribute("message", "Mobile or Password should not be empty !!!!");
			return "login";
		}

		// fetch data for mobile and password
		 EmployeeHiberDao dao = new EmployeeHiberDao();
		//EmployeeJdbcDao dao = new EmployeeJdbcDao();
		List<Employee> list = dao.loginEmployee(emp);

		// validate list
		if (list.isEmpty()) {
			model.addAttribute("message", "Invalid credentials please try again !!!!");
			return "login";
		}
		// getAll Employees
		List<Employee> empList = dao.getAllEmployees();

		model.addAttribute("emp1", empList);

		for (Employee employee : empList) {
			System.out.println(employee.getEmpId() + "--" + employee.getName() + "--" + employee.getDesignation() + "--"
					+ employee.getMobile() + "--" + employee.getPassword());
		}

		model.addAttribute("msg", emp.getMobile());
		System.out.println("Exited from loginEmployee :: EmployeeService");
		return "profile";

	}
*/
}
