/**
 * 
 */
package com.bt.microservices.blogservice.web.rest.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jagro
 *
 */
public class ErrorObject {
	   @JsonProperty("code")
	    private String code;

	    @JsonProperty("statusCode")
	    private int statusCode;

	    @JsonProperty("title")
	    private String title;

	    @JsonProperty("detail")
	    private String detail;

		public ErrorObject() {
			super();
		}

		/**
		 * @return the code
		 */
		public String getCode() {
			return code;
		}

		/**
		 * @param code the code to set
		 */
		public void setCode(String code) {
			this.code = code;
		}

		/**
		 * @return the statusCode
		 */
		public int getStatusCode() {
			return statusCode;
		}

		/**
		 * @param statusCode the statusCode to set
		 */
		public void setStatusCode(int statusCode) {
			this.statusCode = statusCode;
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
		 * @return the detail
		 */
		public String getDetail() {
			return detail;
		}

		/**
		 * @param detail the detail to set
		 */
		public void setDetail(String detail) {
			this.detail = detail;
		}
	    
	   
	    
}
