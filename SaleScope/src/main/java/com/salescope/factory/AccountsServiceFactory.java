package com.salescope.factory;

import com.salescope.service.AccountsService;
import com.salescope.service.AccountsServiceImpl;

public class AccountsServiceFactory {
	private static AccountsService accService = null;
	static {
		accService = new AccountsServiceImpl();
	}
	public static AccountsService getAccountsServiceObject() {
		return accService;
	}
}
