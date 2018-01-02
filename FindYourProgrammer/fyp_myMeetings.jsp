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
		
		
		.bs-calltoaction{
		    position: relative;
		    width:auto;
		    padding: 15px 25px;
		    border: 1px solid black;
		    margin-top: 10px;
		    margin-bottom: 10px;
		    border-radius: 5px;
		}
		
		    .bs-calltoaction > .row{
		        display:table;
		        width: calc(100% + 30px);
		    }
		     
		        .bs-calltoaction > .row > [class^="col-"],
		        .bs-calltoaction > .row > [class*=" col-"]{
		            float:none;
		            display:table-cell;
		            vertical-align:middle;
		        }
		
		            .cta-contents{
		                padding-top: 10px;
		                padding-bottom: 10px;
		            }
		
		                .cta-title{
		                    margin: 0 auto 15px;
		                    padding: 0;
		                }
		
		                .cta-desc{
		                    padding: 0;
		                }
		
		                .cta-desc p:last-child{
		                    margin-bottom: 0;
		                }
		
		            .cta-button{
		                padding-top: 10px;
		                padding-bottom: 10px;
		            }
		
		@media (max-width: 991px){
		    .bs-calltoaction > .row{
		        display:block;
		        width: auto;
		    }
		
		        .bs-calltoaction > .row > [class^="col-"],
		        .bs-calltoaction > .row > [class*=" col-"]{
		            float:none;
		            display:block;
		            vertical-align:middle;
		            position: relative;
		        }
		
		        .cta-contents{
		            text-align: center;
		        }
		}
		
		
		
		.bs-calltoaction.bs-calltoaction-default{
		    color: #333;
		    background-color: #fff;
		    border-color: #ccc;
		}
		
		.bs-calltoaction.bs-calltoaction-primary{
		    color: #fff;
		    background-color: #337ab7;
		    border-color: #2e6da4;
		}
		
		.bs-calltoaction.bs-calltoaction-info{
		    color: #fff;
		    background-color: #5bc0de;
		    border-color: #46b8da;
		}
		
		.bs-calltoaction.bs-calltoaction-success{
		    color: #fff;
		    background-color: #5cb85c;
		    border-color: #4cae4c;
		}
		
		.bs-calltoaction.bs-calltoaction-warning{
		    color: #fff;
		    background-color: #f0ad4e;
		    border-color: #eea236;
		}
		
		.bs-calltoaction.bs-calltoaction-danger{
		    color: #fff;
		    background-color: #d9534f;
		    border-color: #d43f3a;
		}
		
		.bs-calltoaction.bs-calltoaction-primary .cta-button .btn,
		.bs-calltoaction.bs-calltoaction-info .cta-button .btn,
		.bs-calltoaction.bs-calltoaction-success .cta-button .btn,
		.bs-calltoaction.bs-calltoaction-warning .cta-button .btn,
		.bs-calltoaction.bs-calltoaction-danger .cta-button .btn{
		    border-color:#fff;
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
					<li class="active"><a href="fyp_myMeetings.jsp">MyMeetings</a></li>
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
		<div><h1>Έλεγξε τα meetings σου και αξιολόγησε τα<h1></div>
		</div>
	</div>
	<div class="container">
		<div class="col-sm-12">
	
<%

MeetDAO meetdao = new MeetDAO();
Programmer programmer;
List<Meet> meets = meetdao.getMeetsByCustomer(customer.getUsername());
List<Integer> ids = meetdao.getMeetIDsByCustomer(customer.getUsername());
Meet meet = null;
int meetid;

if(!meets.isEmpty()) {

	for(int i=0; i<meets.size(); i++) {
	
		meet = meets.get(i);
		programmer = meet.getProgrammer();
		meetid = ids.get(i);
		

%>
	

	                <div class="bs-calltoaction bs-calltoaction-warning">
	                    <div class="row">
	                        <div class="col-md-9 cta-contents">
	                            <h1 class="cta-title"><%=programmer.getName()%>&nbsp<%=programmer.getSurname()%></h1>
	                            <div class="cta-desc">
	                                <p>Location: <%= meet.getPlace()%></p>
	                                <p>Date: <%=meet.getDate()%></p>
	                                <p>Time: </h3><%=meet.getTime()%></p>
	                                <p>Info: </h3><%=meet.getExtrainfo()%></p>
	                            </div>
	                        </div>
	                        <div class="col-md-3 cta-button">
	                            <a class="btn btn-lg btn-block btn-warning" href="fyp_rating.jsp?meetid=<%out.print(meetid);%>">Αξιολόγησε!</a>
	                        </div>
	                     </div>
                	</div>

         
<%
} 

} else {
%>

<div class="alert alert-warning" role="alert">Δεν έχετε πραγματοποιήσει κανένα meeting</div>

<%
	}
%>
                </div>
         </div>

	
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
