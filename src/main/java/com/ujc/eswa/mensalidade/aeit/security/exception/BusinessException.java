package com.ujc.eswa.mensalidade.aeit.security.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 7458422488439244886L;

	private HttpStatus status = HttpStatus.BAD_REQUEST;

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
