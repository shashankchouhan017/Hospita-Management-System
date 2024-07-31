<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDao"%>
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
.backImg{
background : linear-gradient(rgba(0,0,0,.4)),rgba(0,0,0,.4)),url("img/doc6.png");
height:20vh;
width : 100%
background-size :cover;
background-repeat:no-repeat;

}

</style>
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container-fulid backImg p-5">

<p class="text-center fs-2 text-white" > </p>

</div>
<div class="container-fluid p-3">

<div class="row">
<div class="col-md-6 offset-md-3">


	<div class="card point-card">
	<div class="card-body">
	
	<p class="fs-4 text-center "> Patient Comment</p>
	
	<%
	
	String name = request.getParameter("fullname");
	AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
	Appointment ap = dao.getAppointmentByName(name);
	
	
	
	%>
	
	
	
	<form class="row" action="../UpdateStatus" method="Post">
	<div class="col-md-6">
	<label class="form-label">Paitent Name</label>
	<input type="text" readonly="readonly" class="form-control" value="<%=ap.getFullname()%>"/>
	
	</div>
		
	<div class="col-md-6">
	<label class="form-label"> Age</label>
	<input type="text" readonly class="form-control" value="<%=ap.getAge()%>"/>
	</div>
	<div class="col-md-6">
	<label class="form-label">Mobile No.</label>
	<input type="text" readonly="readonly" class="form-control" value="<%=ap.getPhno()%>"/>
	
	</div>
	
		
	<div class="col-md-6">
	<label class="form-label">Disease</label>
	<input type="text" readonly="readonly" class="form-control" value="<%=ap.getDisease()%>"/>
	
	</div>
	
	<div class="col-md-12">
	<label class="form-label">Comment</label>
	<textarea name="comm"  class="form-control" rows="3" cols=""></textarea>
	</div>
	<input  type="hidden" name="pName"value="<%=ap.getFullname()%>"/>
	<input type="hidden" name="docName" value="<%=ap.getDocName()%>"/>
	
	
	<button type="submit" class=" mt-3 btn btn-primary col-md-6 offset-md-3">Submit</button>
	
	
	</form>
	</div>
	</div>

</div>
</div>
</div>
</body>
</html>