<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.DoctorDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../componenet/allcss.jsp" %>
<style>
.point-card{
box-shadow:0 0 10px 0 rgba(0,0,0,0.3);
}

</style>
</head>
<body>
<%@ include file="navbar.jsp" %>

<p class="text-center fs-3"> Doctor Dashboard</p>
<%
Doctor doc = (Doctor)session.getAttribute("docObj");
DoctorDao dao =  new DoctorDao(DBConnect.getConn());

%>
<div class="container p-5">
<div class="row"				>
 <div class="col-md-4 offset-md-2">
 	<div class="card point-card">
 <div class="card-body text-center text-success">
 <i class="fas fa-user-md fa-3x" ></i><br>
 <p class="fs-4 text-center">Doctor<br><%=dao.countDoctor() %></p>
 
 </div>
 </div>
 </div>
 
 
 <div class="col-md-4 ">
 	<div class="card point-card">
 <div class="card-body text-center text-success">
 <i class="fas fa-calendar-check fa-3x" ></i><br>
 <p class="fs-4 text-center">Total  Appointment<br><%=dao.countAppointnment() %></p>
 
 </div>
 </div>
 </div>
 
 
 
 
 
 
 
 </div>
 </div>
</body>
</html>