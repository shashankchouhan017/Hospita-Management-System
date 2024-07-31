package com.admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;

/**
 * Servlet implementation class DeleteDoctor
 */
@WebServlet("/DeleteDoctor")
public class DeleteDoctor extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		
	
		DoctorDao dao = new DoctorDao(DBConnect.getConn());
		HttpSession session = req.getSession();
		
		
		if(dao.deletDoctor(name))
		{
			
			 
			 session.setAttribute("msg", "Doctor Delete Successfull");
				res.sendRedirect("admin/doctor.jsp");
			 
		}
		else
		{
			
			 
			 session.setAttribute("msg", "somthing Wrong on Server ");
				res.sendRedirect("admin/doctor.jsp");
			 
		}
	}

}
