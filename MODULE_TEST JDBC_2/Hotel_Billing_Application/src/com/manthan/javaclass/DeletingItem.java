package com.manthan.javaclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class DeletingItem {
	public  void delete() {

		Connection con=null;
		PreparedStatement psmt=null;
		int rs=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the item_code");
		int  item_code=sc.nextInt();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/Hotel";
			con=DriverManager.getConnection(dburl,"root","root");

			String query="delete  from bill where item_code=?";
			psmt=con.prepareStatement(query);
			psmt.setInt(1,item_code );
			rs=psmt.executeUpdate();

			if(rs>0)
			{
				System.out.println("FOOD ITEM DELETED FROM LIST");

			}//if

			else
			{
				System.out.println("FOOD CODE CANNOT BE FOUND SO,CANT BE DELETED ");
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
