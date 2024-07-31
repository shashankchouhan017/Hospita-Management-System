<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.entity.*" %>
     <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="componenet/allcss.jsp" %>

<style>
/* .point-card{
box-shadow:0 0 10px 0 rgba(0,0,0,0.3);
}
.backImg{
background : Linear-gradient(rgba(0,0,0,.4)),rgba(0,0,0,.4)),url("img/doc6.png");
height:20vh;
width : 100%
background-size :cover;
background-repeat:norepeat;

}
 */
.banner{
 
 height: 120px; 
 }
</style>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><i class="fa-solid fa-hospital"></i> MEDI HOME</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div   class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
      
       <li  class="nav-item" ><a class="nav-link active" href="user_appointment.jsp">APPOINTMENT</a></li>
       <li class="nav-item" ><a class="nav-link active" href="view_appointment.jsp">VIEW APPOINTMENT</a></li>
      
      </ul>
      
     <%
      User user = (User)session.getAttribute("userObj");
      
      %>
      
     
    <div class="dropdown">
  <button class="btn btn-success dropdown-toggle" type="button" id="dropdownMenu2" data-bs-toggle="dropdown" aria-expanded="false">
  <i class="fa-solid fa-user-large"></i>  <%=user.getFullname() %>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
  	<li><a class="dropdown-item" href="../AdminLogout">Change Password</a></li>
    <li><a class="dropdown-item" href="UserLogout">Logout</a></li>
  </ul>
	</div>
     
     </div>
     </div>
</nav>

<img class="banner" src ="img/doc6.png" width="100%" />

<div class="container-fulid backImg p-5">

<p class="text-center fs-4" >  </p>

</div>

<div class="container p-3">
<div class="row">
<div class="col-md-9">
<div class="card point-card">
<div class="card-body">
<p class="fs-3 text-center text-success fw-bold"> Appointment List</p>

<table class="table">
<thead>

<tr>
<th scope="col">FULL NAME</th>
<th scope="col">GENDER</th>
<th scope="col">AGE</th>
<th scope="col">APPOINT DATE</th>
<th scope="col">DISEASES</th>
<th scope="col">DOCTOR NAME</th>
<th scope="col">STATUS</th>

</tr>

</thead>
<tbody>
<%

User user1 = (User)session.getAttribute("userObj");
AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
List <Appointment> list = dao.getAllAppointment(user.getFullname());
for(Appointment ap : list)
{
	%>
	
	<tr>
	<td><%=ap.getFullname() %></td>
	<td><%=ap.getGender() %></td>
	<td><%=ap.getAge() %></td>
	<td><%=ap.getAppoinDate() %></td>
	<td><%=ap.getDisease() %></td>
	<td><%=ap.getDocName() %></td>
	<td><%if("pending".equals(ap.getStatus()))
	{%>
	<a href="#" class="btn btn-sm btn-warning">Pending</a>
		
		
	<% }else{%>
	
		<%=ap.getStatus() %>
		
		
	<%}
	
	%></td>
	

	</tr>

	
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