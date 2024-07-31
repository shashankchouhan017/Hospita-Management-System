<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Login Page</title>
<%@ include file="componenet/allcss.jsp" %>

<style>
.point-card{
box-shadow:0 0 10px 0 rgba(0,0,0,0.3);
}

</style>

</head>
<body>
<%@ include file="componenet/navbar.jsp" %>

<div class="container p-5">
	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card point-card">
				<div class="card-body">
					<p class="fs-4 text-center">Doctor Login</p>
					<%-- <c:if test="${not empty errorMsg }">
					<p class="fs-4 text-center text-danger">${errorMsg }</p>
					<c:remove var="errorMsg" scope="session"/>
					</c:if>
					<c:if test="${not empty succMsg }">
					<p class="fs-4 text-center text-danger">${succMsg }</p>
					<c:remove var="errorMsg" scope="session"/>
					</c:if> --%>
					
					<form action="DoctorLogin" method="post">
						<div class="mb-3">
						<label class="form-label">Email Address</label> <input required type="email" name="email" class="form-control"/>
						
						</div>
						
						<div class="mb-3">
						<label class="form-label">Password</label> <input required type="password" name="pass" class="form-control"/>
						
						</div>
					<button type="submit" class="btn bg-success text-white col-md-12"> Login</button>
					</form>
					
				</div>
			</div>
		</div>
	</div>
</div>



</body>
</html>