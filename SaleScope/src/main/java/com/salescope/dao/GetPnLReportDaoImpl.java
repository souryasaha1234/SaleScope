package com.salescope.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.salescope.bean.PnLStruct;
import com.salescope.factory.ConnectionFactory;

public class GetPnLReportDaoImpl implements GetPnLReportDao {

	@Override
	public PnLStruct getPLReport(String uname, String pdt) {
		PnLStruct pls = null;
		Connection con = null;
		Statement st = null;
		Statement st1 = null;
		Statement st2 = null;
		Statement st3 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		String query1 = null, query2 = null, query3 = null, query4 = null;
		
		try {
			con = ConnectionFactory.getUserDBConnectionObject(uname);

			if(con != null) {
				st = con.createStatement();
				st1 = con.createStatement();
				st2 = con.createStatement();
				st3 = con.createStatement();
			}
			
			if (st != null) { 

				String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				String prevyr = LocalDate.now().plusYears(-1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				String prevmon = LocalDate.now().plusMonths(-1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		        
				if(pdt.equalsIgnoreCase("ALL")) { // start of if block
					query1 = "SELECT * FROM PRODUCTS";
					System.out.println(query1);
					rs = st.executeQuery(query1);
					int daily = 0;
					int monthly = 0;
					int yearly = 0;
					
					while (rs.next() != false) {
						String pdt_name = rs.getString("PDT_ID")+"_"+rs.getString("PDT_NAME");
						
						//calculate yearly
						//SELECT * FROM PDT3867 WHERE (PURCHASEDATE BETWEEN '2023-12-04' AND '2024-01-31') OR (SELLDATE BETWEEN '2023-12-04' AND '2024-01-31')
						query2 = "SELECT * FROM PDT_"+pdt_name+" WHERE (PURCHASEDATE BETWEEN '"+prevyr+"' AND '"+today+"') OR (SELLDATE BETWEEN '"+prevyr+"' AND '"+today+"')";
						System.out.println(query2);
						if(st1 != null)
							rs1 = st1.executeQuery(query2);
						while (rs1.next() != false) {
							yearly += Integer.parseInt(rs1.getString("NETPROFIT"));
						}

						//calculate monthly
						//SELECT * FROM PDT3867 WHERE (PURCHASEDATE BETWEEN '2023-12-04' AND '2024-01-31') OR (SELLDATE BETWEEN '2023-12-04' AND '2024-01-31')
						query3 = "SELECT * FROM PDT_"+pdt_name+" WHERE (PURCHASEDATE BETWEEN '"+prevmon+"' AND '"+today+"') OR (SELLDATE BETWEEN '"+prevmon+"' AND '"+today+"')";
						System.out.println(query3);
						if(st2 != null)
							rs2 = st2.executeQuery(query3);
						while (rs2.next() != false) {
							monthly += Integer.parseInt(rs2.getString("NETPROFIT"));
						}
						
						//calculate daily
						//SELECT * FROM PDT3867 WHERE (PURCHASEDATE BETWEEN '2023-12-04' AND '2024-01-31') OR (SELLDATE BETWEEN '2023-12-04' AND '2024-01-31')
						query4 = "SELECT * FROM PDT_"+pdt_name+" WHERE (PURCHASEDATE BETWEEN '"+today+"' AND '"+today+"') OR (SELLDATE BETWEEN '"+today+"' AND '"+today+"')";
						System.out.println(query4);
						if(st3 != null)
							rs3 = st3.executeQuery(query4);
						while (rs3.next() != false) {
							daily += Integer.parseInt(rs3.getString("NETPROFIT"));
						}
					}
					pls = new PnLStruct();
					System.out.println(daily);
					System.out.println(monthly);
					System.out.println(yearly);
					pls.setDaily(Integer.toString(daily));
					pls.setMonthly(Integer.toString(monthly));
					pls.setYearly(Integer.toString(yearly));
					pls.setPdtName(pdt);
				}
				else {
					int daily = 0;
					int monthly = 0;
					int yearly = 0;					
					
					//calculate yearly
					//SELECT * FROM PDT3867 WHERE (PURCHASEDATE BETWEEN '2023-12-04' AND '2024-01-31') OR (SELLDATE BETWEEN '2023-12-04' AND '2024-01-31')
					query2 = "SELECT * FROM PDT_"+pdt+" WHERE (PURCHASEDATE BETWEEN '"+prevyr+"' AND '"+today+"') OR (SELLDATE BETWEEN '"+prevyr+"' AND '"+today+"')";
					System.out.println(query2);
					if(st1 != null)
						rs1 = st1.executeQuery(query2);
					while (rs1.next() != false) {
						yearly += Integer.parseInt(rs1.getString("NETPROFIT"));
					}

					//calculate monthly
					//SELECT * FROM PDT3867 WHERE (PURCHASEDATE BETWEEN '2023-12-04' AND '2024-01-31') OR (SELLDATE BETWEEN '2023-12-04' AND '2024-01-31')
					query3 = "SELECT * FROM PDT_"+pdt+" WHERE (PURCHASEDATE BETWEEN '"+prevmon+"' AND '"+today+"') OR (SELLDATE BETWEEN '"+prevmon+"' AND '"+today+"')";
					System.out.println(query3);
					if(st2 != null)
						rs2 = st2.executeQuery(query3);
					while (rs2.next() != false) {
						monthly += Integer.parseInt(rs2.getString("NETPROFIT"));
					}
					
					//calculate daily
					//SELECT * FROM PDT3867 WHERE (PURCHASEDATE BETWEEN '2023-12-04' AND '2024-01-31') OR (SELLDATE BETWEEN '2023-12-04' AND '2024-01-31')
					query4 = "SELECT * FROM PDT_"+pdt+" WHERE (PURCHASEDATE BETWEEN '"+today+"' AND '"+today+"') OR (SELLDATE BETWEEN '"+today+"' AND '"+today+"')";
					System.out.println(query4);
					if(st3 != null)
						rs3 = st3.executeQuery(query4);
					while (rs3.next() != false) {
						daily += Integer.parseInt(rs3.getString("NETPROFIT"));
					}
					pls = new PnLStruct();

					System.out.println(daily);
					System.out.println(monthly);
					System.out.println(yearly);
					
					pls.setDaily(Integer.toString(daily));
					pls.setMonthly(Integer.toString(monthly));
					pls.setYearly(Integer.toString(yearly));
					pls.setPdtName(pdt);
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
				if(st2 != null)
					st2.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st3 != null)
					st3.close();
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
				if(rs2 != null)
					rs2.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(rs3 != null)
					rs3.close();
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
		return pls;
	}

}
