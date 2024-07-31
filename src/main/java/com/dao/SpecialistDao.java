package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Specalist;

public class SpecialistDao {
	private Connection conn;

	public SpecialistDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addSpecialist(String spec)
	{
		boolean f = false;
		
		try
		{
			PreparedStatement ps = conn.prepareStatement("insert into SPECALIST1 values(?)");
			ps.setString(1,spec);
			
			int i = ps.executeUpdate();
			if(i==1)
				{
				f=true;
				}
			;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
		return f;
	}
	
	public List <Specalist> getAllSpecialist()
	{
		
		List <Specalist> list = new ArrayList<Specalist>();
		Specalist s = null;
		try {
			
			PreparedStatement ps = conn.prepareStatement("select * from SPECALIST1");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				s = new Specalist();
				s.setSpecalistName(rs.getString(1));
				System.out.println(rs.getString(1));
				list.add(s);
				System.out.println(rs.getString(1));
				
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
		
	}
	
	
}
