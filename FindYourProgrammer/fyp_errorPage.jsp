<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fyp_classes.*" %>
<%@ page isErrorPage="true"%>

<%
Customer customer = (Customer) session.getAttribute("customer-object");
%>

<!DOCTYPE html>
<html lang="el">

	<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
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

	<title>Error Page</title>

	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/fyp-theme.css">
	</head>


	<body id="index">

	<nav class="navbar navbar-inverse navbar-fixed-top navbar-custom">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand text-info" href="fyp.html">Find your Programmer</a>
			</div>
		</div>
	</nav>

	<div class="container theme-showcase" role="main">
		<div class="page-header">
		<div><h1>Σφάλμα<h1></div>
		</div>
	</div>

	<div class="container">
		
		<div class="alert alert-warning" role="alert"><%= exception.getMessage() %></div>
		
	</div><!--/container-->


	<footer class="footer">
		<p>© 2017 Find Your Programmer. All rights reserved</p>
	</footer>


	<script src="js/jquery.min.js"></script>
	<script	src="js/bootstrap.min.js"></script>

	</body>
</html>
