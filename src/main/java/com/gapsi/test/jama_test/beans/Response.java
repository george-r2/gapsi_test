package com.gapsi.test.jama_test.beans;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
	private Result result;
	private Boolean success;
	private BeanError error;
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public BeanError getError() {
		return error;
	}
	public void setError(BeanError error) {
		this.error = error;
	}
	
}
