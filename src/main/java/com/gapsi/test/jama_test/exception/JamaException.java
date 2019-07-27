package com.gapsi.test.jama_test.exception;

public class JamaException extends Exception{

	private static final long serialVersionUID = -3527493986349137678L;

	private String code;
	private String message;
	
	public JamaException (){
		super();
	}
	
	
	public JamaException(String message) {
		super();
		this.message=message;
	}
	
	public JamaException(String code,String message) {
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
