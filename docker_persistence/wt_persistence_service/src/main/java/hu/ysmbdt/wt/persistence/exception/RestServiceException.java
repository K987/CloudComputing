/**
 * 
 */
package hu.ysmbdt.wt.persistence.exception;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;

/**
 *  
 *
 * @author kalmankostenszky
 */
public class RestServiceException extends RuntimeException {

	private final String message;
	private final String description;
	private final HttpStatus httpStatus;
	/**
	 * @param rootCause
	 * @param description
	 * @param httpStatusCode
	 */
	public RestServiceException(String rootCause, String description,  HttpStatus httpStatus) {
		super();
		this.message = rootCause;
		this.description = description;
		this.httpStatus = httpStatus;
	}
	/**
	 * @return the httpStatusCode
	 */
	public HttpStatus getHttpStatusCode() {
		return httpStatus;
	}
	
	@Override
	public String toString(){
		JSONObject rtrn = new JSONObject();
		rtrn.put("message", this.message);
		rtrn.put("HttpStatusCode", this.httpStatus.value());
		rtrn.put("HttpStatusMessage", this.httpStatus.getReasonPhrase());
		rtrn.put("description", this.description);
		return rtrn.toJSONString();
	}
	
}
