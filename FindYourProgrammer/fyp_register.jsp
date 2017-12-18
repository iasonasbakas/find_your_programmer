<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fyp_classes.*" %>
<%@ page errorPage="fyp_errorPage.jsp" %>


<!DOCTYPE html>
<html lang="el">

	<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Το Find your Programmer είναι μια online πλατφόρμα εύρεσης προγραμματιστών μέσω της οποίας ο καθένας μπορεί να βρει, να επικοινωνήσει, να συνεργαστεί, και στο τέλος να αξιολογίσει είτε επαγγελματίες, είτε ερασιτέχνες προγραμματιστές">
	<meta name="author" content="yourprogr.gr">

	<style>
		body {
		background: url(images/reg_img.jpg) no-repeat center center fixed;
		-webkit-background-size: cover;
		-moz-background-size: cover;
		-o-background-size: cover;
		background-size: cover;
		padding-top: 30px;
		overflow-x: hidden;
		min-height: 100%;
    	height: auto;
    	margin: 0px;
		}

		#index label {
		   color:white;
		}

		#index h1 {
			color:white;
		}
	</style>

	<title>Find your Programmer</title>

	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/fyp-theme.css">
	</head>


	<body id="index">

	<nav class="navbar navbar-inverse navbar-fixed-top navbar-custom">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand text-info" href="fyp_index.jsp">Find your Programmer</a>
			</div>
		</div>
	</nav>

	<div class="container theme-showcase" role="main">
		<div class="page-header">
		<div><h1>Συμπλήρωσε τη φόρμα εγγραφής<h1></div>
		</div>
	</div>

	<div class="container">
		<form class="form-horizontal" method="POST" action="servlet/fyp_registerController">
			<div class="form-group">
				<label class="control-label col-lg-4" for="inputUsername">Username:</label>
					<div class="col-lg-4">
						<input type="text" class="form-control" id="inputUsername" name="username" placeholder="Username">
					</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-4" for="inputPsw">Password:</label>
					<div class="col-lg-4">
						<input type="password" class="form-control" id="inputPsw" name="password" placeholder="New Password">
					</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-4" for="inputPsw2">Password Confirmation:</label>
					<div class="col-lg-4">
						<input type="password" class="form-control" id="inputPsw2" name="password2" placeholder="Insert your password again">
					</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-4" for="inputEmail">Email:</label>
					<div class="col-lg-4">
						<input type="email" class="form-control" id="inputEmail" name="email" placeholder="Email">
					</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-4" for="inputName">Name:</label>
					<div class="col-lg-4">
						<input type="text" class="form-control" id="inputName" name="name" placeholder="Name">
					</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-4" for="inputSurname">Surname:</label>
					<div class="col-lg-4">
						<input type="text" class="form-control" id="inputSurname" name="surname" placeholder="Surname">
					</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-4" for="inputPhone">Phone:</label>
					<div class="col-lg-4">
						<input type="text" class="form-control" id="inputPhone" name="phone" placeholder="Phone">
					</div>
			</div>
			<div class="form-group">
				<div class="col-lg-12 text-center">
					<button type="submit" class="btn btn-default btn-lg btn-custom">Sign Up</button>
				</div>
			</div>




		</form><!--/formhorizontal-->

	</div><!--/container-->


	<footer class="footer">
		<p>© 2017 Find Your Programmer. All rights reserved</p>
	</footer>


	<script src="js/jquery.min.js"></script>
	<script	src="js/bootstrap.min.js"></script>

	</body>
</html>