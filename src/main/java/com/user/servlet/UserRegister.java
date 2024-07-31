package com.user.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try
		{
			String fullname = req.getParameter("fullname");
			String email = req.getParameter("email");
			String pass = req.getParameter("pass");
			 
			User u = new User(fullname,email,pass);
			UserDao dao = new UserDao(DBConnect.getConn());
			HttpSession session = req.getSession();
			boolean f = dao.userRegister(u);
			
			
				
			
			
		
			if(f)
			{
				session.setAttribute("msg", "Register Successfully");
				res.sendRedirect("signup.jsp");
				
			}
			else
			{
				session.setAttribute("msg", "Something Wrong on Server");
				res.sendRedirect("signup.jsp");
				
			}
			
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
			
		}
	}

}
