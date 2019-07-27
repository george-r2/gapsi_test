package com.gapsi.test.jama_test.rest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gapsi.test.jama_test.beans.BeanError;
import com.gapsi.test.jama_test.beans.Response;
import com.gapsi.test.jama_test.exception.NonExistingItemException;
import com.gapsi.test.jama_test.util.Utils;

@RestControllerAdvice
public class ExceptionControllerRest  extends ResponseEntityExceptionHandler{

	private static final Logger LOGGER = Logger.getLogger(ExceptionControllerRest.class);
	
	
	@ExceptionHandler(NonExistingItemException.class)
	public ResponseEntity<Response> handleApsDaoException(NonExistingItemException ex,WebRequest request){
		logger.warn("Error NonExistingItemException manejado en el ControllerAdvice:"+ex.getMessage());
		Response response = new Response();
		response.setSuccess(false);
		BeanError error = new BeanError();
		error.setCode(ex.getClass().getSimpleName());
		error.setDescription(ex.getMessage());
		response.setError(error);
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		 logger.warn("Returning HTTP 400 Bad Request", ex);
		Response response = Utils.createFailedResponse(ex.getClass().getSimpleName(), "el cuerpo de la peticion esta mal formado");
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	@SuppressWarnings({"rawtypes","unchecked"})
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.info("Parametros invalidos del servicio REST:"+request.getDescription(false));
		Response response = new Response();
		BeanError error = new BeanError();
		error.setCode("01");
		BindingResult br = ex.getBindingResult();
		StringBuilder errorMessage = new StringBuilder();
		for(FieldError err: br.getFieldErrors()) {
			LOGGER.info(this.getClass().getSimpleName()+"_handleMethodArgumentNotValid_"+err.getDefaultMessage());
			errorMessage.append(err.getDefaultMessage()+", ");
		}
		error.setDescription(errorMessage.substring(0,errorMessage.length()-2));
		response.setError(error);
		return new ResponseEntity(response, HttpStatus.UNPROCESSABLE_ENTITY);
	}
}
