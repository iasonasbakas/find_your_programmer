import fyp_classes.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class fyp_ratingController extends HttpServlet {

	public void doPost (HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer-object");

		if(session.getAttribute("customer-object") == null) {

			request.setAttribute("message", "You are not authorized to access this resource. Please login.");

		}else {

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = new PrintWriter(response.getWriter(), true);

			String rating = request.getParameter("rating");
			String comments = request.getParameter("comments");

			DataValidation data = new DataValidation();

			Integer meetid = (Integer) session.getAttribute("meetid-object");


			try {

			out.println("<!DOCTYPE html>");
			out.println("<html lang='el'>");
			out.println("");
			out.println("	<head>");
			out.println("	<meta charset='UTF-8'>");
			out.println("	<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
			out.println("	<meta name='viewport' content='width=device-width, initial-scale=1'>");
			out.println("	<meta name='description' content='Rating'>");
			out.println("	<meta name='author' content='yourprogr.gr'>");
			out.println("	<style>");
			out.println("		body {");
			out.println("		background: url(../images/default.jpg) no-repeat center center fixed;");
			out.println("		-o-background-size: cover;");
			out.println("		background-size: cover;");
			out.println("		padding-top: 30px;");
			out.println("		overflow-x: hidden;");
			out.println("		min-height: 100%;");
			out.println("    		height: auto;");
			out.println("    		margin: 0px;");
			out.println("		}");
			out.println("		");
			out.println("		#index label {");
			out.println("		   color:white;");
			out.println("		}");
			out.println("		#index h1 {");
			out.println("			color:white;");
			out.println("		}");
			out.println("	</style>");
			out.println("");
			out.println("	<title>Find your Programmer</title>");
			out.println("");
			out.println("	<link rel='stylesheet' href='../css/bootstrap.min.css'>");
			out.println("	<link rel='stylesheet' href='../css/fyp-theme.css'>");
			out.println("	</head>");
			out.println("");
			out.println("");
			out.println("	<body id='index'>");
			out.println("");
			out.println("	<nav class='navbar navbar-inverse navbar-fixed-top navbar-custom'>");
			out.println("		<div class='container'>");
			out.println("			<div class='navbar-header'>");
			out.println("				<button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#navbar' aria-expanded='false' aria-controls='navbar'>");
			out.println("					<span class='sr-only'>Toggle navigation</span>");
			out.println("					<span class='icon-bar'></span> <span class='icon-bar'></span>");
			out.println("					<span class='icon-bar'></span>");
			out.println("				</button>");
			out.println("				<a class='navbar-brand text-info' href='../fyp_index.jsp'>Find your Programmer</a>");
			out.println("			</div>");
			out.println("			<div id='navbar' class='navbar-collapse collapse'>");
			out.println("				<ul class='nav navbar-nav'>");
			out.println("					<li><a href='../fyp_search.jsp'>Search</a></li>");
			out.println("					<li><a href='../fyp_myMeetings.jsp'>MyMeetings</a></li>");
			out.println("				</ul>");
			out.println("				<ul class='nav navbar-nav navbar-right'>");
			out.println("					<li class='dropdown'>");
			out.println("					<a id='customer' class='dropdown-toggle' data-toggle='dropdown' >");
			out.println("						<span class='glyphicon glyphicon-user'></span>"+customer.getUsername()+"<span class='caret'></span></a>");
			out.println("       					<ul class='dropdown-menu'>");
			out.println("       						<li><a href='../fyp_logout.jsp'>Logout</a></li>");
			out.println("       					</ul>");
			out.println("       					</li>	");
			out.println("				</ul>");
			out.println("			</div>");
			out.println("		</div>");
			out.println("	</nav>");
			out.println("	");
			out.println("	<div class='container theme-showcase' role='main'>");
			out.println("		<div class='page-header'>");
			out.println("		<div><h1>Rating<h1></div>");
			out.println("		</div>");
			out.println("	</div>");
			out.println("	");
			out.println("	<div class='container'>");

			if(data.isRatingValid(rating)) {

				out.println("			<div class='alert alert-success col-lg-12'><strong>Your rating has been registered to the Database</strong>");
				out.println("			");
				out.println("			<ul class='list-unstyled'>");
				out.println("				<li><b><br>Rating: </b>"+rating+"</li>");
				out.println("				<li><b>Comments: </b>" +comments+" </li>");
				out.println("			</ul></div>");
				out.println("			<div class='form-group'>");
				out.println("				<div class='col-md-6 col-md-offset-5' >");
				out.println("					<a role='button' type='submit' class='btn btn-primary btn-lg' href='../fyp_index.jsp'><span class='glyphicon glyphicon glyphicon-home'></span>Home</a>");
				out.println("				</div>");

				RatingDAO ratingdao = new RatingDAO();
				Rating rat = new Rating(rating,comments,null,null);
				ratingdao.saveRating(rat,meetid);

			} else {

				out.println("			<div class='alert alert-warning col-lg-12'>");
				out.println("				<ol type='1'>");
				if(!data.isRatingValid(rating)){
				out.println("					<li>Rating must be 0-5</li>");
				}
				out.println("				</ol>");
				out.println("			</div>");
				out.println("			<div class='form-group'>");
				out.println("				<div class='col-md-6 col-md-offset-5' >");
				out.println("					<a role='button' type='submit' class='btn btn-primary btn-lg' href='../fyp_rating.jsp?meetid="+meetid+"'><span class='glyphicon glyphicon-chevron-left'></span>Back to the form</a>");
				out.println("				</div>");
				out.println("			</div>");
			} // end_else
				out.println("		</div>");

				out.println("	<footer class='footer'>");
				out.println("		<p>&copy; 2017 Find Your Programmer. All rights reserved</p>");
				out.println("	</footer>");

				out.println("	<script src='../js/jquery.min.js'></script>");
				out.println("	<script	src='../js/bootstrap.min.js'></script>");

				out.println("	</body>");
				out.println("</html>");

			} catch (Exception ex) {
		  		out.println("Exception: " + ex.getMessage());
		   		out.println("</body>");
		   	 	out.println("</html>");
				}

	}

	}
}