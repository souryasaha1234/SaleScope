package com.salescope.dao;

import com.salescope.bean.ProductList;

public interface GetProductListDao {
	public ProductList[] getProductList(String uname);
}
