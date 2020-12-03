package com.demo.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
* <h1>Record Not Found Exception</h1>
* The class generates custom exception for user not found scenarios.
* <p>
*
* @author  Ketki Gupta
* @version 1.0
* @since   2020-12-03
*/
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String message) {
		super(message);
	}

	public RecordNotFoundException(String message, Throwable t) {
		super(message, t);
	}
}
