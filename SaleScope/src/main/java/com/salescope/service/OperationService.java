package com.salescope.service;

import com.salescope.bean.Sales;

public interface OperationService {
	public String InsertNewProductService(String pdtname, String uname);
	public String InsertProductSalesService(Sales sales);
}
