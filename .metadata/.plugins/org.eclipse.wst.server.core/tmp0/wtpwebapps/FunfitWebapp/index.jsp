<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Funfit</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="bg-dark">
	<h1 class="text-danger text-center">Funfit Webapp</h1>
	<div class="text-center m-3">
		<a class="btn btn-primary w-25 text-center" href="addBatch.jsp">Add Batch</a><br />
	</div>
	<div class="text-center m-3">
		<a class="btn btn-primary w-25 text-center" href="BatchController">View and Manage Batches</a><br />
	</div>
	<div class="text-center m-3">
		<a class="btn btn-primary w-25 text-center" href="ParticipantsController?target=addParticipant">Add Participants</a><br />
	</div>
	<div class="text-center m-3">
		<a class="btn btn-primary w-25 text-center" href="ParticipantsController?target=viewParticipant">View and Manage Participants</a><br />
	</div>
</body>
</html>