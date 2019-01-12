package com.naukri.daos.interf;

import java.sql.SQLException;
import java.util.List;

import com.naukri.pojos.Employee;

public interface IEmployee {

	public List<Employee> loginEmployee(Employee emp)  throws ClassNotFoundException, SQLException;
	
	public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException;
}
