<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>email</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<style type="text/css">
	body{
	background-color: whitesmoke;
	}
	#form{
	background-color: white;
	hight:250px;
	width: 200px;
	}
</style>

</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-4"></div>
			<div class="col-md-4" id="form">
				<form action=GetQuestionController method="post">
					<div style="text-align: center; font-family: bolder; color: #f89501; ">
							<h1 style="font-size: 40px;">TODO</h1>
							</div>
					<div style="text-align: center; margin-bottom: 25px;">
					<h1 style="font-size: 30px;">forgot password</h1>
					${emailmsg}
					<hr>
					</div>
					<div class="form-group">
						<input type="email" placeholder="Email" name="email" class="form-control" value="${email}"/>
					</div>
					<div style="text-align: center;">
						<input type="submit" value="forgot" class="btn btn-primary">
					</div>
					<div style="text-align: center; margin-bottom: 20px;">
					<a href="login.jsp">login</a>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>