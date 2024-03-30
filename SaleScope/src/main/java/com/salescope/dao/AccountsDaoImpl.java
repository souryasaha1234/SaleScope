package com.salescope.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.salescope.bean.Accounts;
import com.salescope.factory.ConnectionFactory;

public class AccountsDaoImpl implements AccountsDao {

	@Override
	public String loginDao(Accounts acc) {
		//Resource declaration
				Connection con = null;
				PreparedStatement st = null;
				ResultSet rs = null;
				
				//variable declarations
				
				String status = null, uname = null, uemail = null, upassword = null;
				
				try {
					// Establishing database connection
					con = ConnectionFactory.getConnectionObject();
					
					
					//Getting accounts details
					uname = acc.getUname();
					uemail = acc.getUemail();
					upassword = acc.getPass();
					
					// SELECT * FROM ACCOUNTS WHERE EMAIL = "sahasourya@gmail.com";
					//generating the query
					String query = "SELECT * FROM ACCOUNTS WHERE EMAIL = ?";
					
					// creating statement object
					if(con != null) {
						st = con.prepareStatement(query);
						st.setString(1, uemail);
					}

					// Execute the query
					if(st != null)
						rs = st.executeQuery();
					System.out.println(st);
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
					se.printStackTrace();
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
		//Resource declaration
		Connection con = null;
		Statement st = null;
		Statement st1 = null;
		ResultSet rs = null;
		
		//variable declarations
		
		String status = null, uname = null, uemail = null, upassword = null, AccQuery = null;
		int count = 0;
		
		try {
			// Establishing database connection
			con = ConnectionFactory.getConnectionObject();
			
			// creating statement object
			if(con != null) {
				st = con.createStatement();
				st1 = con.createStatement();
			}
			
			//Getting accounts details
			uname = "'" + acc.getUname() + "'";
			uemail = "'" + acc.getUemail() + "'";
			upassword = "'" + acc.getPass() + "'";
			
			String Checkquery = "SELECT * FROM ACCOUNTS WHERE UNAME = "+uname;
			
			// Execute the query
			if(st1 != null)
				rs = st1.executeQuery(Checkquery);
			
			if (rs.next() == false){
				// INSERT INTO ACCOUNTS VALUES ('sahasourya@gmail.com', 'sourya1234', '1234sourya');
				//generating the query
				String query = "INSERT INTO ACCOUNTS VALUES ("+uemail+", "+uname+", "+upassword+") ";
				//System.out.println(query);
				
				// Execute the query
				if(st != null)
					count = st.executeUpdate(query);
				
				//generating status
				if (count == 1) {
					status = "success";
					String dbname = uname.substring(1, uname.length()-1);
					//System.out.println(dbname);
					AccQuery = "CREATE DATABASE " + dbname+ "";
					if(st != null)
						st.executeUpdate(AccQuery);
				}
				else
					status = "failure";
			}
			else
				status = "DuplicateUname";
			
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
			try {
				if(rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return status;
	}

}
