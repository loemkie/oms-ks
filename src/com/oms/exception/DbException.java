package com.oms.exception;

/**
 * 
 * @author Baidu API Team (apihelp@baidu.com)
 * 
 * @version 1.0.0, $Date: 2013-5-9$
 * 
 */
public class DbException extends Exception {

	private static final long serialVersionUID = 638241177122665217L;

	public DbException() {
		super();
	}

	public DbException(String msg) {
		super(msg);
	}

	public DbException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public DbException(Throwable cause){
		super(cause);
	}
	
	public DbException(String msg, int errorCode) {
		super("ErrorCode : " + errorCode + ", info : " + msg);
	}

}
