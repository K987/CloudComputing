/**
 * 
 */
package hu.ysmbdt.wt.persistence.restcontroller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import hu.ysmbdt.wt.persistence.exception.RestServiceException;

/**
 *  
 *
 * @author kalmankostenszky
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ResponseBody
	@ExceptionHandler(value = {RestServiceException.class})
	protected ResponseEntity<Object> handleRestServiceException(RestServiceException ex, WebRequest request){	
		return handleExceptionInternal(ex,  ex.toString(), new HttpHeaders(), ex.getHttpStatusCode(), request);
	}
	

}
