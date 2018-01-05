<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fyp_classes.*" %>
<%@ page errorPage="fyp_errorPage.jsp" %>

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
		background: url(images/img2.jpg) no-repeat center center fixed;
		}
	</style>

	<title>Find your Programmer-Login</title>

	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/fyp-theme.css">
	</head>


	<body>

	<nav class="navbar navbar-inverse navbar-fixed-top navbar-custom">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand text-info" href="">Find your Programmer</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<a class="navbar-brand text-info" href="fyp_register.jsp"><small>
						Eγγραφή
					</small></a>
				</ul>
			</div>
		</div>
	</nav>


	<div class="container theme-showcase" role="main">
		<div class ="jumbotron">
			<h2>Καλωσήλθες στο Find your Programmer!</h2>
			<p>Συνδέσου ή κάνε εγγραφή, αναζήτησε άμεσα τον προγραμματιστή που χρειάζεσαι, συναντησέ τον και αξιολόγησε τη συνεργασία σας μέσα από τη σελίδα μας!</p>
		</div>
	</div>


	<div class="container">
		<div class ="row">

			<div class="col-xs-6 col-xs-offset-3 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4 col-lg-3 col-lg-offset-9 top-buffer">
				<div class="account-wall">
					<div id="my-tab-content" class="tab-content">
						<div class="tab-pane active" id="login">
							<form class="form-signin" action="fyp_loginController.jsp" method="post">
								<input type="text" class="form-control" name="username" placeholder="Username" required>
								<input type="password" class="form-control" name="password" placeholder="Password" required>
								<input type="submit" class="btn btn-lg btn-default btn-block" value="Sign In" />
							</form>
							<p class="text-center"><a href="fyp_register.jsp">Need an Account?</a></p>
						</div>
					</div>
				</div> <!-- loginform -->
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