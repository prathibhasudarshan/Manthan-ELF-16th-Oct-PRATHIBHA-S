package com.manthan.Musicplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteSong {
	public  void delete() {
		Connection con=null;

		PreparedStatement psmt=null;
		int rs=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id");
		int songid=sc.nextInt();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			String url="jdbc:mysql://localhost:3306/MusicPlayer";
			con=DriverManager.getConnection(url,"root","root");

			String query="delete  from MusicFiles where Song_ID=?";
			psmt=con.prepareStatement(query);
			psmt.setInt(1,songid);

			rs=psmt.executeUpdate();



			if(rs>0)
			{
				System.out.println(" deleted");

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
