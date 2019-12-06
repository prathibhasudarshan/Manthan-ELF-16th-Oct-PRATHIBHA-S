package com.manthan.javaclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class ModifyItem {

	public void update() {
		
		Connection con=null;
		PreparedStatement psmt=null;
		int rs=0;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the item_code");
		int  item_code=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the food item to be modified");
		String food_name =sc.next();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String dburl="jdbc:mysql://localhost:3306/Hotel";
			con=DriverManager.getConnection(dburl,"root","root");
			
			String query="update bill set food_name =? where item_code=?";
			psmt=con.prepareStatement(query);
			psmt.setString(1,food_name);
			psmt.setInt(2,item_code );
			rs=psmt.executeUpdate();
			
			if(rs>0)
			{
				System.out.println("FOOD ITEM FOR THE SPECIFIC ITEM IS MODIFIED");
				
			}//if
			
			else
			{
				System.out.println("FOOD ITEM CANNOT BE MODIFIED AS THE CODE IS NOT FOUND");
			}
		}//try
		catch(Exception e)
		{
			e.printStackTrace();
		}//catch
		
		finally
		{
			try {
				
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
