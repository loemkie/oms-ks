package com.oms.exception;

/**
 * 
 * @author Baidu API Team (apihelp@baidu.com)
 * 
 * @version 1.0.0, $Date: 2013-5-9$
 * 
 */
public class ParseException extends Exception {

	private static final long serialVersionUID = 638241177122665217L;

	public ParseException() {
		super();
	}

	public ParseException(String msg) {
		super(msg);
	}

	public ParseException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public ParseException(Throwable cause){
		super(cause);
	}
	
	public ParseException(String msg, int errorCode) {
		super("ErrorCode : " + errorCode + ", info : " + msg);
	}

}
