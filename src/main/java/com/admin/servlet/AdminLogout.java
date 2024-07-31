package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogout
 */
@WebServlet("/AdminLogout")
public class AdminLogout extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		session.removeAttribute("adminObj");
		session.setAttribute("msg", "Admin Logout Succesfully");
		res.sendRedirect("admin_login.jsp");
		
		
		
	}
	
	

}
