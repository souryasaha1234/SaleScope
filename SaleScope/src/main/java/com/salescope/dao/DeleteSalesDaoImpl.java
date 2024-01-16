package com.salescope.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.salescope.factory.ConnectionFactory;

public class DeleteSalesDaoImpl implements DeleteSalesDao {

	@Override
	public String deleteSales(String pdtSelect, String salesId, String uname) {
		Connection con = null;
		Statement st = null;
		String status = "";
		String query = "";
		
		try {
			con = ConnectionFactory.getUserDBConnectionObject(uname);
			if(con != null)
				st = con.createStatement();
			if(st != null) {
				query = "DELETE FROM PDT_"+pdtSelect+" WHERE SALESID = '"+salesId+"'";
				System.out.println(query);
				int count = st.executeUpdate(query);
				
				if(count == 1)
					status = "success";
				else
					status = "failed";
			}
		} catch (SQLException se) {
			if(se.getErrorCode() == 1)
				System.out.println("Duplicate cannot be inserted to primary key column");			
			if(se.getErrorCode() == 1400)
				System.out.println("Null cannot be inserted to primary key column");
			if(se.getErrorCode() >= 900 && se.getErrorCode()<=999)
				System.out.println("Invalid column name or table name or SQL keywords");			
			if(se.getErrorCode() == 12899)
				System.out.println("Do not insert more than column size data to column");
			System.out.println(se);
			se.printStackTrace();
			status = "error";
		} finally {
			try {
				if(st != null)
					st.close();
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
		return status;
	}

}
