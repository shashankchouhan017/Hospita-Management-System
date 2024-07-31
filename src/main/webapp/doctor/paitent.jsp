<%@page import="com.dao.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.entity.*" %>
    <%@page import="com.db.DBConnect"%>
    <%@page import="java.util.List"%>
<%@page import="com.dao.AppointmentDao"%>
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
<div class="container p-3">
<div class="row">
<div class="col-md-12">
<div class="card point-card">
<div class="card-body">
<p class="fs-3 text-center "> Paitent List</p>

<table class="table">
<thead>

<tr>
<th scope="col">FULL NAME</th>
<th scope="col">GENDER</th>
<th scope="col">AGE</th>
<th scope="col">APPOINT DATE</th>
<th scope="col">Email</th>
<th scope="col">Phone No</th>
<th scope="col">DISEASES</th>

<th scope="col">STATUS</th>
<th scope="col">Action</th>

</tr>

</thead>
<tbody>
<%
  Doctor doc  = (Doctor)session.getAttribute("docObj");

AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
List <Appointment> list = dao.getAllAppointmentByDoctor(doc.getFullName());
for(Appointment ap : list)
{
	%>
	
	<tr>
	<td><%=ap.getFullname() %></td>
	<td><%=ap.getGender() %></td>
	<td><%=ap.getAge() %></td>
	<td><%=ap.getAppoinDate() %></td>
	<td><%=ap.getEmail()%></td>
	<td><%=ap.getPhno() %></td>
	<td><%=ap.getDisease() %></td>
	<td><%=ap.getStatus() %></td>
	<td>
	<a href="comment.jsp?fullname=<%=ap.getFullname()%>" class="btn btn-success btn-sm">Comment</a></td>
		
		<%
	
	
	}
	%>






</tbody>



</table>




</div>
</div>
</div>

<div class="col-md-3 p-3">
<img alt="" src="img/doc5.png"/>

</div>

</div>
</div>


</body>
</html>