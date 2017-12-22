<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fyp_classes.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
	ProgrLangDAO pldao = new ProgrLangDAO();
	ProgrammerDAO progdao = new ProgrammerDAO();
	RatingDAO ratdao = new RatingDAO();
	
	List<Programmer> programmers = new ArrayList<Programmer>();
	
%>

<!DOCTYPE html>
<html lang="el">

	<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Search Results">
	<meta name="author" content="yourprogr.gr">

	<style>
		body {
		background: url(images/default.jpg) no-repeat center center fixed;
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

		.modal-body p {
		    word-wrap: break-word;
		}
	</style>

	<title>Search Results</title>

	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/fyp-theme.css">
	</head>


	<body id="index">

	<nav class="navbar navbar-inverse navbar-fixed-top navbar-custom">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand text-info" href="fyp_index.jsp">Find your Programmer</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="fyp_index.jsp">Home</a></li>
					<li  class="active"><a href="fyp_search.jsp">Search</a></li>
					<li><a href="">MyMeetings</a></li>
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
		<div><h1>Αποτελέσματα Αναζήτησης<h1></div>
		</div>
	</div>



<div class="container">

<%
String slangid = request.getParameter("radios");
int langid = Integer.parseInt(slangid);
programmers = progdao.getProgrammersByLang(langid);
Programmer progr = null;


if(!programmers.isEmpty()) {

for(int i=0; i<programmers.size(); i++) {
	progr = programmers.get(i);
	int prid = progr.getProgrammerId();

%>

    <div class="span3 well">
        <center>
        <h3><%=progr.getName()%>&nbsp;<%=progr.getSurname()%></h3>
        <h4>Μ.Ο. Αξιολογήσεων:  </h4>
	<span><strong>Phone: </strong></span>
	<span class="label label-warning"><%=progr.getPhone()%></span>
	<span><strong>Email: </strong></span>
	<span class="label label-info"><%=progr.getEmail()%></span>
	<p class="text-left"><strong>Πληροφορίες: </strong><br>
	<%=progr.getExtraInfo()%></p>
	<a role="button" class="btn btn-default" href="fyp_meet.jsp?prID=<%out.print(prid);%>">Κλείσε ραντεβού</a> 
	</center>
    </div>
  
<%
} 

} else {
%>

<div class="alert alert-warning" role="alert">Δεν υπάρχουν καταχωρημένοι προγραμματιστές γι' αυτή την κατηγορία.</div>

<%
	}
%>
    
</div>


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
