package com.manthan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.manthan.beanclass.UserBean;



public class UserDAOImpl implements UserDAO {

	@Override
	public UserBean authenticate(String Email, String Password) {
		
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		UserBean userBean=null;

		try {
			//LOAD THE DRIVER
			Class.forName("com.mysql.jdbc.Driver");

			//GET CONNECTION VIA DRIVER
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flipkart", "root", "root");

			//ISSUE SQL QUERY 
			String query = " select * from User_Info where Email =? and Password=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, Email);
			pstmt.setString(2, Password);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				
				userBean=new UserBean();
				userBean.setUser_Id(rs.getInt("User_Id"));
				userBean.setUserName(rs.getString("UserName"));
				userBean.setEmail(rs.getString("Email"));
				userBean.setPassword(rs.getString("Password"));
			}
		} catch (Exception e) {
		}
		finally {
			//CLOSE JDBC OBJECTS
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//end of finally
		return userBean;
		
		
	}

	@Override
	public UserBean search(int  User_Id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserBean userBean=new UserBean();

		

		try {
			//LOAD THE DRIVER
			Class.forName("com.mysql.jdbc.Driver");

			//GET CONNECTION VIA DRIVER
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flipkart", "root", "root");

			//ISSUE SQL QUERY 
			String query = " select * from  User_Info where User_Id =?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, User_Id);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				userBean.setUser_Id(rs.getInt("User_Id"));
				userBean.setUserName(rs.getString("UserName"));
				userBean.setEmail(rs.getString("Email"));
				userBean.setPassword(rs.getString("Password"));

				
			}
		} catch (Exception e) {
		}
		finally {
			//CLOSE JDBC OBJECTS
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//end of finally
		return userBean;
		
	}

	@Override
	public boolean register(UserBean userBean) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		boolean isAdded=false;
		try {

			Class.forName("com.mysql.jdbc.Driver");

			String dburl="jdbc:mysql://localhost:3306/Flipkart";
			conn=DriverManager.getConnection(dburl,"root","root");

			pstmt=conn.prepareStatement("insert into User_Info  values (?,?,?,?)");
			pstmt.setInt(1, userBean.getUser_Id());
			pstmt.setString(2, userBean.getUserName());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setString(4, userBean.getPassword());

			

			int n=pstmt.executeUpdate();

			if(n>0) {
				isAdded=true;
			}


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isAdded;
		
	}

	@Override
	public List<UserBean> history() {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		UserBean userBean=null;
		
		List<UserBean> ls=new ArrayList<UserBean>();
		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipKart", "root", "root");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from User_Info ");
			
			while(rs.next()) {
				
				userBean=new UserBean();
				userBean.setUser_Id(rs.getInt("User_Id"));
				userBean.setUserName(rs.getString("UserName"));
				userBean.setEmail(rs.getString("Email"));
				userBean.setPassword(rs.getString("Password"));
				ls.add(userBean);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}//end of seeAll

	}


