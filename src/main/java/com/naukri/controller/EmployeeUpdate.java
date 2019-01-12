package com.naukri.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.naukri.pojos.Employee;

@Controller
public class EmployeeUpdate {

	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public String editEmployee(@RequestParam("mobile") String mobile, Model model) {

		Configuration configuration = new Configuration().configure();
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();

		Employee emp = session.get(Employee.class, mobile);
		model.addAttribute("employee", emp);

		System.out.println("edit mode is enable: " + mobile);

		return "edit";
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(Employee emp, Model model) {

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		System.out.println("entered into update page");
		Query query = session.createQuery(
				"update Employee set empId=:empId, name=:name, designation=:designation, password=:password where mobile=:mobile");

		query.setParameter("empId", emp.getEmpId());
		query.setParameter("name", emp.getName());
		query.setParameter("designation", emp.getDesignation());
		query.setParameter("password", emp.getPassword());
		query.setParameter("mobile", emp.getMobile());
		
		int result = query.executeUpdate();
		System.out.println("exited into executeUpdate page");
		session.beginTransaction().commit();
		System.out.println("result is" + result);
		
		Query quaryAll = session.createQuery("from Employee");
		List<Employee> empList = quaryAll.list();
		model.addAttribute("emp1", empList);
		return "profile";
	}
}
