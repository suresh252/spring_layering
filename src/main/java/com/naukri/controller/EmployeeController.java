package com.naukri.controller;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naukri.daos.EmployeeHiberDao;
import com.naukri.daos.interf.IEmployee;
import com.naukri.pojos.Employee;
import com.naukri.pojos.Student;
import com.naukri.validation.Validation;

@Controller
public class EmployeeController {
	@Autowired
	private IEmployee dao;
	
	@Autowired
	private Student std1;
	
	@Autowired
	private Student std2;
	
	@RequestMapping(value = "/saveEmp", method = RequestMethod.POST)
	public String saveEmployee(Employee emp) {

		System.out.println("Entered into saveEmployee :: EmployeeController");

		System.out.println("================");
		System.out.println(emp.getEmpId());
		System.out.println(emp.getName());
		System.out.println(emp.getDesignation());
		System.out.println(emp.getMobile());
		System.out.println(emp.getPassword());
		System.out.println("================");

		System.out.println("Spring IOC starting=====================");

		
		std1.setStdId(101);
		std1.setName("suresh");
		std1.setCollege("jntu");
		
		std2.setStdId(102);
		std2.setName("ramesh");
		std2.setCollege("Osmania");

		System.out.println(std1.getStdId() + "--" + std1.getName() + "--" + std1.getCollege());
		
		System.out.println(std2.getStdId() + "--" + std2.getName() + "--" + std2.getCollege());

		System.out.println("Spring IOC ending=====================");

		Validation valid = new Validation();

		if (valid.nullCheck(emp.getMobile()) || valid.nullCheck(emp.getName())) {

			return "home";
		}
		/*
		 * if(valid.isValid(emp.getMobile())) {
		 * 
		 * return "home"; }
		 */
		EmployeeHiberDao dao = new EmployeeHiberDao();

		dao.saveEmployee(emp);
		System.out.println("Exited from saveEmployee :: EmployeeController");
		return "login";
	}

	@RequestMapping(value = "/loginEmp", method = RequestMethod.POST)
	public String loginEmployee(Employee emp, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("Entered into loginEmployee :: EmployeeController");
		System.out.println(emp.getMobile());
		System.out.println(emp.getPassword());

		// Validation Logic
		Validation valid = new Validation();
		if (valid.nullCheck(emp.getMobile()) || valid.nullCheck(emp.getPassword())) {
			model.addAttribute("message", "Mobile or Password should not be empty !!!!");
			return "login";
		}

		// fetch data for mobile and password
		// EmployeeHiberDao dao = new EmployeeHiberDao();
		// EmployeeJdbcDao dao = new EmployeeJdbcDao();
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
		System.out.println("Exited from into loginEmployee :: EmployeeController");
		return "profile";

	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public String deleteEmployee(@RequestParam("mobile") String mobile, Model model) {

		System.out.println("mobile no is : " + mobile);

		Configuration configuration = new Configuration().configure();
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("delete from Employee where mobile=:mobile");
		query.setParameter("mobile", mobile);
		int result = query.executeUpdate();
		session.beginTransaction().commit();

		Query quaryAll = session.createQuery("from Employee");
		List<Employee> empList = quaryAll.list();
		model.addAttribute("emp1", empList);

		System.out.println("commited");
		System.out.println("result is:" + result);

		return "profile";
	}

}
