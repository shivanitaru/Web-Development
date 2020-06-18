<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<div id="login-form">
	<div class="container">
		<div class="row mx-4 my-4">
		    <div  class="col-lg-6 col-md-12 col-sm-12" >
				<h4>
					<%
				    if(null!=request.getAttribute("errorMessage"))
				    {
				        out.println(request.getAttribute("errorMessage"));
				    }
					%>
				</h4>
				<form action="LoginController" method="get">
					<label="uname">Username: </label> <input type="text" name="uname" size="40" required><br>
					<label="pass">Password: </label> <input type="password" name="pass" size="40" required><br><br>
					<input type="submit" name="login-button" value="Login">
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>