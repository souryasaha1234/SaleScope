package com.salescope.factory;

import com.salescope.dao.UpdateSalesDao;
import com.salescope.dao.UpdateSalesDaoImpl;

public class UpdateSalesDaoFactory {
	private static UpdateSalesDao updtsd = null;
	static {
		updtsd = new UpdateSalesDaoImpl();
	}
	public static UpdateSalesDao getUpdateSalesDaoObject() {
		return updtsd;
	}
}
