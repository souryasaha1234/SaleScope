package com.salescope.factory;

import com.salescope.dao.AccountsDao;
import com.salescope.dao.AccountsDaoImpl;

public class AccountsDaoFactory {
	private static AccountsDao accountsDao = null;
	static {
		accountsDao = new AccountsDaoImpl();
	}
	public static AccountsDao getAccountsDaoObject() {
		return accountsDao;
	}
}
