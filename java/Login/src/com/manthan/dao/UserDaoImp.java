package com.manthan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.manthan.bean.userinfobean;


public class UserDaoImp implements UserDao  {

	@Override
	public userinfobean authenticate(String username, String pw) {
		
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		
		userinfobean userinfobean =null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
			String query="select * from login where username=? and pw=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,username);
			pstmt.setString(2, pw);

			rs=pstmt.executeQuery();
			if (rs.next()) {

				
				userinfobean=new userinfobean();
				userinfobean.setUsername(rs.getString("username"));
				userinfobean.setPw(rs.getString("pw"));
				userinfobean.setAge(rs.getInt("age"));
				userinfobean.setGender(rs.getString("gender"));
				
				
				

			}


		}

		catch (Exception e) {
			e.printStackTrace();
		} // catch

		finally {
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
		return userinfobean;

	}

}
