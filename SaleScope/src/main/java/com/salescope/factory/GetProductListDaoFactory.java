package com.salescope.factory;

import com.salescope.dao.GetProductListDao;
import com.salescope.dao.GetProductListDaoImpl;

public class GetProductListDaoFactory {
	private static GetProductListDao getProductListDao = null;
	static {
		getProductListDao = new GetProductListDaoImpl();
	}
	public static GetProductListDao getProductListDaoObject() {
		return getProductListDao;
	}
}
