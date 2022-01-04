<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Enrollment Detail Confirmation</title>
<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
<style type="text/css">
.success {
	position: fiexd;
	width: 50%;
	margin-left: 50px;
	margin-top: 20px;
	padding: 20px;
	background-color: #E8E1E1;
	border: 1px solid #ddd;
	border-radius: 4px;
}
</style>
</head>
<body>
	<div class="success" align="center">Confirmation message : ${success}</div>
	<br>
	<a href="adminpage">Back To Dashboard</a>
</body>
</html>
