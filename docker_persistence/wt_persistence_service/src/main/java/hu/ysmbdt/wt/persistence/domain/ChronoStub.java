/**
 * 
 */
package hu.ysmbdt.wt.persistence.domain;

import java.sql.Date;
import java.sql.Time;

/**
 * 
 *
 * @author kalmankostenszky
 */
public class ChronoStub {

	private Date fromDate;
	private Time fromTime;
	private Date toDate;
	private Time toTime;

	public ChronoStub(String fromDate, String fromTime, String toDate, String toTime) {
		this.fromDate = Date.valueOf(fromDate);
		this.fromTime = Time.valueOf(fromTime);
		this.toDate = Date.valueOf(toDate);
		this.toTime = Time.valueOf(toTime);
	}
	
	public ChronoStub(){
		super();
	}

	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @return the fromTime
	 */
	public Time getFromTime() {
		return fromTime;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @return the toTime
	 */
	public Time getToTime() {
		return toTime;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate == null ? null : Date.valueOf(fromDate);
	}

	/**
	 * @param fromTime the fromTime to set
	 */
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime  == null ? null : Time.valueOf(fromTime);
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate == null ? null : Date.valueOf(toDate);
	}

	/**
	 * @param toTime the toTime to set
	 */
	public void setToTime(String toTime) {
		this.toTime = fromTime  == null ? null : Time.valueOf(toTime);
	}

	
	
}
	
	
