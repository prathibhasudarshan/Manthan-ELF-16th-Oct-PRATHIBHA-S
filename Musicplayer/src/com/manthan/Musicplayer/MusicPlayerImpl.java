package com.manthan.Musicplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class MusicPlayerImpl implements MusicPlayerDao {

	@Override
	public MusicPlayerInfoBean searchsongs(int songid) {
		Connection con=null;

		PreparedStatement psmt=null;
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);
		
		MusicPlayerInfoBean infoBean1=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			String url="jdbc:mysql://localhost:3306/MusicPlayer";
			con=DriverManager.getConnection(url,"root","root");

			String query="select * from MusicFiles where Song_ID=?";
			psmt=con.prepareStatement(query);
			psmt.setInt(1,songid);

			rs=psmt.executeQuery();



			if(rs.next())
			{
				System.out.println(" songs found ");
				System.out.println("id=               "+rs.getInt("Song_ID") );
				System.out.println("songtitle         "+rs.getString("Song_Title"));
				System.out.println("artistname        "+rs.getString("Artist_Name"));
				System.out.println("albumname         "+rs.getString("Album_Name"));
				System.out.println("songlocation      "+rs.getString("Song_Location"));
				System.out.println("description       "+rs.getString("Description"));


				MusicPlayerInfoBean infoBean=new MusicPlayerInfoBean();
				infoBean.setSongid(rs.getInt("Song_ID"));
				infoBean.setAlbumname(rs.getString("Song_Title"));
				infoBean.setArtistname(rs.getString("Artist_Name"));




			}//if

			else
			{
				System.out.println(" songs not found");
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



		return null;


	}

	@Override
	public boolean addsongs(MusicPlayerInfoBean infoBean) {

		MusicPlayerInfoBean infoBean1=null;


		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isadded = false;



		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MusicPlayer", "root", "root");


			String query = "insert into  MusicFiles values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, infoBean1.getSongid());
			pstmt.setString(2, infoBean1.getSongtitle());
			pstmt.setString(3, infoBean1.getSongtitle());
			pstmt.setString(4, infoBean1.getAlbumname());
			pstmt.setString(5, infoBean1.getSongLocation());
			pstmt.setString(6, infoBean1.getDescription());


			// rs=pstmt.executeQuery();
			int n = pstmt.executeUpdate();

			if (n > 0) {
				isadded = true;
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return isadded;
	}

	@Override
	public boolean Update(int songid, String songtitle) {
		Connection con=null;
		PreparedStatement psmt=null;
		int rs=0;
		boolean isupdate = false;
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



		return isupdate;
	}







	@Override
	public boolean delete(int songid) {


		Connection con=null;

		PreparedStatement psmt=null;
		int rs=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id");
		int Song_ID=sc.nextInt();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			String url="jdbc:mysql://localhost:3306/MusicPlayer";
			con=DriverManager.getConnection(url,"root","root");

			String query="delete  from MusicFiles where Song_ID=?";
			psmt=con.prepareStatement(query);
			psmt.setInt(1,Song_ID);

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



		return false;
	}

}
