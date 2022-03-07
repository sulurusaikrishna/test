package com.lti.prasanna.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/*@ControllerAdvice
 * provide centralized exception handling across all @RequestMapping methods through @ExceptionHandler methods.
 *  It provides an methods for handling internal Spring MVC exceptions. 
 *  It returns a ResponseEntity in contrast to DefaultHandlerExceptionResolver which returns a ModelAndView.
 
 *@ControllerAdvice is a specialization of the @Component annotation which allows 
 *to handle exceptions across the whole application in one global handling component. 
 *It can be viewed as an interceptor of exceptions thrown by methods annotated with @RequestMapping and similar.

It declares @ExceptionHandler, @InitBinder, or @ModelAttribute methods to be shared across multiple @Controller classes.
 */


@ControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(" some error at server" +errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(" some error at server" +errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}