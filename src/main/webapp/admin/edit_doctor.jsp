<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Specalist"%>
<%@page import="com.entity.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.SpecialistDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="../componenet/allcss.jsp" %>
<style>
.point-card{
box-shadow:0 0 10px 0 rgba(0,0,0,0.3);
}

</style>
</head>
<body>
<%@ include file="navbar.jsp" %>


<div class="container-fluid p-3">

<div class="row">
<div class="col-md-4 offset-md-4">


	<div class="card point-card">
	<div class="card-body">
	
	<p class="fs-3 text-center"> Edit Doctor Details</p>
	
	<% 
	
	String name = request.getParameter("fullname");
	DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
	
	Doctor d = dao2.getDoctorByName(name);
	
	%>
	
	
	
	
	
	<form action="../UpdateDoctor" method="Post">
	<div class="mb-3">
	<label class="form-label">Full Name</label>
	<input type="text" required name="fullname" class="form-control" value="<%= d.getFullName()%>"/>
	
	</div>
		
	<div class="mb-3">
	<label class="form-label">DOB</label>
	<input type="date" required name="dob" value="<%= d.getDob()%>"class="form-control"/>
	
	</div>
	<div class="mb-3">
	<label class="form-label">Qualification</label>
	<input type="text" required name="quali" value="<%= d.getQualification()%>" class="form-control"/>
	
	</div>
	
	<div class="mb-3">
	<label class="form-label">Specialist</label>
	<select  required name="spec" class="form-control">
	<option ><%= d.getSpecialist()%></option>
	
	<%
	
	SpecialistDao dao = new SpecialistDao(DBConnect.getConn());
	List <Specalist> list = dao.getAllSpecialist();
	for(Specalist s : list)
	{ %>
	
	<option><%=s.getSpecalistName() %></option>
	
	<% 	
	}
	%>

	
	
	</select>
	
	</div>
	
	<div class="mb-3">
	<label class="form-label">Email</label>
	<input type="email" required name="email" value="<%= d.getEmail()%>" class="form-control"/>
	
	</div>
	
	<div class="mb-3">
	<label class="form-label">Mob No.</label>
	<input type="text" required name="mobno" value="<%= d.getMobNo()%>" class="form-control"/>
	
	</div>
	<div class="mb-3">
	<label class="form-label">Password</label>
	<input type="password" required name="pass" value="<%= d.getPass()%>" class="form-control"/>
	
	</div>
	
	
	<button type="submit" class="btn btn-primary" >Update</button>
	
	
	</form>
	</div>
	</div>

</div>



</div>
</div>
</body>
</html>