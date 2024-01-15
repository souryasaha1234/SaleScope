package com.salescope.factory;

import com.salescope.dao.GetReportDao;
import com.salescope.dao.GetReportDaoImpl;

public class GetReportDaoFactory {
	private static GetReportDao grpd = null;
	static {
		grpd = new GetReportDaoImpl();
	}
	public static GetReportDao getReportDaoObject() {
		return grpd;
	}
}
