package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.Doctor;
import com.entity.User;

/**
 * Servlet implementation class DoctorLogin
 */
@WebServlet("/DoctorLogin")
public class DoctorLogin extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		
		
		try{
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		 HttpSession session = req.getSession();
		 
		 DoctorDao  dao = new DoctorDao(DBConnect.getConn())  ;
		 
		 
		 Doctor d = dao.login(email, pass);
		
		
		 
		 if(d!=null)
		 {
			
			 session.setAttribute("docObj", d);
			 res.sendRedirect("doctor/index.jsp");
				
		 }
		 else
		 {
			 
				
				session.setAttribute("msg","Invalid Email and Password");
				 res.sendRedirect("doctor_login.jsp");
		}
			 
		 
		}
	
	catch(Exception ex )
	{
		ex.printStackTrace();
	}

	
}

}