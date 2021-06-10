<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<style>
body{
	font-size:20px;
}
</style>
</head>
<body>
<div class="row mx-4 my-4">
    <div  class="col-lg-6 col-md-12 col-sm-12" >
	    	<%
			String uname = (String)session.getAttribute("uname");
			out.println("Hello "+uname+", Welcome to Home Page!!!");
			%>
	</div>
</div>	
</body>
</html>