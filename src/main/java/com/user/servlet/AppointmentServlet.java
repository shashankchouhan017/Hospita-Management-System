package com.user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.db.DBConnect;
import com.entity.Appointment;

/**
 * Servlet implementation class AppointmentServlet
 */
@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String fullname = req.getParameter("fullname");
		String gender 	    = req.getParameter("gender");
		String age    = req.getParameter("age");
		String appoint_date     = req.getParameter("appoint_date");
		String email    = req.getParameter("email");
		String phno    = req.getParameter("phno");
		String disease     = req.getParameter("diseases");
		String doct    = req.getParameter("doct");
		String address     = req.getParameter("address");
		
		Appointment ap = new Appointment(username,fullname, gender, age, appoint_date, email, phno, disease, doct, address, "pending");
		AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
		HttpSession session = req.getSession();
		
		
		if(dao.addAppointmen(ap))
		{
			session.setAttribute("msg", "Appointment Successfully");
			res.sendRedirect("user_appointment.jsp");
			
				
		}
		else
		{
			session.setAttribute("msg", "Somthing Wrong on server");
			res.sendRedirect("user_appointment.jsp");
		}
		
		
		
		
	}

}
