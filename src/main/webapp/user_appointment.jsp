<%@page import="com.entity.User"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.dao.*" %>
     <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="componenet/allcss.jsp" %>

<style>
.point-card{
box-shadow:0 0 8px 0 rgba(0,0,0,0.3);
}
/* .backImg{
background : Linear-gradient(rgba(0,0,0,.4)),rgba(0,0,0,.4)),url("img/doc6.png")';
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




<div class="container-fluid backImg p-5">
	<p class="text-center fs-2 text-white"></p>
</div>


<div class="container p-3">
	<div class="row">
	<div class="col-md-6 p-5">
		<img alt=" Doctor Image" src="img/doc5.png"/>
	
	</div>
		<div class="col-md-6">
			<div class="card point-card">
			<div class="card-body">
				<p class="text-center fs-3" > User Appointment</p>
				<form class="row g-3"  action="AppointmentServlet" method="post">
				<%
      User user1 = (User)session.getAttribute("userObj");
      
      %>
     
     <input type="hidden" value="<%= user1.getFullname()%>" name="username">
  <div class="col-md-6">
    <label class="form-label">Full Name</label>
    <input type="text" class="form-control" required name="fullname">
  </div>
  <div class="col-md-6">
    <label  class="form-label">Gender</label>
    <select  class="form-select" name="gender" required>
      <option value="male">Male</option>
      <option value="female">Female</option>
    </select>
  </div>
  <div class="col-6">
    <label  class="form-label">Age</label>
    <input type="number" class="form-control" required name="age" >
  </div>
  <div class="col-6">
    <label class="form-label">Appointment Date</label>
    <input type="date" class="form-control" required name="appoint_date">
  </div>
  <div class="col-md-6">
    <label  class="form-label">Email</label>
    <input type="email" class="form-control"  required name="email">
  </div>
  <div class="col-md-6">
    <label  class="form-label">Phone No</label>
    <input type="number" class="form-control"  name="phno" maxlength="10">
  </div>
  <div class="col-md-6">
    <label  class="form-label">Diseases</label>
    <input type="text" class="form-control" required name="diseases">
  </div>
  <div class="col-md-6">
    <label  class="form-label">Doctor</label>
    <select required class="form-select" name="doct">
      <option value="">---Select---</option>
      <%
      
DoctorDao dao = new DoctorDao(DBConnect.getConn());
List<Doctor> li = dao.getAllDoctor();
for(Doctor d : li)
{
	%>
	
	<option value="<%=d.getFullName() %>"><%=d.getFullName() %>(<%=d.getSpecialist() %>) </option>
	<%
}

%>

    </select>
  </div>
   <div class="col-md-12">
    <label  class="form-label">Address</label>
    <textarea required name="address"  class="form-control"  rows="3" cols=""></textarea>
  </div>
    <%-- <%
      User user = (User)session.getAttribute("userObj");
   
      
      %>
   --%>
  <div class="col-12">
    <button type="submit" class="btn btn-success col-md-6 offset-md-3">Submit</button>
  </div>
</form>
			</div>
			
			</div>
		</div>
	</div>
</div>
</body>
</html>