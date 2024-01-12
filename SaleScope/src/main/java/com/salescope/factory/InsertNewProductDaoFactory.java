package com.salescope.factory;

import com.salescope.dao.InsertNewProductDao;
import com.salescope.dao.InsertNewProductDaoImpl;

public class InsertNewProductDaoFactory {
	private static InsertNewProductDao insertNewProductDao = null;
	static {
		insertNewProductDao = new InsertNewProductDaoImpl();
	}
	public static InsertNewProductDao getInsertNewProductDaoObject() {
		return insertNewProductDao;
	}
}
