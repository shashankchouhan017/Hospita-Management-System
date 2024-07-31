package com.doctor.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.db.DBConnect;

/**
 * Servlet implementation class UpdateStatus
 */
@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet {
	

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			
			String pName = req.getParameter("pName");
			String docName = req.getParameter("docName");
			String comm = req.getParameter("comm");
			
			AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
			HttpSession session = req.getSession();
			if(dao.updateCommentStatus(pName, docName, comm))
			{
				session.setAttribute("msg","Comment Updated" );
				res.sendRedirect("doctor/paitent.jsp");
			}
			else
			{
				session.setAttribute("msg","Something wrong on server" );
				res.sendRedirect("doctor/paitent.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
