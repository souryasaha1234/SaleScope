package com.salescope.service;

import com.salescope.bean.PnLStruct;
import com.salescope.bean.Product;
import com.salescope.bean.ProductList;
import com.salescope.bean.Report;
import com.salescope.dao.DeleteSalesDao;
import com.salescope.dao.GetPnLReportDao;
import com.salescope.dao.GetProductListDao;
import com.salescope.dao.GetReportDao;
import com.salescope.dao.InsertNewProductDao;
import com.salescope.dao.InsertProductSalesDao;
import com.salescope.dao.UpdateSalesDao;
import com.salescope.factory.DeleteSalesDaoFactory;
import com.salescope.factory.GetPnLReportDaoFactory;
import com.salescope.factory.GetProductListDaoFactory;
import com.salescope.factory.GetReportDaoFactory;
import com.salescope.factory.InsertNewProductDaoFactory;
import com.salescope.factory.InsertProductSalesDaoFactory;
import com.salescope.factory.UpdateSalesDaoFactory;

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
	public PnLStruct getPLReportService(String uname, String pdt) {
		GetPnLReportDao gplrd = GetPnLReportDaoFactory.getPnLRepoerDaoObject();
		PnLStruct pls = gplrd.getPLReport(uname, pdt);
		return pls;
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
	@Override
	public String UpdateSalesService(Product product, String salesId, String uname) {
		UpdateSalesDao updtsd = UpdateSalesDaoFactory.getUpdateSalesDaoObject();
		String status = updtsd.updateSales(product, salesId, uname); 
		return status;
	}
	@Override
	public String DeleteSalesService(String pdtSelect, String salesId, String uname) {
		DeleteSalesDao dsd = DeleteSalesDaoFactory.getDeleteSalesDaoObject();
		String status = dsd.deleteSales(pdtSelect, salesId, uname);
		return status;
	}
}
