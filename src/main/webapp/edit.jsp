<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updateEmployee" method="post">

		Emp Id:<input type="text" name="empId" value=${employee.empId }><br>
		Name:<input type="text" name="name" value=${employee.name }><br>
		Designation:<input type="text" name="designation"
			value=${employee.designation }><br> Mobile:<input
			type="text" name="mobile" value=${employee.mobile }
			readonly="readonly"><br> Password:<input type="password"
			name="password" value=${employee.password }><br> <input
			type="submit" Value="Update Employee"><br> <a
			href="home.jsp">Reg Employee</a> <a href="login.jsp">Login
			Employee</a>
	</form>

</body>
</html>