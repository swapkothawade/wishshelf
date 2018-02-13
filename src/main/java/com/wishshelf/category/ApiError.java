package com.wishshelf.category;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {

	HttpStatus status;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private String timeStamp;
	private String message;
	private String debugMessage;
	List<ApiSubErrors> subErrors;
	
	private ApiError(){
		timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss"));
	}
	ApiError(HttpStatus status){
		this();
		this.status=status;
	}
	ApiError(HttpStatus status, Throwable tx){
		this();
		this.status=status;
		this.message="Unexpected Error";
		this.debugMessage = tx.getLocalizedMessage();
	}
	ApiError(HttpStatus status,String message, Throwable tx){
		this();
		this.status=status;
		this.message=message;
		this.debugMessage = tx.getLocalizedMessage();
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDebugMessage() {
		return debugMessage;
	}
	public List<ApiSubErrors> getSubErrors() {
		return subErrors;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
	public void setSubErrors(List<ApiSubErrors> subErrors) {
		this.subErrors = subErrors;
	}
	
	
	
}
