<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>
<div id="register-form">
	<div class="row mx-4 my-4">
	    <div  class="col-lg-6 col-md-12 col-sm-12" >
			<div class="container">
				<form action="RegisterController" method="get">
					<label for="name">Full Name:</label> <input type="text" name="name" size="40" pattern="[A-Za-z\s]{1,40}" title="e.g. Clay Jenson " required><br>
					<label for="email">Email: </label> <input type="text" name="email" size="40" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$" title="e.g. abc@gmail.com" required><br>
					<label for="mob">Mobile No: </label> <input type="text" name="mbno" size="40" pattern="[0-9]{10}" title="e.g. 9876543210 "required><br>
					<label for="uname">Create Username: </label> <input type="text" name="uname" size="40" pattern="[a-z]{4,10}" title="e.g. abc" required><br>
					<i>(only lower case characters are allowed and username should be 4 to 10 characters long.)</i><br>
					<label for="pass">Set Password: </label> <input type="text" name="pass" size="40" pattern="[a-z0-9]{6,8}" title="e.g. pass1234" required><br>
					<i>(password should be 6 to 8 characters long.)</i><br>
					<input type="submit" name="Register-button" value="Register">
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>