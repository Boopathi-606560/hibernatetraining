package com.example.incedohibernatetraining.exception;


/*
 * Author : boopathi ramasamy 
 * Incedo hibernate training project
 * 
 */

public class AccountNotFoundException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String errMsg) {
		super(errMsg);	
		
	}
	
	

}
