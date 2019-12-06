package com.manthan.dao;

import java.util.List;

import com.manthan.beanclass.ProductBean;
import com.manthan.beanclass.UserBean;



public interface ProductDAO {
	
	public ProductBean search(int Product_ID);
	
	public List<ProductBean> history();
	
	

}
