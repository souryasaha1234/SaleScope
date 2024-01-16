package com.salescope.dao;

import com.salescope.bean.Product;

public interface UpdateSalesDao {
	public String updateSales(Product product, String salesId, String uname);
}
