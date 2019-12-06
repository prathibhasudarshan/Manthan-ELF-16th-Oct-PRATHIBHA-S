package com.manthan.javaclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DisplayingItems {
	public void showallitems() {
		
		Connection con=null;
		Statement psmt=null;
		ResultSet rs=null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/Hotel";
			con=DriverManager.getConnection(dburl,"root","root");
			
			String query="select * from bill";
			psmt=con.createStatement();
			rs=psmt.executeQuery(query);
			
			
			while(rs.next())
			{
				System.out.println("ITEMS THAT ARE ORDERED AND DISPLAYED");
				System.out.println("ITEMCODE     "+rs.getInt("item_code"));
				System.out.println("FOOD_ITEM    "+rs.getString("food_name"));
				System.out.println("PRICE        "+rs.getDouble("price"));
				System.out.println("-------------------");
				System.out.println("\n");
				
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
		
	}//main
	
}
