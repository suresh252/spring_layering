package com.naukri.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naukri.daos.interf.IEmployee;
import com.naukri.pojos.Employee;

public class EmployeeJdbcDao implements IEmployee {

	public List<Employee> loginEmployee(Employee emp)  throws ClassNotFoundException, SQLException {
		System.out.println(" Entered into loginEmployee :: EmployeeJdbcDao");
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_layering","root", "Suri@2330");
		PreparedStatement ps = con.prepareStatement("select * from employee where mobile=? AND password=?");
		ps.setString(1, emp.getMobile());
		ps.setString(2, emp.getPassword());
		
		ResultSet rs = ps.executeQuery();
			List<Employee> empList = new ArrayList<Employee>();
		while(rs.next()) {
			Employee e=new Employee();
			e.setEmpId(rs.getInt("empid"));
			e.setName(rs.getString("name"));
			e.setDesignation("designation");
			e.setMobile("mobile");
			e.setPassword("password");
			empList.add(e);
		}
		
		//con.close();
		System.out.println(" Exited from loginEmployee :: EmployeeJdbcDao");
		return empList;
		
	}
	
	public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException {
		System.out.println(" Entered into getAllEmployees :: EmployeeHiberDao");
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_layering","root", "Suri@2330");
		PreparedStatement ps = con.prepareStatement("select * from employee");
	
		
		ResultSet rs = ps.executeQuery();
			List<Employee> empList = new ArrayList<Employee>();
		while(rs.next()) {
			Employee e=new Employee();
			e.setEmpId(rs.getInt("empid"));
			e.setName(rs.getString("name"));
			e.setDesignation("designation");
			e.setMobile("mobile");
			e.setPassword("password");
			empList.add(e);
		}
		
		//con.close();
		System.out.println(" Exited from getAllEmployees :: EmployeeJdbcDao");
		return empList;
		
		
		
	}
}
