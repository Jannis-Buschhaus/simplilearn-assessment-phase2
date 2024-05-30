<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Batch</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="bg-dark text-danger">
	<h1 class="text-danger text-center">Add Batch</h1>
	<div class="text-center">
		<form action="BatchController" method="post">
		<label class="text-warning m-3" for="typeOfBatch">Type of Batch: </label>
		<select class="m-3" name="typeOfBatch">
			<option value="morning">Morning</option>
			<option value="evening">Evening</option>
		</select><br/>
		<label class="text-warning m-3" for="time">Time</label>
		<select class="m-3" name="time">
			<% for(int i=1; i<=12; i++){ %>
				<option value="<%=i%>am"><%=i%> am</option>
			<% }%>
			<% for(int i=1; i<=12; i++){ %>
				<option value="<%=i%>pm"><%=i%> pm</option>
			<% }%>
		</select><br />
		<input class="m-3 btn btn-danger" type="submit" value="addBatch" />
		</form>
		<a  class="btn btn-primary m-3" href="index.jsp">Home</a>
	</div>
</body>
</html>