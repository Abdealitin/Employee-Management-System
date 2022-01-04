<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Information</title>
<style>
.center {
	margin: auto;
	width: 32%;
	border: 3px solid #73AD21;
	padding: 10px;
}
.center1 {
	margin: auto;
	width: 15%;
	padding: 10px;
}
</style>
</head>

<body>
    <h1 align = "center">${heading}</h1>
</body>

<div class="center">
<%-- <c:if test="${not empty lists}"> --%>
	<table border=1 width=50% height=50%>
	<tr>
		<th>Employee ID</th>
		<th>Employee Name</th>
		<th>Employee Salary</th>
		<th>Employee Designation</th>
		<th>Employee City</th>
		<th>Employee Department</th>
	</tr>
    <c:forEach items="${lists}" var="lists">
    <tr>
       <td>${lists.id}</td>
       <td>${lists.name}</td>
       <td>${lists.salary}</td>
       <td>${lists.designation}</td>
       <td>${lists.city}</td>
       <td>${lists.department}</td>
    </tr>
</c:forEach>
</table>
</div>
<br>
	<a class="center1" href="adminpage">Back To Dashboard</a>
<%-- </c:if> --%>