package com.manthan.Musicplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public  class AddSongNew {
	public void add() {

		Connection con=null;
		PreparedStatement psmt=null;
		Scanner sc=new Scanner(System.in);
		System.out.println(" enter the id" );
		int songid=sc.nextInt();
		sc.nextLine();

		System.out.println(" enter the song title");
		String songtitle=sc.nextLine();

		System.out.println("enter the artist name");
		String artist=sc.next();

		System.out.println("enter the album name");
		String album=sc.next();

		System.out.println("enter the song location");
		String loc=sc.next();

		System.out.println("enter description");
		String desc=sc.next();


		try
		{
			Class.forName("com.mysql.jdbc.Driver");


			String dburl="jdbc:mysql://localhost:3306/MusicPlayer";
			con=DriverManager.getConnection(dburl,"root","root");

			String query="insert into MusicFiles values(?,?,?,?,?,?)";

			psmt=con.prepareStatement(query);
			psmt.setInt(1, songid);
			psmt.setString(2, songtitle);
			psmt.setString(3,artist);
			psmt.setString(4, album);
			psmt.setString(5, loc);
			psmt.setString(6, desc);


			int n=psmt.executeUpdate();
			if(n>0)
			{
				System.out.println("record inserted");
			}
			else
			{
				System.out.println("failed");
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
