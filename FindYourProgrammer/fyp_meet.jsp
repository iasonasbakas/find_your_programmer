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



String prid = request.getParameter("prID");
int id = Integer.parseInt(prid);
ProgrammerDAO prodao = new ProgrammerDAO();
Programmer programmer = prodao.getProgrammerByID(id);

session.setAttribute("programmer-object",programmer);


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
	<link rel="stylesheet" href="css/meet_css.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	</head>


	<body id="index">

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
	</nav>



	<div class="container theme-showcase" role="main">
		<div class="page-header">
		<div><h1>Δημιούργησε νέα συνάντηση ή / και επικοινώνησε με τον <%=programmer.getName()%><h1></div>
		</div>
	</div>


	<div class="container">
	<form class="form-horizontal" method="POST" action="servlet/fyp_meetController">
		<div class="modal-body row">
			<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-lg-1" for="inputPlace">Place: </label>
							<div class="col-lg-6">
								<input type="text" class="form-control" id="inputPlace" name="place" placeholder="Address or place name">
							</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-1" for="inputDate">Date: </label>
							<div class="col-lg-6">
								<input type="text" class="form-control" id="inputDate" name="date" placeholder="dd/mm/yyyy">
							</div>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-1" for="inputDate">Time: </label>
							<div class="col-lg-6">
								<input type="text" class="form-control" id="inputTime" name="time" placeholder="hh:mm">
							</div>
					</div>
					<div class="form-group">
					  	<label class="control-label col-lg-1" for="extrainfo">Info: </label>
						  	<div class="col-lg-8">
						 		<textarea class="form-control" rows="5" id="extrainfo" name="extrainfo"></textarea>
						 	</div>
					</div>
			</div>
			<div class="col-md-6">
				<form class="form-horizontal">
					<div class="form-group">
						<div class="fa fa-facebook col-lg-1"></div>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="inputDate" name="social" placeholder="Facebook / Messenger">
						</div>
					</div>
					<div class="form-group">
						<div class="fa fa-twitter col-lg-1"></div>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="inputDate" name="social" placeholder="Twitter">
						</div>
					</div>
					<div class="form-group">
						<div class="fa fa-google col-lg-1"></div>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="inputDate" name="social" placeholder="Gmail">
						</div>
					</div>
					<div class="form-group">
						<div class="fa fa-skype col-lg-1"></div>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="inputDate" name="social" placeholder="Skype">
						</div>
					</div>
					<div class="form-group">
						<div class="fa fa-linkedin col-lg-1"></div>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="inputDate" name="social" placeholder="LinkedIn">
						</div>
					</div>					
					<div class="form-group">
						<div class="col-lg-12 text-center">
							<button type="submit" class="btn btn-default btn-lg btn-custom">Done!</button>
						</div>
					</div>
				</form>
			</div>
		</div><!--/modal-body row-->
	</form>
	</div> <!-- /container-->
	
	<footer class="footer">
		<p>© 2017 Find Your Programmer. All rights reserved</p>
	</footer>




	<!–- jQuery library (necessary for Bootstrap JavaScript plugins) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<!–- Bootstrap core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	</body>
</html>

<%
}
%>
