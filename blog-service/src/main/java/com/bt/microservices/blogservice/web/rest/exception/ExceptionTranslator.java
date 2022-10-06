package com.bt.microservices.blogservice.web.rest.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionTranslator {
	
	private final Logger log = LoggerFactory.getLogger(ExceptionTranslator.class);
	
	  @ExceptionHandler(value = Exception.class)
	    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
	        log.error("Error response from External API in handleException: {}", ex.getMessage(), ex);
	        return getErrorResponseResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCodeEnum.EXT_API_ERROR);
	    }
	  
	  private ResponseEntity<ErrorResponse> getErrorResponseResponseEntity(HttpStatus httpStatus, ErrorCodeEnum errorCodeEnum) {
	        ErrorResponse errorResponse = new ErrorResponse();
	        ErrorObject errorObject = new ErrorObject();
	        errorObject.setCode(errorCodeEnum.getErrorCode());
	        errorObject.setStatusCode(httpStatus.value());
	        errorObject.setTitle(errorCodeEnum.getTitle());
	        errorObject.setDetail(errorCodeEnum.getMessage());
	        List<ErrorObject> errors = new ArrayList<>();
	        errors.add(errorObject);
	        errorResponse.setErrors(errors);
	        return new ResponseEntity<>(errorResponse, httpStatus);
	    }
}
