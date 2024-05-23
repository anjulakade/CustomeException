package com.example.springbhootcrudapp.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(CustomerNotFoundException.class)
	 public ResponseEntity<ApiErrors>  customerNotFoundExceptionHandler(CustomerNotFoundException e,HttpServletRequest request)
	 {
		 System.out.println("exception handler");
		 ApiErrors error=new ApiErrors();
		  error.setDate(new Date());
		  error.setStatuscode(HttpStatus.NOT_FOUND.value());
		  error.setMassage(e.getMessage());
		 error.setPath(request.getRequestURI());
		  error.setHttmassage(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiErrors>(error,HttpStatus.NOT_FOUND);
		  
		  
	 }
	@ExceptionHandler(ArithmeticException.class)
	  public ResponseEntity<String> ArithmathicException(ArithmeticException e)
	  {
		return new  ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR) ;
		  
	  }
}
