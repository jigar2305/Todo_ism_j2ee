<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: grey;">
	<jsp:include page="nav.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-3"></div>
			<div class="col-md-6 p-5"
				style="background-color: whitesmoke; border-radius: 40px;">
				<form action="AddTaskController" method="post">
					<div class="form-group" style="text-align: center;">
						<h3>Add task</h3>
					</div>
					<div class="form-group">
						<label>Title</label> <input type="text" name="name"
							class="form-control" />
					</div>
					<div class="form-group">
						<label>Discription</label> <input type="text" name="description"
							class="form-control" />
					</div>
					<div class="form-group">
						<label>target date</label> <input type="date" name="fdate"
							class="form-control" />
					</div>
					<div class="form-group">
						<label for="priority" class="mr-3">Priority </label> <select
							id="priority" name="priority">
							<option value="medium">medium</option>
							<option value="low">low</option>
							<option value="high">high</option>
						</select>
					</div>

					<button type="submit" class="btn btn-success" style="width: 100%;">Add
						todo</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>