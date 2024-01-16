package com.salescope.factory;

import com.salescope.dao.DeleteSalesDao;
import com.salescope.dao.DeleteSalesDaoImpl;

public class DeleteSalesDaoFactory {
	private static DeleteSalesDao dsd = null;
	static {
		dsd = new DeleteSalesDaoImpl();
	}
	public static DeleteSalesDao getDeleteSalesDaoObject() {
		return dsd;
	}
}
