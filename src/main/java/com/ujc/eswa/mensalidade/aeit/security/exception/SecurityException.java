package com.ujc.eswa.mensalidade.aeit.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)

public class SecurityException extends BusinessException{

	private static final long serialVersionUID = 1L;

	public SecurityException(String message){
    	super(message);
    }
}
