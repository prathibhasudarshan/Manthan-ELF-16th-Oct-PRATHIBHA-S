package com.manthan.javaclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class BillingOfItems {
	public void bill()
	{
		Connection con=null;
		Statement psmt=null;
		ResultSet rs=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/Hotel";
			con=DriverManager.getConnection(dburl,"root","root");

			String query="select sum(price) as total from bill";

			psmt=con.createStatement();
			rs=psmt.executeQuery(query);

			while(rs.next())
			{

				System.out.println("TOTAL BILL     "+rs.getInt("total"));

			}//while

		}//try
		catch(Exception e)
		{
			e.printStackTrace();
		}//catch

		finally
		{
			try {
				if(rs!=null)
				{
					rs.close();
				}
				if(psmt!=null)
				{
					psmt.close();
				}
				if(con!=null)
				{
					con.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}




