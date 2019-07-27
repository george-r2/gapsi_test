package com.gapsi.test.jama_test.exception;

public class DuplicatedItemException extends JamaException{

	private static final long serialVersionUID = 7932297113599864958L;

	private String code;
	private String message;
	
	public DuplicatedItemException (){
		super();
	}
	
	
	public DuplicatedItemException(String message) {
		super();
		this.message=message;
	}
	
	public DuplicatedItemException(String code,String message) {
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
