package com.salescope.service;

import com.salescope.bean.Product;
import com.salescope.bean.ProductList;
import com.salescope.bean.Report;

public interface OperationService {
	public String InsertNewProductService(String pdtname, String uname);
	public String InsertProductSalesService(Product product, String uname);
	public ProductList[] getProductListService(String uname);
	public Report[] getSalesReportService(String uname, String pdt);
	public String UpdateSalesService(Product product, String salesId, String uname);
	public String DeleteSalesService(String pdtSelect, String salesId, String uname);
}
