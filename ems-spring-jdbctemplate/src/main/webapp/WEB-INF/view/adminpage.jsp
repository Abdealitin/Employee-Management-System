<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Page | EMS</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
.center {
	margin: auto;
	width: 60%;
	border: 3px solid #73AD21;
	padding: 10px;
}
</style>
</head>
<body>
	<h3>
		<center>Welcome Admin</center>
	</h3>
	<hr>
	<h4>
		<center>Services</center>
	</h4>
	<div class="center">
		<div class="list-group">
			<a href="getemployees" class="list-group-item list-group-item-action">Employees List </a>
			<a href="addemployee" class="list-group-item list-group-item-action">Add Employee</a>
			<a href="employeeid" class="list-group-item list-group-item-action">Get Employee ID </a>
			<a href="employeename" class="list-group-item list-group-item-action">Get Employee By Name</a>
			<a href="topearner" class="list-group-item list-group-item-action">Get the Top Earner </a>
			<a href="updateemployee" class="list-group-item list-group-item-action">Update Details of Employee </a>
			<a href="deleteemployee" class="list-group-item list-group-item-action">Delete an Employee </a>
		</div>
	</div>

</body>
</html>