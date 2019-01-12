package com.naukri.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.naukri.daos.interf.IEmployee;
import com.naukri.pojos.Employee;

public class EmployeeHiberDao implements IEmployee {

	public void saveEmployee(Employee emp) {
		System.out.println(" Entered into saveEmployee :: EmployeeHiberDao");
		Configuration configuration = new Configuration().configure();
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();
		session.save(emp);
		session.beginTransaction().commit();

		System.out.println("Exited from saveEmployee :: EmployeeHiberDao");
	}

	public List<Employee> loginEmployee(Employee emp) {
		System.out.println(" Entered into loginEmployee :: EmployeeHiberDao");

		Configuration configuration = new Configuration().configure();
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();

		Query query = session.createQuery("from Employee where mobile=:mobile AND password=:password");
		query.setParameter("mobile", emp.getMobile());
		query.setParameter("password", emp.getPassword());

		List<Employee> list = query.list();

		System.out.println("Exited from loginEmployee :: EmployeeHiberDao");
		return list;
	}

	public List<Employee> getAllEmployees() {
		System.out.println(" Entered into getAllEmployees :: EmployeeHiberDao");
		Configuration configuration = new Configuration().configure();
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();

		Query quaryAll = session.createQuery("from Employee");
		List<Employee> empList = quaryAll.list();
		System.out.println("Exited from getAllEmployees :: EmployeeHiberDao");
		return empList;
	}
}
