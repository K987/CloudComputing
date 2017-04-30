/**
 * 
 */
package hu.ysmbdt.wt.persistence.restcontroller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import hu.ysmbdt.wt.persistence.exception.CityNotFoundException;
import hu.ysmbdt.wt.persistence.exception.NotFoundException;
import hu.ysmbdt.wt.persistence.exception.SkyNotFoundException;

/**
 *  
 *
 * @author kalmankostenszky
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = {CityNotFoundException.class, SkyNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)	
	protected ResponseEntity<Object> handleNonExistingResource(NotFoundException ex, WebRequest request){	
		return handleExceptionInternal(ex, ex.getBody(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
