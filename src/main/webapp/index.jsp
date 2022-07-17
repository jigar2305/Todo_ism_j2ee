<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo Tables</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">


<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
</head>
<body style="background-color: grey;">
	<jsp:include page="nav.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row m-5 ">
			<div class="col-md-12" style="background-color: whitesmoke; padding: 30px; border-radius: 30px;">
			<div align="center">${delmsg}${msgstatus}${msgpriority}</div>
				<h2 align="center">List Tasks</h2>
				<div class="progress mt-3  mb-3">
					<div class="progress-bar progress-bar-striped bg-success" role="progressbar"
						style="width: ${persentage}%;  " aria-valuenow="10" aria-valuemin="0"
						aria-valuemax="100">${persentage}</div>
				</div>

				<table class="display" id="task">
					<thead class="thead-light">
						<tr>
							<th scope="col">No</th>
							<th scope="col">Title</th>
							<th scope="col">Description</th>
							<th scope="col">Priority</th>
							<th scope="col">status</th>
							<th scope="col">Add Date</th>
							<th scope="col">Add time</th>
							<th scope="col">Target Date</th>
							<th scope="col">Action</th>
						</tr>
					</thead>

					<tbody>
						<%
						int id = 1;
						%>
						<c:forEach items="${tasks}" var="it">
						<tr>
							<th scope="row"><%=id%></th>
									<td>${it.name}</td>
									<td id="td">${it.description}</td>
									<td><a
										href="UpdatelowpriorityController?taskid=${it.taskid}&priority=${it.priority}"
										class="btn btn-sussess p-2"><svg
												xmlns="http://www.w3.org/2000/svg" width="16" height="16"
												fill="currentColor" class="bi bi-arrow-down"
												viewBox="0 0 16 16">
  <path fill-rule="evenodd"
													d="M8 1a.5.5 0 0 1 .5.5v11.793l3.146-3.147a.5.5 0 0 1 .708.708l-4 4a.5.5 0 0 1-.708 0l-4-4a.5.5 0 0 1 .708-.708L7.5 13.293V1.5A.5.5 0 0 1 8 1z" />
</svg></a> ${it.priority} <a
										href="UpdatepriorityController?taskid=${it.taskid}&priority=${it.priority}"
										class="btn btn-sussess p-2"><svg
												xmlns="http://www.w3.org/2000/svg" width="16" height="16"
												fill="currentColor" class="bi bi-arrow-up"
												viewBox="0 0 16 16">
  <path fill-rule="evenodd"
													d="M8 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L7.5 2.707V14.5a.5.5 0 0 0 .5.5z" />
</svg></a></td>
									<td>${it.status}<a
										href="UpdatestatusController?taskid=${it.taskid}&status=${it.status}"
										class="btn btn-sussess p-2"><svg
												xmlns="http://www.w3.org/2000/svg" width="16" height="16"
												fill="currentColor" class="bi bi-arrow-up"
												viewBox="0 0 16 16">
  <path fill-rule="evenodd"
													d="M8 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L7.5 2.707V14.5a.5.5 0 0 0 .5.5z" />
</svg></a></td>
									<td>${it.t_date}</td>
									<td>${it.t_time}</td>
									<td>${it.f_date}</td>
									<%
									id++;
									%>
									<td><a href="DeletetaskController?taskid=${it.taskid}"
										class="btn btn-danger ">Delete</a>
								</tr>
						</c:forEach>
						

					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#task').DataTable();
		});
	</script>


</body>
</html>