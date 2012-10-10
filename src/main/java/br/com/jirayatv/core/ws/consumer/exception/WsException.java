package br.com.jirayatv.core.ws.consumer.exception;

import java.io.InputStream;


/**
 * 
 * @author Wagner Araujo wagner.wjaa@gmail.com
 *
 */
public class WsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5131572898529755711L;
	
	private int statusCode;
	private InputStream bodyError;
	
	/**
	 * 
	 * @param httpStatus
	 * @param msg
	 */
	public WsException (int statusCode, String msg){
		super(msg);
		this.statusCode = statusCode;
	}
	
	/**
	 * 
	 * @param httpStatus
	 * @param msg
	 */
	public WsException (int statusCode, String msg, InputStream bodyError){
		super(msg);
		this.statusCode = statusCode;
		this.bodyError = bodyError;
	}
	
	
	
	

	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public InputStream getBodyError() {
		return bodyError;
	}


	public void setBodyError(InputStream bodyError) {
		this.bodyError = bodyError;
	}
	
}
