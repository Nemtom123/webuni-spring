package hu.webuni.airport.web;

import java.util.List;

import org.springframework.validation.FieldError;

public class MyError {
	private int errorCode;
	private String message;
	private List<FieldError> fieldError;
	
	public List<FieldError> getFieldError() {
		return fieldError;
	}
	public void setFieldError(List<FieldError> fieldError) {
		this.fieldError = fieldError;
	}
	public MyError(int errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
