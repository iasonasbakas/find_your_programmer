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

	CustomerDAO cdao = new CustomerDAO();
%>

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
		background: url(images/img2.jpg) no-repeat center center fixed;
		-o-background-size: cover;
		background-size: cover;
		padding-top: 10px;
		overflow-x: hidden;
		min-height: 100%;
    	height: auto;
    	margin: 0px;
		}
	</style>

	<title>Find your Programmer</title>

	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/fyp-theme.css">
	</head>


	<body>

	<nav class="navbar navbar-inverse navbar-fixed-top navbar-custom">
		<div class="container">
			<div class="navbar-header">
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
		<div class ="jumbotron">
			<h2>Καλωσήλθες <var><%=customer.getName() %></var></h2>
			<p>Αναζήτησε άμεσα τον προγραμματιστή που χρειάζεσαι πατώντας το κουμπί της Αναζήτησης!</p>
		</div>
	</div>


	<div class="container">
		<div class ="row">
			<div class = "col-xs-6 col-xs-offset-3 col-sm-6 col-sm-offset-3 col-md-12 col-md-offset-4  col-lg-3 col-lg-offset-5 ">
				<a role="button" type ="submit" class="btn btn-primary btn-lg" href="fyp_search.jsp"><span class="glyphicon glyphicon-search"></span>Αναζήτηση</a>
			</div>
		</div><!--/row-->
	</div> <!-- /container-->
	
	
	<footer class="footer">
		<p>© 2017 Find Your Programmer. All rights reserved</p>
	</footer>


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


	<script src="js/bootstrap.min.js"></script>

	</body>
</html>

<%
}
%>
