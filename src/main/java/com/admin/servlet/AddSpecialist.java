package com.admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SpecialistDao;
import com.db.DBConnect;
import com.entity.User;

/**
 * Servlet implementation class AddSpecialist
 */
@WebServlet("/AddSpecialist")
public class AddSpecialist extends HttpServlet {

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String specName = req.getParameter("specName");
		
		
		SpecialistDao dao = new SpecialistDao(DBConnect.getConn());
		boolean f = dao.addSpecialist(specName);
		
		 HttpSession session = req.getSession();
		 
		 if(f)
		 {
			
				 
				 session.setAttribute("msg", "Specialist Added");
					res.sendRedirect("admin/index.jsp");	
		 }
		 else
		 {
			 
				
				session.setAttribute("msg","Somthing Wrong on Server");
				res.sendRedirect("admin/index.jsp");
			}
			 
		 
	}

}
