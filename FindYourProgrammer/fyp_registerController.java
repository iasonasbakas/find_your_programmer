import fyp_classes.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class fyp_registerController extends HttpServlet {

	public void doPost (HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = new PrintWriter(response.getWriter(), true);

		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordval = request.getParameter("password2");

		DataValidation data = new DataValidation();

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

			out.println("	<title>Register</title>");
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
			out.println("				<a class='navbar-brand text-info' href='../fyp_index.jsp'>Find your Programmer</a>");
			out.println("			</div>");
			out.println("		</div>");
			out.println("	</nav>");
			out.println("");
			out.println("	<div class='container theme-showcase' role='main'>");
			out.println("		<div class='page-header'>");
			out.println("		<div><h1>Register<h1></div>");
			out.println("		</div>");
			out.println("	</div>");
			out.println("");
			out.println("	<div class='container'>");


			if(data.isNameValid(name) && data.isNameValid(surname) && data.isValidEmailAddress(email) && data.isValidPhoneNumber(phone) && data.isPasswordValid(password, passwordval) && data.isUsernameValid(username)) {

				out.println("			<div class='alert alert-success col-lg-12'>The Student has been registered to the Database</div>");
				out.println("			<ul class='list-unstyled'>");
				out.println("				<li><b>Username: </b>"+username+"</li>");
				out.println("				<li><b>Name: </b>" +name+" </li>");
				out.println("				<li><b>Surname: </b>"+surname+"</li>");
				out.println("				<li><b>Phone: </b>"+phone+"</li>");
				out.println("				<li><b>Email: </b>"+email+"</li>");
				out.println("			</ul>");

				CustomerDAO custdao = new CustomerDAO();
				Customer customer = new Customer(username, password, name, surname, phone, email);
				custdao.saveCustomer(customer);

			} else {

				out.println("			<div class='alert alert-warning col-lg-12'>");
				out.println("				<ol type='1'>");
				if(!data.isUsernameValid(username)){
				out.println("					<li>This username is already in use. Please use another username.</li>");
				}
				if(data.isNull(username)) {
				out.println("					<li>Please give a username</li>");
				}
				if(data.isNull(password)) {
				out.println("					<li>Please give a password</li>");
				}
				if(!data.isNameValid(name)) {
				out.println("					<li>The name must be at least 3 characters long</li>");
				}
				if(!data.isNameValid(surname)) {
				out.println("					<li>The surname must be at least 3 characters long</li>");
				}
				if(!data.isPasswordValid(password, passwordval)) {
				out.println("					<li>Passwords don't match.</li>");
				}
				if(!data.isValidEmailAddress(email)) {
				out.println("					<li>The Email is not a valid email address</li>");
				}
				if(!data.isValidPhoneNumber(phone)) {
				out.println("					<li>The Phone must be a 10-digit number</li>");
				}
				out.println("				</ol>");
				out.println("			</div>");
				out.println("			<div class='form-group'>");
				out.println("				<div class='col-md-6 col-md-offset-5' >");
				out.println("					<a role='button' type='submit' class='btn btn-primary btn-lg' href='../register.html'><span class='glyphicon glyphicon-chevron-left'></span>Back to the form</a>");
				out.println("				</div>");
				out.println("			</div>");
			} // end_else
				out.println("		</div>");

				out.println("	<footer class='footer'>");
				out.println("		<p>&copy; 2017 Find Your Programmer. All rights reserved</p>");
				out.println("	</footer>");

				out.println("	<script src='js/jquery.min.js'></script>");
				out.println("	<script	src='js/bootstrap.min.js'></script>");

				out.println("	</body>");
				out.println("</html>");

			} catch (Exception ex) {
		  		out.println("Exception: " + ex.getMessage());
		   		out.println("</body>");
		   	 	out.println("</html>");
				}

	}
}
