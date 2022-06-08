package org.mindbowser.demo.security.business.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomGlobalExceptionHandler {

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleResourceNotFoundExceptions(Exception ex)
	{
		return new ErrorResponse(new Date(), "Resource Not Exists", ex.getMessage(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	
	
	@ExceptionHandler(value = {ResourceAlreadyExistException.class})
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public ErrorResponse handleResourceAlreadyExitsExceptions(Exception ex)
	{
		return new ErrorResponse(new Date(), "Resource Already Exists", ex.getMessage(), HttpStatus.ALREADY_REPORTED.value(), ex.getMessage());
	}
	
	@ExceptionHandler(value = {InvalidCredentialsException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleInvalidCredentialsException(Exception ex)
	{
		return new ErrorResponse(new Date(), "Please enter correct credentials", ex.getMessage(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
}
