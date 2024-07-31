package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DBConnect {

	private static  Connection conn;
	
	public static Connection getConn()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-GOPFM6R:1521/xe","system","Sha123#*");
			
		}
		catch(Exception ex)
		{
			
		}
		return conn;
	}
	
}
