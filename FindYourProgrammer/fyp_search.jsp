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
	<meta name="description" content="Aναζήτηση">
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
		

	</style>
	
	
	<title>Αναζήτηση</title>

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
					<li  class="active"><a href="fyp_search.jsp">Search</a></li>
					<li><a href="fyp_myMeetings.jsp">MyMeetings</a></li>
				</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a id="customer" class="dropdown-toggle" data-toggle="dropdown" >
						   		<span class="glyphicon glyphicon-user"></span><%= customer.getUsername() %><span class="caret"></span>
							</a>
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
		<div><h1 style="color:white;">Συμπλήρωσε τη φόρμα αναζήτησης<h1></div>
		</div>
	</div>



	<div class="container theme -showcase">
		<div class = "row" >
			<form class="form-horizontal" name = "form" action="fyp_searchResults.jsp" method="post" >
				<div class= "form-group" name = "form">

					<div class="btn-group col-lg-4 col-lg-offset-1">
						<h1 style="color:white;"> Software </h1>
								  <ul class="list-group">
								  	  <li class = "list-group-item"><div class="radio radio-info radio-inline"><input type="radio" id="inlineRadio1" value="1" name="radios"/><label for="inlineRadio1"><span>1. Σχεδίασμός και Ανάπτυξη βοηθητικών προγραμμάτων εργασίας</span></label></div></li>

									  <li class = "list-group-item"><div class="radio radio-info radio-inline"><input type="radio" id="inlineRadio2" value="2" name="radios"/><label for="inlineRadio2"><span>2. Βελτίωση, Συντήρηση και Ανάπτυξη Εφαρμογών</span></label></div></li>

									  <li class = "list-group-item"><div class="radio radio-info radio-inline"><input type="radio" id="inlineRadio3" value="3" name="radios"/><label for="inlineRadio3"><span>3. Σχεδίασμός και Ανάπτυξη Βιντεοπαιχνιδιών</span></label></div></li>

									  <li class = "list-group-item"><div class="radio radio-info radio-inline"><input type="radio" id="inlineRadio4" value="4" name="radios"/><label for="inlineRadio4"><span>4. Σχεδίασμός Λειτουργικών Συστημάτων</span></label></div></li>
								  </ul>
					</div>

					<div class="btn-group col-lg-4 col-lg-offset-2">
						<h1 style="color:white;"> Hardware </h1>
									<ul class="list-group">
										<li class = "list-group-item"><div class="radio radio-info radio-inline"><input type="radio" id="inlineRadio5" value="5" name="radios"/><label for="inlineRadio5"><span>1. Σχεδιασμός και ανάπτυξη συστημάτων hardware</span></label></div></li>

										<li class = "list-group-item"><div class="radio radio-info radio-inline"><input type="radio" id="inlineRadio6" value="6" name="radios"/><label for="inlineRadio6"><span>2. Έλεγχος συστημάτων hardware</span></label></div></li>

										<li class = "list-group-item"><div class="radio radio-info radio-inline"><input type="radio" id="inlineRadio7" value="7" name="radios"/><label for="inlineRadio7"><span>3. Βοήθεια στην εγκατάσταση συστημάτων Η/Υ</span></label></div></li>
									</ul>
					</div>

						<div class="col-lg-3 col-lg-offset-5">
							<button type="submit" class="btn btn-success btn-lg">Submit</button>
							<button type="reset" class="btn btn-danger btn-lg">Cancel</button>
						</div>

				</div>
			</form>

		 </div>
	</div>
	<!--container>-->


	<footer class="footer">
		<p>© 2017 Find Your Programmer. All rights reserved</p>
	</footer>


	<script src="js/jquery.min.js"></script>
	<script	src="js/bootstrap.min.js"></script>

	</body>
</html>

<%
}
%>
