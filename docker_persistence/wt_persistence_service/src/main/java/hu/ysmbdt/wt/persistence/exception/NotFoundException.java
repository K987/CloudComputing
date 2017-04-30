/**
 * 
 */
package hu.ysmbdt.wt.persistence.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * 
 *
 * @author kalmankostenszky
 */
public abstract class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String notExists;
	private List<String> availableValues;
	private final int statusCode = HttpStatus.NOT_FOUND.value();

	protected NotFoundException(String message, String notExists) {
		super(message);
		this.notExists = notExists;
	}

	public void setAvailableValues(List<String> availableValues) {
		if (availableValues == null) {
			this.availableValues = new ArrayList<>();
		}
		this.availableValues = availableValues;
	}

	public ExceptionBody getBody() {
		return new ExceptionBody(this.getMessage(), this.notExists, this.availableValues, this.statusCode);
	}

	private class ExceptionBody {

		private final String message;
		private final int statusCode;
		private final String notExists;
		private final List<String> availableValues;

		ExceptionBody(String message, String notExists, List<String> availableValues, int statusCode) {
			this.message = message;
			this.notExists = notExists;
			this.availableValues = availableValues;
			this.statusCode = statusCode;
		}

		/**
		 * @return the message
		 */
		public String getMessage() {
			return message;
		}

		/**
		 * @return the statusCode
		 */
		public int getStatusCode() {
			return statusCode;
		}

		/**
		 * @return the notExists
		 */
		public String getNotExists() {
			return notExists;
		}

		/**
		 * @return the availableValues
		 */
		public List<String> getAvailableValues() {
			return availableValues;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return String.format("ExceptionBody [message=%s, statusCode=%s, notExists=%s, availableValues=%s]", message, statusCode, notExists,
					availableValues);
		}

	}

}
