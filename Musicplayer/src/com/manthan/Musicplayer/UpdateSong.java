package com.manthan.Musicplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateSong {
	public void update() {
		Connection con=null;
		PreparedStatement psmt=null;
		int rs=0;
		Scanner sc=new Scanner(System.in);
		System.out.println(" enter the id" );
		int Song_ID=sc.nextInt();
		sc.nextLine();
		
		System.out.println(" enter the song title");
		String Song_Title =sc.next();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			
			String dburl="jdbc:mysql://localhost:3306/MusicPlayer";
			con=DriverManager.getConnection(dburl,"root","root");
			
			String query="update  MusicFiles set Song_Title =? where Song_ID=?";
			psmt=con.prepareStatement(query);
			psmt.setString(1,Song_Title);
			psmt.setInt(2,Song_ID );
			
			rs=psmt.executeUpdate();
			
			
			
			if(rs>0)
			{
				System.out.println("RECORDS ARE UPDATED");
				
			}//if
			
			else
			{
				System.out.println(" Record not found");
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
