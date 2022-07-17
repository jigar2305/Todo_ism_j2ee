<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>forgot password</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<style type="text/css">
body {
	background-color: whitesmoke;
}

#form {
	background-color: white;
	hight: 250px;
	width: 200px;
}
</style>

</head>
<body>

	<div class="container">
		<div class="row mt-5">
			<div class="col-md-4"></div>
			<div class="col-md-4" id="form">
				<form action="SqueController" method="post">
					<div
						style="text-align: center; font-family: bolder; color: #f89501;">
						<h1 style="font-size: 40px;">TODO</h1>
					</div>
					<div style="text-align: center; margin-bottom: 25px;">
						<h1 style="font-size: 30px;">security question</h1>
						${msg}
						<hr>
					</div>
					<div class="form-group">
						<input type="email" name="email" value="${email}" hidden="true">
					</div>
					<input type="text" name="question" value="${question}"
						hidden="true">
					<div class="form-group">
						<h4 class="form-control">${question}</h4>
					</div>
					<div class="form-group">
						<label class="mb-2">please enter your ans.</label> <input
							type="text" placeholder="please enter" class="form-control"
							name="answer" />
					</div>
					<div style="text-align: center;">
						<input type="submit" value="forgot" class="btn btn-primary" />
					</div>
					<div style="text-align: center; margin-top: 15px;">
						<a href="login.jsp">login</a>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>