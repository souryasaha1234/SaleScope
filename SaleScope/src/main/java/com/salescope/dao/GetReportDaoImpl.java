package com.salescope.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.salescope.bean.Report;
import com.salescope.factory.ConnectionFactory;

public class GetReportDaoImpl implements GetReportDao {

	@Override
	public Report[] getReport(String uname, String pdt) {
		Report[] tempSalesReport = new Report[200];
		Report[] salesReport = null;
		Report report = null;
		Connection con = null;
		Statement st = null;
		Statement st1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String query1 = null, query2 = null;
		
		try {
			con = ConnectionFactory.getUserDBConnectionObject(uname);

			if(con != null) {
				st = con.createStatement();
				st1 = con.createStatement();
			}
			
//				**********Implement later*************
			if (st != null) { 
				if(pdt.equalsIgnoreCase("ALL")) { // start of if block
					query1 = "SELECT * FROM PRODUCTS";
					rs1 = st.executeQuery(query1);
					
					int i=0;
					while (rs1.next() != false) {
						System.out.println("Inside if block");
						String pdt_name = rs1.getString("PDT_ID")+"_"+rs1.getString("PDT_NAME");

						
						query2 = "SELECT * FROM PDT_"+pdt_name;
						rs = st1.executeQuery(query2);
						
						while (rs.next() != false) {
							report = new Report();
							report.setPdtSelect(pdt_name);
							report.setCostPrice(rs.getString("COSTPRICE"));
							report.setSalesId(rs.getString("SALESID"));
							report.setSellPrice(rs.getString("SELLPRICE"));
							report.setPurchaseQty(rs.getString("PURCHASEQTY"));
							report.setSellQty(rs.getString("SELLQTY"));
							
							report.setTotalPurchase(rs.getString("TOTALPURCHASE"));
							report.setTotalSell(rs.getString("TOTALSale"));
							report.setNetProfit(rs.getString("NETPROFIT"));
							
							report.setPurchaseDate(rs.getString("PURCHASEDATE"));
							report.setSellDate(rs.getString("SELLDATE"));
		
							tempSalesReport[i] = report;
							i++;
						}
					}
					salesReport = new Report[i];
					for (int j = 0; j < i; j++) {
						salesReport[j] = tempSalesReport[j];
					}
				}
				else {
					query2 = "SELECT * FROM PDT_"+pdt;
					rs = st.executeQuery(query2);
					
					int i=0;
					while (rs.next() != false) {
						report = new Report();
						report.setPdtSelect(pdt);
						report.setCostPrice(rs.getString("COSTPRICE"));
						report.setSalesId(rs.getString("SALESID"));
						report.setSellPrice(rs.getString("SELLPRICE"));
						report.setPurchaseQty(rs.getString("PURCHASEQTY"));
						report.setSellQty(rs.getString("SELLQTY"));
						
						report.setTotalPurchase(rs.getString("TOTALPURCHASE"));
						report.setTotalSell(rs.getString("TOTALSale"));
						report.setNetProfit(rs.getString("NETPROFIT"));
						
						report.setPurchaseDate(rs.getString("PURCHASEDATE"));
						report.setSellDate(rs.getString("SELLDATE"));
	
						tempSalesReport[i] = report;
						i++;
					}
					salesReport = new Report[i];
					for (int j = 0; j < i; j++) {
						salesReport[j] = tempSalesReport[j];
					}
				}// end else
			}// end st check
		}catch (SQLException se) {
			if(se.getErrorCode() == 1)
				System.out.println("Duplicate cannot be inserted to primary key column");			
			if(se.getErrorCode() == 1400)
				System.out.println("Null cannot be inserted to primary key column");
			if(se.getErrorCode() >= 900 && se.getErrorCode()<=999)
				System.out.println("Invalid column name or table name or SQL keywords");			
			if(se.getErrorCode() == 12899)
				System.out.println("Do not insert more than column size data to column");
			System.out.println("Some error occoured to get Sales Report");
			System.out.println(se);
			se.printStackTrace();
		}
		finally {
			try {
				if(st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st1 != null)
					st1.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(rs1 != null)
					rs1.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return salesReport;
	}

}
