package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Appointment;

public class AppointmentDao {

	private Connection conn;

	public AppointmentDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addAppointmen(Appointment ap)
	{
		boolean f = false;
		try {
			
			PreparedStatement ps = conn.prepareStatement("insert into appointment values(?,?,?,?,?,?,?,?,?,?,?)");
		
			ps.setString(1, ap.getFullname());
			ps.setString(2,ap.getGender());
			ps.setString(3, ap.getAge());
			ps.setString(4, ap.getAppoinDate());
			ps.setString(5, ap.getEmail());
			ps.setString(6, ap.getPhno());
			ps.setString(7, ap.getDisease());
			ps.setString(8,ap.getDocName());
			ps.setString(9, ap.getAddress());
			ps.setString(10, ap.getStatus());	
			ps.setString(11, ap.getUserName());
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
		
		
	}
	
	public List<Appointment> getAllAppointment(String username)
	{
		
	
		List<Appointment> list = new  ArrayList<Appointment>();
		Appointment ap = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from appointment where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ap  = new Appointment();
				
				ap.setFullname(rs.getString(1));
				ap.setGender(rs.getString(2));
				ap.setAge(rs.getString(3));
				ap.setAppoinDate(rs.getString(4));
				ap.setEmail(rs.getString(5));
				ap.setPhno(rs.getString(6));
				ap.setDisease(rs.getString(7));
				ap.setDocName(rs.getString(8));
				ap.setAddress(rs.getString(9));
				ap.setStatus(rs.getString(10));
				ap.setUserName(rs.getString(11));
				list.add(ap);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
		
		
	}
	public List<Appointment> getAllAppointmentByDoctor(String docname)
	{
		
		
		List<Appointment> list = new  ArrayList<Appointment>();
		System.out.println(docname +" Docotr name in Appointment dao");
		Appointment ap = null;
		try {
			
			PreparedStatement ps = conn.prepareStatement("select * from appointment where docname=?");
			ps.setString(1, docname);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ap  = new Appointment();
				
				ap.setFullname(rs.getString(1));
				ap.setGender(rs.getString(2));
				ap.setAge(rs.getString(3));
				ap.setAppoinDate(rs.getString(4));
				ap.setEmail(rs.getString(5));
				ap.setPhno(rs.getString(6));
				ap.setDisease(rs.getString(7));
				ap.setDocName(rs.getString(8));
				ap.setAddress(rs.getString(9));
				ap.setStatus(rs.getString(10));
				ap.setUserName(rs.getString(11));
				list.add(ap);
				System.out.println(docname +" Docotr name in Appointment dao");
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
		
		
	}
	
	public List<Appointment> getAllAppointment()
	{
		
		
		List<Appointment> list = new  ArrayList<Appointment>();
		
		Appointment ap = null;
		try {
			
			PreparedStatement ps = conn.prepareStatement("select * from appointment order by fullname desc");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ap  = new Appointment();
				
				ap.setFullname(rs.getString(1));
				ap.setGender(rs.getString(2));
				ap.setAge(rs.getString(3));
				ap.setAppoinDate(rs.getString(4));
				ap.setEmail(rs.getString(5));
				ap.setPhno(rs.getString(6));
				ap.setDisease(rs.getString(7));
				ap.setDocName(rs.getString(8));
				ap.setAddress(rs.getString(9));
				ap.setStatus(rs.getString(10));
				ap.setUserName(rs.getString(11));
				list.add(ap);
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
		
		
	}
	
	
	
	public Appointment getAppointmentByName(String pName)
	{
		
		
		
		
		Appointment ap = null;
		try {
			
			PreparedStatement ps = conn.prepareStatement("select * from appointment where fullname=?");
			ps.setString(1, pName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ap  = new Appointment();
				
				ap.setFullname(rs.getString(1));
				ap.setGender(rs.getString(2));
				ap.setAge(rs.getString(3));
				ap.setAppoinDate(rs.getString(4));
				ap.setEmail(rs.getString(5));
				ap.setPhno(rs.getString(6));
				ap.setDisease(rs.getString(7));
				ap.setDocName(rs.getString(8));
				ap.setAddress(rs.getString(9));
				ap.setStatus(rs.getString(10));
				ap.setUserName(rs.getString(11));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ap;
		
		
	}
	
	public boolean updateCommentStatus(String pName,String docName, String comm)
	{
		boolean f = false;
		try {
			
			PreparedStatement ps = conn.prepareStatement("update appointment set status=? where fullname=? and docname=?");
			ps.setString(1, comm);
			ps.setString(2, pName);
			ps.setString(3, docName);
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
