package com.ujc.eswa.mensalidade.aeit.security.exception;

import java.time.LocalDateTime;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler({ BusinessException.class })
	public ResponseEntity<ExceptionDetails> handleBusinessException(BusinessException ex, WebRequest request) {

		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(), ex.getStatus().value(),
				ExceptionUtils.getRootCauseMessage(ex), ex.getMessage());

		return new ResponseEntity<ExceptionDetails>(exceptionDetails, new HttpHeaders(), ex.getStatus());
	}

	@ExceptionHandler({ IllegalArgumentException.class })
	public ResponseEntity<ExceptionDetails> handleIllegalArgumentException(IllegalArgumentException ex,
			WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				ex.getCause().getMessage(), ex.getMessage());

		return new ResponseEntity<ExceptionDetails>(exceptionDetails, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ExceptionDetails exceptionDetails = new ExceptionDetails(LocalDateTime.now(), status.value(),
				ex.getCause().getMessage(), ex.getMessage());

		return new ResponseEntity<>(exceptionDetails, headers, status);
	}

}
