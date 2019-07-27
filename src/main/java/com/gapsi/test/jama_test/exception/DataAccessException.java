package com.gapsi.test.jama_test.exception;

public class DataAccessException extends JamaException {

	private static final long serialVersionUID = 7086757507842046111L;

	private String code;
	private String message;
	
	public DataAccessException (){
		super();
	}
	
	
	public DataAccessException(String message) {
		super();
		this.message=message;
	}
	
	public DataAccessException(String code,String message) {
		super();
		this.code=code;
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	public String getCode() {
		return this.code;
	}
	
	@Override
	public String toString(){
		return message = "JamaException: " + message;
	}
}
