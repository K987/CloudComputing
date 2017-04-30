/**
 * 
 */
package hu.ysmbdt.wt.persistence.domain;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 
 *
 * @author kalmankostenszky
 */
public class ChronoStub {

	private LocalDate fromDate;
	private LocalTime fromTime;
	private LocalDate toDate;
	private LocalTime toTime;

	public ChronoStub(String fromDate, String fromTime, String toDate, String toTime) {
		this.fromDate = LocalDate.parse(fromDate);
		this.fromTime = LocalTime.parse(fromTime);
		this.toDate = LocalDate.parse(toDate);
		this.toTime = LocalTime.parse(toTime);
	}
	
	public ChronoStub(){
		super();
	}

	/**
	 * @return the fromDate
	 */
	public LocalDate getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = LocalDate.parse(fromDate);
	}

	/**
	 * @return the fromTime
	 */
	public LocalTime getFromTime() {
		return fromTime;
	}

	/**
	 * @param fromTime the fromTime to set
	 */
	public void setFromTime(String fromTime) {
		this.fromTime = LocalTime.parse(fromTime);
	}

	/**
	 * @return the toDate
	 */
	public LocalDate getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = LocalDate.parse(toDate);
	}

	/**
	 * @return the toTime
	 */
	public LocalTime getToTime() {
		return toTime;
	}

	/**
	 * @param toTime the toTime to set
	 */
	public void setToTime(String toTime) {
		this.toTime = LocalTime.parse(toTime);;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("ChronoStub [fromDate=%s, fromTime=%s, toDate=%s, toTime=%s]", fromDate, fromTime, toDate, toTime);
	}

}
