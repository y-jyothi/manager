package com.mindtree.ManagerTest.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ManagerUtility {
	
		public static Connection connect()
		{
			Connection con=null;
			String URL="jdbc:mysql://localhost:3306/Manager";
			String user="root";
			String password="Welcome123";
			try
			{
				//Class.forName("com.mysql.jdbc.Driver").newInstance();
				con=DriverManager.getConnection(URL, user, password);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return con;
			
		}

	}


