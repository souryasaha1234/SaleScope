package com.salescope.service;

import com.salescope.bean.Accounts;
import com.salescope.dao.AccountsDao;
import com.salescope.factory.AccountsDaoFactory;

public class AccountsServiceImpl implements AccountsService {

	@Override
	public String loginService(Accounts acc) {
		AccountsDao accountsDao = AccountsDaoFactory.getAccountsDaoObject();
		String status = accountsDao.loginDao(acc);
		return status;
	}

	@Override
	public String signupService(Accounts acc) {
		AccountsDao accountsDao = AccountsDaoFactory.getAccountsDaoObject();
		String status = accountsDao.signupDao(acc);
		return status;
	}

}
