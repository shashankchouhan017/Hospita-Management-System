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
<%@ include file="../componenet/allcss.jsp" %>

<style>
.card-point{
box-shadow:0 0 10px 0 rgba(0,0,0,0.3);
}

</style>
</head>
<body>
<%@ include file="navbar.jsp" %>

<div class="col-md-12">
<div class="card point-card">
<div class="card-body">
<p class="fs-3 text-center "> Paitent Details</p>

<table class="table">
<thead>

<tr>
<th scope="col">PAITENT NAME</th>
<th scope="col">GENDER</th>
<th scope="col">AGE</th>
<th scope="col">APPOINTMENT </th>
<th scope="col">PAITENT EMAIL</th>
<th scope="col">Phone No</th>
<th scope="col">DISEASES</th>
<th scope="col">DOCTOR NAME</th>
<th scope="col">STATUS</th>
<th scope="col">ADDRESS</th>

</tr>

</thead>
<tbody>
<%
 

AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
List <Appointment> list = dao.getAllAppointment();
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
	<td><%=ap.getDocName() %></td>
	<td><%=ap.getStatus() %></td>
	<td><%=ap.getAddress() %></td>
	<td></td>
		
		<%
	
	
	}
	%>






</tbody>



</table>




</div>
</div>
</div>




</body>
</html>