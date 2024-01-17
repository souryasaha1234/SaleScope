package com.salescope.factory;

import com.salescope.dao.GetPnLReportDaoImpl;
import com.salescope.dao.GetPnLReportDao;

public class GetPnLReportDaoFactory {
	private static GetPnLReportDao gplr = null;
	static {
		gplr = new GetPnLReportDaoImpl();
	}
	public static GetPnLReportDao getPnLRepoerDaoObject() {
		return gplr;
	}
}
