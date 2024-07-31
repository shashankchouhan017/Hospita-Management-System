package com.admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;


/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try
		{
			String email = req.getParameter("email");
			String pass = req.getParameter("pass");
			 HttpSession session = req.getSession();
			 
			 if("admin@gmail.com".equals(email) && "admin".equals(pass))
			 {
				
					
					 session.setAttribute("adminObj",new User());
						res.sendRedirect("admin/index.jsp");
			 }
			 else
			 {
				 
					
					session.setAttribute("msg","Invalid Email and Password");
					res.sendRedirect("admin_login.jsp");
				}
				 
			 
			
		}
		catch(Exception ex )
		{
			ex.printStackTrace();
		}
	}

}
