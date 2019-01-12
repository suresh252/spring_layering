<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Registration Employee Details</h3>
	<form action="saveEmp" method="post">

		Emp Id:<input type="text" name="empId"><br> Name:<input
			type="text" name="name"><br> Designation:<input
			type="text" name="designation"><br> Mobile:<input
			type="text" name="mobile"><br> Password:<input
			type="password" name="password"><br> <input
			type="submit" Value="Reg Employee"><br> <a
			href="login.jsp">Login Employee</a>
	</form>

</body>
</html>