<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<html>
<head>
<script type="text/javascript">
	function editEmployee(mobile) {
		alert("edit employee triggered for : " + mobile);
		document.forms[0].action = "${pageContext.request.contextPath}/editEmployee?mobile="
				+ mobile;
		document.forms[0].method = "post";
		document.forms[0].submit();
	}

	function deleteEmployee(mobile) {
		alert("delete employee triggered for : " + mobile);
		document.forms[0].action = "${pageContext.request.contextPath}/deleteEmployee?mobile="
				+ mobile;
		document.forms[0].method = "post";
		document.forms[0].submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	hello !! welcome ${msg} !
	<br>
	<form action="">
		<table border="2">
			<tr style="color: red">
				<th>empId</th>
				<th>name</th>
				<th>designation</th>
				<th>mobile</th>
				<th>password</th>
			</tr>
			<core:forEach var="item" items="${emp1}">
				<tr>
					<td><core:out value="${item.empId}" /></td>
					<td><core:out value="${item.name}" /></td>
					<td><core:out value="${item.designation}" /></td>
					<td><core:out value="${item.mobile}" /></td>
					<td><core:out value="${item.password}" /></br></td>
					<td><input type="button" value="Edit" onclick="editEmployee('${item.mobile}')" /></td>
					<td><input type="button" value="Delete"	onclick="deleteEmployee('${item.mobile}')" /></td>

				</tr>
			</core:forEach>
		</table>
		<a
			href="home.jsp">Reg Employee</a><br> <a href="login.jsp">Login
			Employee</a>
	</form>
</body>
</html>