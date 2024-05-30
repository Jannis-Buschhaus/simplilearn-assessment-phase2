<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Participant</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="bg-dark text-danger">
	<div class="text-center">
		<h1 class="text-danger">Add Participant</h1>
		<form action="ParticipantsController" method="post">
			<label class="text-warning m-3" for="fname">First name:</label>
				<input type="text" name="fname" /><br />
			<label class="text-warning m-3" for="lname">Last name:</label>
				<input type="text" name="lname" /><br />
			<label class="text-warning m-3" for="age">Age:</label>
				<input type="number" name="age" /><br />
			<label class="text-warning m-3" for="phoneNumber">Phone Number:</label>
				<input type="text" name="phoneNumber" /><br />
			<label class="text-warning m-3" for="batchId">Batch:</label>
				<select name="batchId">
					<c:forEach var="batch" items="${ sessionScope.batch }">
						<option value="${ batch.getBatchId() }">${ batch.getTypeOfBatch() } ${ batch.getTime() }</option>
					</c:forEach>
				</select><br />
			<input class="m-3 btn btn-danger" type="submit" value="Submit" />
		</form>
		<a  class="btn btn-primary m-3" href="index.jsp">Home</a>
	</div>
</body>
</html>