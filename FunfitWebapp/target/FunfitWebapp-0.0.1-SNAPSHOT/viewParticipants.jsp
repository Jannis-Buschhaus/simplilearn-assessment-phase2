<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Participants</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="bg-dark">
	<script type="text/javascript">
		async function deleteParticipant(partId) {
			var result
			try {
				result = await fetch("/FunfitWebapp/ParticipantsController?id="+partId,  {
	    			method: 'DELETE'
	  			})
			} catch (e) {
				result = e
				console.log(result)
			} finally {
				window.location.replace("ParticipantsController?target=viewParticipants")
			}
		}
		
		function showUpdate(partId, fname, lname, age, phoneNumber, batchId) {
			document.getElementById("updateParticipant").hidden = false
			document.getElementById("partId").value = partId
			document.getElementById("fname").value = fname
			document.getElementById("lname").value = lname
			document.getElementById("age").value = age
			document.getElementById("phoneNumber").value = phoneNumber
			document.getElementById("batchId").value = batchId
		}
	</script>
	<div class="text-center">
		<h1 class="text-danger">List of Participants</h1>
		<table class="table table-warning table-bordered table-hover table-sm">
			<tr>
				<th class="bg-warning">ID</th><th class="bg-warning">First Name</th><th class="bg-warning">Last Name</th><th class="bg-warning">Age</th><th class="bg-warning">Phone Number</th><th class="bg-warning">Batch ID</th><th class="bg-warning">Action</th>
			</tr>
			<c:forEach items="${ sessionScope.participants }" var="p">
				<tr>
					<td>${ p.getPartId() }</td>
					<td>${ p.getFname() }</td>
					<td>${ p.getLname() }</td>
					<td>${ p.getAge() }</td>
					<td>${ p.getPhoneNumer() }</td>
					<td>${ p.getBatchId() }</td>
					<td>
						<button onclick="deleteParticipant(partId='${ p.getPartId() }')">delete</button>
						<button onclick="showUpdate(partId='${ p.getPartId() }', fname='${ p.getFname() }', lname='${ p.getLname() }', age='${ p.getAge() }', phoneNumber='${ p.getPhoneNumer() }', batchId='${ p.getBatchId() }' )">update</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div id="updateParticipant" hidden>
			<h1 class="text-danger">Update Participant</h1>
			<form method="post" action="ParticipantsController">
				<label class="text-warning m-3" for="partId">Participant ID: </label>
					<input readonly type="text" name="partId" id="partId" /><br />
				<label class="text-warning m-3" for="fname">First Name: </label>
					<input type="text" name="fname" id="fname" /><br />
				<label class="text-warning m-3" for="lname">Last Name: </label>
					<input type="text" name="lname" id="lname" /><br />
				<label class="text-warning m-3" for="age">Age: </label>
					<input type="number" name="age" id="age" /><br />
				<label class="text-warning m-3" for="phoneNumber">Phone Number: </label>
					<input type="text" name="phoneNumber" id="phoneNumber" /><br />
				<label class="text-warning m-3" for="batchId">batch: </label>
					<select id="batchId" name="batchId">
						<c:forEach var="batch" items="${ sessionScope.batch }">
							<option value="${ batch.getBatchId() }">${ batch.getTypeOfBatch() } ${ batch.getTime() }</option>
						</c:forEach>
					</select><br />
				<input type="radio" name="update" value="update" checked  hidden/>
				<button class="btn btn-danger" type="submit">Update Participant</button>
			</form>
		</div>
		<a  class="btn btn-primary m-3" href="index.jsp">Home</a>
	</div>
</body>
</html>