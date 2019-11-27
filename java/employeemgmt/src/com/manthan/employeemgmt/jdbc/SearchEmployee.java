package com.manthan.employeemgmt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SearchEmployee {

	public static void main(String[] args) {
		Connection con=null;
		//Statement st=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id");
		int emp_id=sc.nextInt();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/elf_employee_db";
			con=DriverManager.getConnection(url,"root","root");
			
			String query="select * from employee_info where emp_id=?";
			psmt=con.prepareStatement(query);
			psmt.setInt(1,emp_id);
			
			rs=psmt.executeQuery();
			
			
			
			if(rs.next())
			{
				System.out.println(" found");
				System.out.println("id="+rs.getInt("emp_id") );
				System.out.println("name"+rs.getString("emp_name"));
				System.out.println("designation"+rs.getString("designation"));
				System.out.println("salary"+rs.getDouble("salary"));
				System.out.println("mobile"+rs.getLong("mobile"));
				System.out.println("age"+rs.getInt("age"));
			}//if
			
			else
			{
				System.out.println("not found");
			}
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

}//class
