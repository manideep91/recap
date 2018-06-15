package com.mmdworks.recap.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@ControllerAdvice
public class RecapCoreExceptionHandler {

	@ExceptionHandler(value = { UserExistsException.class })
	@ResponseBody
	public ResponseEntity<CustomeMessage> UserExistsException(IOException exception) {
		exception.printStackTrace();
		CustomeMessage errorMessage = CustomeMessage.statusCode(HttpStatus.INTERNAL_SERVER_ERROR).developerMsg(exception.getMessage())
				.message(exception.getMessage()).exception(exception.getClass().getName()).build();
		return new ResponseEntity<CustomeMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value = { UserNotFoundException.class })
	@ResponseBody
	public ResponseEntity<CustomeMessage> UserNotException(IOException exception) {
		exception.printStackTrace();
		CustomeMessage errorMessage = CustomeMessage.statusCode(HttpStatus.INTERNAL_SERVER_ERROR).developerMsg(exception.getMessage())
				.message(exception.getMessage()).exception(exception.getClass().getName()).build();
		return new ResponseEntity<CustomeMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
