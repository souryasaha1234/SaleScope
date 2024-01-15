package com.salescope.dao;

import com.salescope.bean.Report;

public interface GetReportDao {
	public Report[] getReport(String uname, String pdt);
}
