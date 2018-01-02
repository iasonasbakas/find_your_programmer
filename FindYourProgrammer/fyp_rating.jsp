<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fyp_classes.*" %>
<%@ page errorPage="fyp_errorPage.jsp" %>

<%
Customer customer = (Customer) session.getAttribute("customer-object");
if(session.getAttribute("customer-object") == null) {
	request.setAttribute("message", "You are not authorized to access this resource. Please login.");
%>

<jsp:forward page="fyp_login.jsp" />

<%
} else {
%>

<!DOCTYPE html>
<html lang="el">

	<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Rating">
	<meta name="author" content="yourprogr.gr">

	<style>
		body {
		background: url(images/default.jpg) no-repeat center center fixed;
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
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand text-info" href="fyp_index.jsp">Find your Programmer</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="fyp_search.jsp">Search</a></li>
					<li><a href="fyp_myMeetings.jsp">MyMeetings</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
					<a id="customer" class="dropdown-toggle" data-toggle="dropdown" >
						<span class="glyphicon glyphicon-user"></span><%= customer.getUsername() %><span class="caret"></span></a>
       					<ul class="dropdown-menu">
       						<li><a href="fyp_logout.jsp">Logout</a></li>
       					</ul>
       					</li>	
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container theme-showcase" role="main">
		<div class="page-header">
		<div><h1>Αξιολόγησε το meeting σου με τον<h1></div>
		</div>
	</div>
	
	<div class="container">
		<div class="form-horizontal" method="POST" action="servlet/fyp_ratingController">
			<div class="form-group">
				<label class="control-label col-lg-4" for="inputComment">Comments: </label>	
					<div class="col-lg-4">
						<textarea type="text" rows="6" class="form-control" id="inputComment" name="comments" placeholder="Add your comments"></textarea>
					</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-4" for="inputRating">Rating: </label>
					<div class="col-lg-4">
						<input type="text" class="form-control" id="inputRating" name="rating" placeholder="Give rating">
					</div>
			</div>
			<div class="form-group">
				<div class="col-lg-12 text-center">
					<button type="submit" class="btn btn-default btn-lg btn-custom">Submit</button>
				</div>
			</div>
		</div>
	</div>
			
		
	<footer class="footer">
		<div class="container">
			<p>© 2017 Find Your Programmer. All rights reserved</p>
		</div>
	</footer>


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	</body>
</html>

<%
}
%>