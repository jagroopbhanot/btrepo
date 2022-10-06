/**
 * 
 */
package com.bt.microservices.blogservice.web.rest.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jagro
 *
 */
public class ErrorResponse {
	  
	@JsonProperty("errors")
	private List<ErrorObject> errors;

	/**
	 * @return the errors
	 */
	public List<ErrorObject> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<ErrorObject> errors) {
		this.errors = errors;
	}
}
