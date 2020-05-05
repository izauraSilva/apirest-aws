package br.com.izatec.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.izatec.exception.ExceptionResponse;
import br.com.izatec.exception.ResourceNotFoundException;

@RestController
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
					new Date(), 
					ex.getMessage(), 
					request.getDescription(false)
				);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request){		
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
					new Date(), 
					ex.getMessage(), 
					request.getDescription(false)
				);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnsupportedOperationException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestException(Exception ex, WebRequest request){		
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
					new Date(), 
					ex.getMessage(), 
					request.getDescription(false)
				);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
}
