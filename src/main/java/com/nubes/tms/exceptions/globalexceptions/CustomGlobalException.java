package com.nubes.tms.exceptions.globalexceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nubes.tms.exceptions.ApiErrorResponse;
import com.nubes.tms.exceptions.IssueNotFoundException;

@ControllerAdvice
public class CustomGlobalException extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ IssueNotFoundException.class })
	public ResponseEntity<ApiErrorResponse> issueNotFound(Exception e) {
		ApiErrorResponse error = new ApiErrorResponse();
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

}
