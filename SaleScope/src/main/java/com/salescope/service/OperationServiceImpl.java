package com.salescope.service;

import com.salescope.bean.Product;
import com.salescope.bean.ProductList;
import com.salescope.bean.Report;
import com.salescope.dao.GetProductListDao;
import com.salescope.dao.GetReportDao;
import com.salescope.dao.InsertNewProductDao;
import com.salescope.dao.InsertProductSalesDao;
import com.salescope.factory.GetProductListDaoFactory;
import com.salescope.factory.GetReportDaoFactory;
import com.salescope.factory.InsertNewProductDaoFactory;
import com.salescope.factory.InsertProductSalesDaoFactory;

public class OperationServiceImpl implements OperationService {

	@Override
	public String InsertNewProductService(String pdtname, String uname) {
		InsertNewProductDao inpdao = InsertNewProductDaoFactory.getInsertNewProductDaoObject();
		String status = inpdao.insertNewProduct(pdtname, uname);
		return status;
	}
	@Override
	public ProductList[] getProductListService(String uname) {
		GetProductListDao gplo = GetProductListDaoFactory.getProductListDaoObject();
		ProductList[] pdtlt = gplo.getProductList(uname);
		return pdtlt;
	}
	@Override
	public String InsertProductSalesService(Product product, String uname) {
		InsertProductSalesDao inpsd = InsertProductSalesDaoFactory.getInsertProductSalesDaoObject();
		String status = inpsd.insertProductSales(product, uname);
		return status;
	}
	@Override
	public Report[] getSalesReportService(String uname, String pdt) {
		GetReportDao gprd = GetReportDaoFactory.getReportDaoObject();
		Report[] reportArr = gprd.getReport(uname, pdt);
		return reportArr;
	}
}
