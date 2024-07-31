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


@WebServlet("/UpdateDoctor")
public class UpdateDoctor extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String fullname = req.getParameter("fullname");
			String dob 	    = req.getParameter("dob");
			String quali    = req.getParameter("quali");
			String spec     = req.getParameter("spec");
			String email    = req.getParameter("email");
			String mobno    = req.getParameter("mobno");
			String pass     = req.getParameter("pass");
			
			
			Doctor d = new Doctor(fullname, dob, quali, spec, email, mobno, pass);
			DoctorDao dao = new DoctorDao(DBConnect.getConn());
			HttpSession session = req.getSession();
			
			
			if(dao.updateDoctor(d))
			{
				
				 
				 session.setAttribute("msg", "Doctor Update Successfull");
					res.sendRedirect("admin/doctor.jsp");
				
			}
			else
			{
				
				 
				 session.setAttribute("msg", "somthing Wrong on Server ");
					res.sendRedirect("admin/doctor.jsp");
				 
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
