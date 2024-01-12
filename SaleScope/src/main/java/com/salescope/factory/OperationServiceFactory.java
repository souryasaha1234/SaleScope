package com.salescope.factory;

import com.salescope.service.OperationService;
import com.salescope.service.OperationServiceImpl;

public class OperationServiceFactory {
	private static OperationService operationService = null;
	static {
		operationService = new OperationServiceImpl();
	}
	public static OperationService getOperationServiceObject() {
		return operationService;
	}
}
