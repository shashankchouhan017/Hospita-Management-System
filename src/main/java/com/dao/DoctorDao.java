package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Doctor;

public class DoctorDao {
private Connection conn = null;
public DoctorDao(Connection conn)
{
	this.conn = conn;
}
public boolean registerDoctor(Doctor d)
{
	boolean f = false;
	try {
		PreparedStatement ps = conn.prepareStatement("insert into doctor values(?,?,?,?,?,?,?)");
		
		
		String date = d.getDob();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	    Date dUtil = sdf.parse(date);
	    long ms = dUtil.getTime();
	    java.sql.Date sDate  = new java.sql.Date(ms);
		
		ps.setString(1,d.getFullName());
		ps.setDate(2,sDate);
		ps.setString(3,d.getQualification());
		ps.setString(4,d.getSpecialist());
		ps.setString(5,d.getEmail());
		ps.setString(6,d.getMobNo());
		ps.setString(7,d.getPass());
		int res = ps.executeUpdate();
		if(res==1)
		{
			f=true;
			
		}
		
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	
	return f;
}


public List<Doctor> getAllDoctor()
{
	List <Doctor>  list = new ArrayList<Doctor>();
	Doctor d =null;
	try {
		PreparedStatement ps = conn.prepareStatement("select * from doctor ");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			d = new Doctor();
			d.setFullName(rs.getString(1));
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		Date date = rs.getDate(2);
		String str = sdf.format(date);
		
		d.setDob(str);
		d.setQualification(rs.getString(3));
		d.setSpecialist(rs.getString(4));
		d.setEmail(rs.getString(5));
		d.setMobNo(rs.getString(6));
		d.setPass(rs.getString(7));
		list.add(d);
		}
		
		
	}
	catch(Exception ex)
	{
		
	}
	return list;
}



public Doctor getDoctorByName(String name)
{
	
	Doctor d =null;
	try {
		PreparedStatement ps = conn.prepareStatement("select * from doctor where fullname=?");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			d = new Doctor();
			d.setFullName(rs.getString(1));
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		Date date = rs.getDate(2);
		String str = sdf.format(date);
		
		d.setDob(str);
		d.setQualification(rs.getString(3));
		d.setSpecialist(rs.getString(4));
		d.setEmail(rs.getString(5));
		d.setMobNo(rs.getString(6));
		d.setPass(rs.getString(7));
		
		}
		
		
	}
	catch(Exception ex)
	{
		
	}
	return d;
}

public boolean updateDoctor(Doctor d)
{
	boolean f = false;
	try {
		PreparedStatement ps = conn.prepareStatement("update  doctor  set FULLNAME=?,DOB=?,QUALIFICATION=?,SPECIALIST=?,EMAIL=?,MOBNO=?,PASS=? where FULLNAME=?");
		
	
		String date = d.getDob();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	    Date dUtil = sdf.parse(date);
	    long ms = dUtil.getTime();
	    java.sql.Date sDate  = new java.sql.Date(ms);
		
		ps.setString(1,d.getFullName());
		ps.setDate(2,sDate);
		ps.setString(3,d.getQualification());
		ps.setString(4,d.getSpecialist());
		ps.setString(5,d.getEmail());
		ps.setString(6,d.getMobNo());
		ps.setString(7,d.getPass());
		ps.setString(8,d.getFullName());
		int res = ps.executeUpdate();
		if(res==1)
		{
			
			f=true;
			
		}
		
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	
	return f;
}


public boolean deletDoctor(String Name)
{
	boolean f= false;
	try {
		PreparedStatement ps = conn.prepareStatement("delete from doctor where fullname=?");
		
		ps.setString(1, Name);
		int i = ps.executeUpdate();
		if(i==1)
		{
			f=true;
		}
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return f;
}
public Doctor login(String email, String pass)
{
	Doctor d = null;
	try {
		PreparedStatement ps = conn.prepareStatement("select*  from doctor where email=? and pass=?");
		ps.setString(1, email);
		ps.setString(2, pass);		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			d = new Doctor();
			
			Date sqlDate=rs.getDate(2);
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyy");
			String str = sdf.format(sqlDate);
		 
			
			
			
			d.setFullName(rs.getString(1));
			d.setDob(str);
			d.setQualification(rs.getString(3));
			d.setSpecialist(rs.getString(4));
			d.setEmail(rs.getString(5));
			d.setMobNo(rs.getString(6));
			d.setPass(rs.getString(7));
			
			
			
			
		}

	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return d;
}
public int countDoctor()
{
	int i=0;
	try {
		PreparedStatement ps = conn.prepareStatement("select * from doctor");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			i++;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return i;
}

public int countAppointnment()
{
	int i=0;
	try {
		PreparedStatement ps = conn.prepareStatement("select * from APPOINTMENT");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			i++;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return i;
}
public int countuser()
{
	int i=0;
	try {
		PreparedStatement ps = conn.prepareStatement("select * from USER_DTLS");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			i++;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return i;
}

public int countSpecialist()
{
	int i=0;
	try {
		PreparedStatement ps = conn.prepareStatement("select * from SPECALIST1");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			i++;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return i;
}




}
