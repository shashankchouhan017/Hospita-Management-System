package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDao {
	
	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean userRegister(User u)
	{
		boolean f = false;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement("insert into user_dtls values(?,?,?)");
			ps.setString(1, u.getFullname());
			ps.setString(2,u.getEmail());
			ps.setString(3,u.getPass());
			
			int i =ps.executeUpdate();
			if(i>0)
			{
				f=true;
				System.out.println("Data insert"+u.getPass());
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		
		return f;
	}
	
	
	public User login(String em,String pass)
	{
		System.out.println(em+""+pass);
		User u = null;
		try
		{
			PreparedStatement ps = conn.prepareStatement("select * from user_dtls where email=? and pass=?");
			
			ps.setString(1,em);
			ps.setString(2,pass);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				
				u = new User();
				u.setFullname(rs.getString(1));
				u.setEmail(rs.getString(2));
				u.setPass(rs.getString(3));
				
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return u;
		
	}

	
	
	

}
