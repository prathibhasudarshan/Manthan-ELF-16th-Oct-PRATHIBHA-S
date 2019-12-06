package com.manthan.javaclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class AddItem {
	public void add() {

		Connection con=null;
		PreparedStatement psmt=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the item code");
		int  item_code=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Food name");

		String  food_name=sc.nextLine();

		System.out.println("Enter the price of the item");
		double price=sc.nextDouble();
		try
		{

			String dburl="jdbc:mysql://localhost:3306/Hotel";
			con=DriverManager.getConnection(dburl,"root","root");

			String query="insert into bill values(?,?,?)";

			psmt=con.prepareStatement(query);

			psmt.setInt(1,item_code );

			psmt.setString(2,food_name );

			psmt.setDouble(3, price);

			int n=psmt.executeUpdate();

			if(n>0)
			{
				System.out.println("FOOD ADDED INTO THE LIST");
			}
			else
			{
				System.out.println("FOOD ITEM CANNOT BE ADDED OR ABSENT");
			}
		}//try
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
