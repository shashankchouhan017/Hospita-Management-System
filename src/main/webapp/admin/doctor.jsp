
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
<div class="col-md-4">


	<div class="card point-card">
	<div class="card-body">
	
	<p class="fs-3 text-center"> Add Doctor</p>
	<form action="../AddDoctor" method="Post">
	<div class="mb-3">
	<label class="form-label">Full Name</label>
	<input type="text" required name="fullname" class="form-control"/>
	
	</div>
		
	<div class="mb-3">
	<label class="form-label">DOB</label>
	<input type="date" required name="dob" class="form-control"/>
	
	</div>
	<div class="mb-3">
	<label class="form-label">Qualification</label>
	<input type="text" required name="quali" class="form-control"/>
	
	</div>
	
	<div class="mb-3">
	<label class="form-label">Specialist</label>
	<select  required name="spec" class="form-control">
	<option >----Select----</option>
	
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
	<input type="email" required name="email" class="form-control"/>
	
	</div>
	
	<div class="mb-3">
	<label class="form-label">Mob No.</label>
	<input type="text" required name="mobno" class="form-control"/>
	
	</div>
	<div class="mb-3">
	<label class="form-label">Password</label>
	<input type="password" required name="pass" class="form-control"/>
	
	</div>
	
	
	<button type="submit" class="btn btn-primary">Submit</button>
	
	
	</form>
	</div>
	</div>

</div>


<div class="col-md-8">
<div class="card point-card">
<div class="card-body">
<p class="fs-3 text-center"> Doctor Detials</p>

<table class="table">
<thead>

<tr>
<th scope="col">FULL NAME</th>
<th scope="col">DOB</th>
<th scope="col">QUALIFICATION</th>
<th scope="col">SPECIALIST</th>
<th scope="col">EMAIL</th>
<th scope="col">MOBILE NO</th>
<th scope="col">Action</th>

</tr>

</thead>
<tbody>

<%
DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
List<Doctor> l1 = dao2.getAllDoctor();
for(Doctor d :l1)
{
%>
<tr>
<td><%= d.getFullName()%></td>
<td><%= d.getDob()%></td>
<td><%= d.getQualification()%></td>
<td><%= d.getSpecialist()%></td>
<td><%=d.getEmail() %></td>
<td><%=d.getMobNo() %></td>
<td><a href="../edit_doctor.jsp?fullname=<%=d.getFullName()%>" class="btn btn-sm btn-primary">Edit</a> &nbsp;
<a href="../DeleteDoctor?name=<%=d.getFullName()%>" class="btn btn-sm btn-danger">Delete</a></td>

</tr>
<% 
}
%>


</tbody>



</table>




</div>
</div>

</div>



</div>
</div>
</body>
</html>