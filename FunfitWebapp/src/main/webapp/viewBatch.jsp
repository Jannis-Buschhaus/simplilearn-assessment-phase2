<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List,com.funfit.bean.Batch"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of batches</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="bg-dark">
	<script type="text/javascript">
		async function deleteBatch(batchId) {
			var result
			try {
				result = await fetch("/FunfitWebapp/BatchController?id="+batchId,  {
	    			method: 'DELETE'
	  			})
			} catch (e) {
				result = e
				console.log(result)
			} finally {
				window.location.replace("BatchController?target=viewBatch")
			}
		}
		
		function showUpdate(batchId, typeOfBatch, time) {
			document.getElementById("updateBatches").hidden = false
			document.getElementById("batchId").value = batchId
			document.getElementById("typeOfBatch").value = typeOfBatch
			document.getElementById("time").value = time
		}
	</script>
	<h1 class="text-danger text-center">List of Batches</h1>
	<div class="text-center">
		<table  class="table table-warning table-bordered table-hover table-sm">
			<tr >
				<th class="bg-warning">ID</th><th class="bg-warning">Type of Batch</th><th class="bg-warning">time</th><th class="bg-warning">action</th>
			</tr>
			<c:forEach items="${ sessionScope.batch }" var="batch">
				<tr>
					<td>${ batch.getBatchId() }</td>
					<td>${ batch.getTypeOfBatch() }</td>
					<td>${ batch.getTime() }</td>
					<td>
						<button onclick="deleteBatch(${ batch.getBatchId() })">delete</button>
						<button onclick="showUpdate(batchId=${ batch.getBatchId() }, typeOfBatch='${ batch.getTypeOfBatch() }', time='${ batch.getTime() }')">update</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div hidden id="updateBatches">
			<h1 class="text-danger">Update batch</h1>
			<form method="post" action="BatchController">
				<label class="text-warning m-3" for="batchId">Batch ID: </label>
					<input readonly type="text" name="batchId" id="batchId" /><br />
				<label class="text-warning m-3" for="typeOfBatch">Type of Batch: </label>
					<select name="typeOfBatch" id="typeOfBatch">
						<option value="morning">morning</option>
						<option value="evening">evening</option>
					</select><br />
				<label class="text-warning m-3" for="time">Time: </label>
					<select  id = "time" name="time">
					<% for(int i=1; i<=12; i++){ %>
						<option value="<%=i%>am"><%=i%> am</option>
					<% }%>
					<% for(int i=1; i<=12; i++){ %>
						<option value="<%=i%>pm"><%=i%> pm</option>
					<% }%>
					</select><br />
				<input type="radio" name="update" value="update" checked  hidden/>
				<button class="btn btn-danger" type="submit">Update Batch</button>
			</form>
	</div>
	<a  class="btn btn-primary m-3" href="index.jsp">Home</a>
	</div>
</body>
</html>