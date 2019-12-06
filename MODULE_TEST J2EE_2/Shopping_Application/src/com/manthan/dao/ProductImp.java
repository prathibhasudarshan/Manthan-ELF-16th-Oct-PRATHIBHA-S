package com.manthan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.manthan.beanclass.ProductBean;
import com.manthan.beanclass.UserBean;

public class ProductImp implements ProductDAO {

	@Override
	public ProductBean search(int Product_ID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductBean productBean=new ProductBean();
	

		

		try {
			//LOAD THE DRIVER
			Class.forName("com.mysql.jdbc.Driver");

			//GET CONNECTION VIA DRIVER
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Flipkart", "root", "root");

			//ISSUE SQL QUERY 
			String query = " select * from Product_Info   where  Product_ID =?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,Product_ID );

			rs = pstmt.executeQuery();

			if(rs.next()) {
				
				productBean.setProduct_ID(rs.getInt("Product_ID"));
				productBean.setDescription(rs.getString("Description"));
				productBean.setProductName(rs.getString("ProductName"));
				

				
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
		return productBean;
		
		
	}

	@Override
	public List<ProductBean> history() {
		// TODO Auto-generated method stub
		return null;
	}

}
