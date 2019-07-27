package com.gapsi.test.jama_test.exception;

public class NonExistingItemException extends JamaException{

	private static final long serialVersionUID = -336347093919461519L;

	private String code;
	private String message;
	
	public NonExistingItemException (){
		super();
	}
	
	
	public NonExistingItemException(String message) {
		super();
		this.message=message;
	}
	
	public NonExistingItemException(String code,String message) {
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
