package com.manthan.Musicplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SearchNewSongs {
	public void allsongs() {
		Connection con=null;
		
		Statement psmt=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/MusicPlayer";
			con=DriverManager.getConnection(url,"root","root");
			
			String query="select * from MusicFiles";
			psmt=con.createStatement();
			rs=psmt.executeQuery(query);
			
			
			
			while(rs.next())
			{
				System.out.println(" songs found ");
				System.out.println("id=               "+rs.getInt("Song_ID") );
				System.out.println("songtitle         "+rs.getString("Song_Title"));
				System.out.println("artistname        "+rs.getString("Artist_Name"));
				System.out.println("albumname         "+rs.getString("Album_Name"));
				System.out.println("songlocation      "+rs.getString("Song_Location"));
				System.out.println("description       "+rs.getString("Description"));
				System.out.println("------------------------------------------");
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
