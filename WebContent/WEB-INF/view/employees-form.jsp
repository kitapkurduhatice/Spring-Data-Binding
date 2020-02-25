<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<f:form action="save" modelAttribute="employee">
		<b>Employees Id:</b><f:input path="employeesId" readonly="true"/><br><br>
		<b>First Name:</b> <f:input path="firstName" /><br><br>
		<b>Last Name:</b> <f:input path="lastName"/><br><br>
		<b>Salary:</b> <f:input path="salary"/><br><br>
		<input type="submit" value="Save"/>
		${message}<br><br>
		<a href="">Search için tıklayınız</a>		
		</f:form>

</body>
</html>