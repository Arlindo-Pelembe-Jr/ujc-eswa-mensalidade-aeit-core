package com.ujc.eswa.mensalidade.aeit.security.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExceptionDetails implements Serializable {

	private static final long serialVersionUID = 8808218722540571595L;

	private LocalDateTime timestamp;

	private int status;

	private String error;

	private String message;

	public ExceptionDetails() {
		super();
	}

	public ExceptionDetails(LocalDateTime timestamp, int status, String error, String message) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
