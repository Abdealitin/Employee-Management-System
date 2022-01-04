<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Entry</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="custom.css" rel="stylesheet"></link>
<style type="text/css">
.form-container {
	position: fiexd;
	width: 50%;
	margin-left: 20px;
	margin-top: 20px;
	margin-bottom: 20px;
	padding: 20px;
	background-color: #c0c0c0;
	border: 1px solid #ddd;
	border-radius: 4px;
}

.floatRight {
	float: none;
	margin-right: 35px;
}

.has-error {
	color: red;
}

.success {
	position: fiexd;
	width: 50%;
	margin-left: 50px;
	margin-top: 20px;
	padding: 20px;
	background-color: #E8E1E1;
	border: 1px solid #ddd;
	border-radius: 4px;
</style>
</head>
<body>
	<div class="form-container">
		<h1>Enter Employee Details</h1>
		<form:form method="POST" modelAttribute="employee"
			action="addemployee" class="form-horizontal">
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName">Employee
						ID</label>
					<div class="col-md-7">
						<form:input type="text" path="id" id="id"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="id" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="name">Employee
						Name</label>
					<div class="col-md-7">
						<form:input type="text" path="name" id="name"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="name" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="salary">Employee
						Salary</label>
					<div class="col-md-7">
						<form:input type="text" path="salary" id="salary"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="salary" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="designation">Employee
						Designation</label>
					<div class="col-md-7">
						<form:input type="text" path="designation" id="designation"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="designation" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="city">Employee
						City</label>
					<div class="col-md-7">
						<form:input type="text" path="city" id="city"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="city" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="department">Employee
						Department</label>
					<div class="col-md-7">
						<form:input type="text" path="department" id="department"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="department" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-actions floatRight">
					<input type="submit" value="Register"
						class="btn btn-primary btn-sm">
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>