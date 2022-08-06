package WebServices.user.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import WebServices.user.UserNotFoundException;

@ControllerAdvice
//When we have multiple controller classes and we want to share things among them
//then we use ControllerAdvice Annotation..

@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllException
  (Exception ex, WebRequest request) {
	 
		ExceptionResponse exceptionResponse=
			       new ExceptionResponse(new Date(),ex.getMessage(),
			        request.getDescription(false));
		
	return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);

 }
	
	//We can customise our custom message template for different type of class.
	
	@ExceptionHandler(UserNotFoundException.class)
	  public final ResponseEntity<Object> handleAllExceptionUser
	  (Exception ex, WebRequest request) {
		 
			ExceptionResponse exceptionResponse=
				       new ExceptionResponse(new Date(),ex.getMessage(),
				        request.getDescription(false));
			
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);

	 }
	
	//This is the method which is fired when binding to a specific
	//method argument failed. Here, we are biniding user in post mapping
	//and it is failed coz we have put a valid annotation there and we had imposed some
	//condition on the id and name field of user...
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exceptionResponse=
			       new ExceptionResponse(new Date(),"Validation Failed",
			        ex.getBindingResult().toString());
		
		return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
}
