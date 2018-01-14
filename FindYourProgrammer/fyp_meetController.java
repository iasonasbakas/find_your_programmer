import fyp_classes.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class fyp_meetController extends HttpServlet {

	public void doPost (HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer-object");

		if(session.getAttribute("customer-object") == null) {

			request.setAttribute("message", "You are not authorized to access this resource. Please login.");

		}else {

			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = new PrintWriter(response.getWriter(), true);

			String place = request.getParameter("place");
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String extrainfo = request.getParameter("extrainfo");
			String fb = request.getParameter("fb");
			String tw = request.getParameter("tw");
			String gm = request.getParameter("gm");
			String sk = request.getParameter("sk");
			String lin = request.getParameter("lin");
			String social;

			if(!fb.isEmpty()) {
				social = "fb/"+fb;
			} else if (!tw.isEmpty()) {
				social = "tw/"+tw;
			} else if (!gm.isEmpty()) {
				social = "gm/"+gm;
			} else if (!sk.isEmpty()) {
				social = "sk/"+sk;
			} else {
				social = "lin/"+lin;
			}


			DataValidation data = new DataValidation();

			Programmer programmer = (Programmer) session.getAttribute("programmer-object");
			int prid = programmer.getProgrammerId();

		try {

			out.println("<!DOCTYPE html>");
			out.println("<html lang='el'>");
			out.println("	<head>");
			out.println("	<meta charset='UTF-8'>");
			out.println("	<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
			out.println("	<meta name='viewport' content='width=device-width, initial-scale=1'>");
			out.println("	<meta name='description' content='Register'>");
			out.println("	<meta name='author' content='yourprogr.gr'>");

			out.println("	<style>");
			out.println("		body {");
			out.println("		background: url(../images/reg_img.jpg) no-repeat center center fixed;");
			out.println("		-webkit-background-size: cover;");
			out.println("		-moz-background-size: cover;");
			out.println("		-o-background-size: cover;");
			out.println("		background-size: cover;");
			out.println("		padding-top: 30px;");
			out.println("		overflow-x: hidden;");
			out.println("		min-height: 100%;");
			out.println("    	height: auto;");
			out.println("    	margin: 0px;");
			out.println("		}");

			out.println("		#index label {");
			out.println("		   color:white;");
			out.println("		}");

			out.println("		#index h1 {");
			out.println("			color:white;");
			out.println("		}");
			out.println("	</style>");

			out.println("	<title>Meeting</title>");
			out.println("");
			out.println("	<link rel='stylesheet' href='../css/bootstrap.min.css'>");
			out.println("	<link rel='stylesheet' href='../css/fyp-theme.css'>");
			out.println("	</head>");
			out.println("");
			out.println("");
			out.println("	<body id='index'>");
			out.println("");
			out.println("<nav class='navbar navbar-inverse navbar-fixed-top navbar-custom'>");
			out.println("	<div class='container'>");
			out.println("		<div class='navbar-header'>");
			out.println("			<button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#navbar' aria-expanded='false' aria-controls='navbar'>");
			out.println("				<span class='sr-only'>Toggle navigation</span>");
			out.println("				<span class='icon-bar'></span> <span class='icon-bar'></span>");
			out.println("				<span class='icon-bar'></span>");
			out.println("			</button>");
			out.println("			<a class='navbar-brand text-info' href='../fyp_index.jsp'>Find your Programmer</a>");
			out.println("		</div>");
			out.println("		<div id='navbar' class='navbar-collapse collapse'>");
			out.println("			<ul class='nav navbar-nav'>");
			out.println("				<li class='active'><a href='../fyp_search.jsp'>Search</a></li>");
			out.println("				<li><a href='../fyp_myMeetings.jsp'>MyMeetings</a></li>");
			out.println("			</ul>");
			out.println("				<ul class='nav navbar-nav navbar-right'>");
			out.println("					<li class='dropdown'>");
			out.println("					<a id='customer' class='dropdown-toggle' data-toggle='dropdown' >");
			out.println("						<span class='glyphicon glyphicon-user'></span>"+customer.getUsername()+"<span class='caret'></span></a>");
			out.println("					<ul class='dropdown-menu'>");
			out.println("						<li><a href='../fyp_logout.jsp'>Logout</a></li>");
			out.println("					</ul>");
			out.println("					</li>");
			out.println("				</ul>");
			out.println("		</div>");
			out.println("	</div>");
			out.println("</nav>");
			out.println("	<div class='container theme-showcase' role='main'>");
			out.println("		<div class='page-header'>");
			out.println("		<div><h1>Meeting<h1></div>");
			out.println("		</div>");
			out.println("	</div>");
			out.println("");
			out.println("	<div class='container'>");


			if(data.isDateValid(date) && data.isTimeValid(time)) {

				out.println("			<div class='alert alert-success col-lg-12'><strong>Your meeting has been registered to the Database</strong>");
				out.println("			");
				out.println("			<ul class='list-unstyled'>");
				out.println("				<li><b><br>Place: </b>"+place+"</li>");
				out.println("				<li><b>Date: </b>" +date+" </li>");
				out.println("				<li><b>Time: </b>"+time+"</li>");
				out.println("				<li><b>ExtraInfo: </b>"+extrainfo+"</li>");
				out.println("				<li><b>Social: </b>"+social+"</li>");
				out.println("			</ul></div>");
				out.println("			<div class='form-group'>");
				out.println("				<div class='col-md-6 col-md-offset-5' >");
				out.println("					<a role='button' type='submit' class='btn btn-primary btn-lg' href='../fyp_index.jsp'><span class='glyphicon glyphicon glyphicon-home'></span>Home</a>");
				out.println("				</div>");
				out.println("			</div>");

				MeetDAO meetdao = new MeetDAO();
				Meet meet = new Meet(date, time, place, extrainfo, social, customer, programmer);
				meetdao.saveMeet(meet);

			} else {

				out.println("			<div class='alert alert-warning col-lg-12'>");
				out.println("				<ol type='1'>");
				if(!data.isDateValid(date)){
				out.println("					<li>Date 's not valid</li>");
				}
				if(!data.isTimeValid(time)) {
				out.println("					<li>Time 's not valid</li>");
				}
				out.println("				</ol>");
				out.println("			</div>");
				out.println("			<div class='form-group'>");
				out.println("				<div class='col-md-6 col-md-offset-5' >");
				out.println("					<a role='button' type='submit' class='btn btn-primary btn-lg' href='../fyp_meet.jsp?prID="+prid+"'><span class='glyphicon glyphicon-chevron-left'></span>Back to the form</a>");
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
