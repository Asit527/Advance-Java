package com.kodewala.exception;

public class InSufficentBalanceException  extends RuntimeException{
	public InSufficentBalanceException(String _message)
	{
		super(_message);
	}
}
