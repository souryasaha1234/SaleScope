package com.salescope.service;

import com.salescope.bean.Sales;
import com.salescope.dao.InsertNewProductDao;
import com.salescope.factory.InsertNewProductDaoFactory;

public class OperationServiceImpl implements OperationService {

	@Override
	public String InsertNewProductService(String pdtname, String uname) {
		InsertNewProductDao inpdao = InsertNewProductDaoFactory.getInsertNewProductDaoObject();
		String status = inpdao.insertNewProduct(pdtname, uname);
		return status;
	}

	@Override
	public String InsertProductSalesService(Sales sales) {
		// TODO Auto-generated method stub
		return null;
	}

}
