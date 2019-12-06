package com.manthan.util;

import com.manthan.dao.ProductDAO;
import com.manthan.dao.ProductImp;
import com.manthan.dao.UserDAO;
import com.manthan.dao.UserDAOImpl;

public class ProductMgr {
	private ProductMgr() { //restricting others to make object......

	}
	public static ProductDAO getDaoManager() {
		return new ProductImp();
	}

}
