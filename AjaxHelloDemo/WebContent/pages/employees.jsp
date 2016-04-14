<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>/WEB-INF/pages/employees</title>
</head>
<body>

	<h1>Employees Page</h1><hr/>

	<center>
		
		<br><br>
		
		City
		<select id="city">
			<option value="">请选择....</option>
			<c:forEach items="${ locations }" var="location">
				<option value="${ location.locationId }">${ location.city }</option>
			</c:forEach>
		</select>	
		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
		
		Department:
		<select id="department">
			<option value="">请选择....</option>
		</select>
		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
		
		Employee:
		<select id="employee">
			<option value="">请选择....</option>
		</select>
		
		<br><br>
		
		<table id="empdetails" border="1" cellspacing="0" 
				cellpadding="5" style="display: none;">
			
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Salary</th>
			</tr>
			
			<tr>
				<td id="id"></td>
				<td id="name"></td>
				<td id="email"></td>
				<td id="salary"></td>
			</tr>
		</table>
		
		
	</center>

</body>
</html>