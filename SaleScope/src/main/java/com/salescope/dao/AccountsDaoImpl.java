package com.salescope.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.salescope.bean.Accounts;
import com.salescope.factory.ConnectionFactory;

public class AccountsDaoImpl implements AccountsDao {

	@Override
	public String loginDao(Accounts acc) {
		//Resouce declaration
				Connection con = null;
				Statement st = null;
				ResultSet rs = null;
				
				//variable declarations
				
				String status = null, uname = null, uemail = null, upassword = null;
				
				try {
					// Establishing database connection
					con = ConnectionFactory.getConnectionObject();
					
					// creating statement object
					if(con != null)
						st = con.createStatement();
					
					//Getting accounts details
					uname = acc.getUname();
					uemail = "'" + acc.getUemail() + "'";
					upassword = acc.getPass();
					
					// INSERT INTO ACCOUNTS VALUES ('sahasourya@gmail.com', 'sourya1234', '1234sourya');
					//generating the query
					String query = "SELECT * FROM ACCOUNTS WHERE EMAIL = "+uemail+"";
					
					// Execute the query
					if(st != null)
						rs = st.executeQuery(query);
					
					//generating status
					if (rs.next() != false) {
						if (rs.getString("uname").equals(uname) && rs.getString("pass").equals(upassword)) {
							status = "success";
						}
						else
							status = "failure";
					}						
					else
						status = "NotExisted";
					
				} catch (SQLException se) {
					if(se.getErrorCode() == 1)
						System.out.println("Duplicate cannot be inserted to primary key column");			
					if(se.getErrorCode() == 1400)
						System.out.println("Null cannot be inserted to primary key column");
					if(se.getErrorCode() >= 900 && se.getErrorCode()<=999)
						System.out.println("Invalid column name or table name or SQL keywords");			
					if(se.getErrorCode() == 12899)
						System.out.println("Do not insert more than column size data to column");
					System.out.println(se.toString());
					status = "error";
				}
				finally {
					try {
						if(st != null)
							st.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}
				}
				return status;
	}

	@Override
	public String signupDao(Accounts acc) {
		//Resouce declaration
		Connection con = null;
		Statement st = null;
		
		//variable declarations
		
		String status = null, uname = null, uemail = null, upassword = null;
		int count = 0;
		
		try {
			// Establishing database connection
			con = ConnectionFactory.getConnectionObject();
			
			// creating statement object
			if(con != null)
				st = con.createStatement();
			
			//Getting accounts details
			uname = "'" + acc.getUname() + "'";
			uemail = "'" + acc.getUemail() + "'";
			upassword = "'" + acc.getPass() + "'";
			
			// INSERT INTO ACCOUNTS VALUES ('sahasourya@gmail.com', 'sourya1234', '1234sourya');
			//generating the query
			String query = "INSERT INTO ACCOUNTS VALUES ("+uemail+", "+uname+", "+upassword+")";
			
			// Execute the query
			if(st != null)
				count = st.executeUpdate(query);
			
			//generating status
			if (count == 1)
				status = "success";
			else
				status = "failure";
			
		} catch (SQLException se) {
			if(se.getErrorCode() == 1)
				System.out.println("Duplicate cannot be inserted to primary key column");			
			if(se.getErrorCode() == 1400)
				System.out.println("Null cannot be inserted to primary key column");
			if(se.getErrorCode() >= 900 && se.getErrorCode()<=999)
				System.out.println("Invalid column name or table name or SQL keywords");			
			if(se.getErrorCode() == 12899)
				System.out.println("Do not insert more than column size data to column");
			System.out.println(se.toString());
			status = "error";
		}
		finally {
			try {
				if(st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return status;
	}

}
