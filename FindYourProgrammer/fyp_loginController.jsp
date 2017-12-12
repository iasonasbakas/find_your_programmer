<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fyp_classes.*" %>
<%@ page errorPage="fyp_errorPage.jsp" %>

<%
String username = request.getParameter("username");
String password = request.getParameter("password");

CustomerDAO customerdao = new CustomerDAO();

try {
	customerdao.authenticate(username, password);
	
} catch(Exception e) {

	request.setAttribute("message", "Wrong credentials");
%>
	<jsp:forward page="fyp_index.jsp"/>
<%

}

session.setAttribute("customer-object", customerdao.findCustomer(username));

%>

<jsp:forward page="fyp_indexCustomer.jsp"/>
