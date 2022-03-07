package com.lti.prasanna.exception;

import java.util.Date;

public class ErrorDetails extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
   }

    public String getDetails() {
       return details;
   }
    
    
}