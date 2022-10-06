/**
 * 
 */
package com.bt.microservices.blogservice.web.rest.exception;

/**
 * @author jagro
 *
 */
public enum ErrorCodeEnum {
	EXT_API_ERROR("BT001", "Something has gone wrong", "There is some problem in external API");

	private String errorCode;
	private String title;
	private String message;
	
	private ErrorCodeEnum(String errorCode, String title, String message) {
		this.errorCode = errorCode;
		this.title = title;
		this.message = message;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
