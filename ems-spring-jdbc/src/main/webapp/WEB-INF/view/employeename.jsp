<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.center {
	margin: auto;
	width: 60%;
	border: 3px solid #73AD21;
	padding: 10px;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=submit] {
	background-color: #04AA6D;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
</head>
<body>
<h1 align="center">Enter Employee Name</h1>
	<hr>
	<div class="center">
		<div class="container">
			<form action="getempname" method="get">
				<label for="fname">Employee Name</label>
				<input type="text" id="name"name="name" placeholder="Employee Name">
				<input type="submit" value="Submit">
			</form>
		</div>
	</div>
</body>
</html>