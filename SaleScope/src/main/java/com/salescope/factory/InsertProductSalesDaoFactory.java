package com.salescope.factory;

import com.salescope.dao.InsertProductSalesDao;
import com.salescope.dao.InsertProductSalesDaoImpl;

public class InsertProductSalesDaoFactory {
	private static InsertProductSalesDao inpsd = null;
	static {
		inpsd = new InsertProductSalesDaoImpl();
	}
	public static InsertProductSalesDao getInsertProductSalesDaoObject() {
		return inpsd;
	}
}
