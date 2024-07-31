
 <%@ page import="com.entity.*" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><i class="fa-solid fa-hospital"></i> MEDI HOME</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
      
       <li class="nav-item" ><a class="nav-link active" href="home.jsp">HOME</a></li>
       <li class="nav-item" ><a class="nav-link active" href="paitent.jsp">PAITENT</a></li>
       
       
       
      </ul>
      
         
      <%
      Doctor d = (Doctor)session.getAttribute("docObj");
      
      %>
     
    <div class="dropdown">
  <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenu2" data-bs-toggle="dropdown" aria-expanded="false">
   <%=d.getFullName() %>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
    <li><a class="dropdown-item" href="../docLogout">Logout</a></li>
  </ul>
	</div>
     
     </div>
     
     
     
      
    </div>
  
</nav>


























