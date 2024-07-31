package com.user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try
		{
			String email = req.getParameter("email");
			String pass = req.getParameter("pass");
			 HttpSession session = req.getSession();
			 
			 UserDao dao = new UserDao(DBConnect.getConn());
			 
			 
			 User user = dao.login(email, pass);
			
			
			 
			 if(user!=null)
			 {
				
				
				 session.setAttribute("userObj", user);
					res.sendRedirect("UserView.jsp");
					
			 }
			 else
			 {
				 
					
					session.setAttribute("msg","Invalid Email and Password");
					 res.sendRedirect("user_login.jsp");
			}
				 
			 
			
		}
		catch(Exception ex )
		{
			ex.printStackTrace();
		}
	}

}
