/**
 * 
 */
package hu.ysmbdt.wt.persistence.domain;

import java.sql.Date;
import java.sql.Time;
import java.time.format.DateTimeFormatter;

/**
 *  
 *
 * @author kalmankostenszky
 */
public class AggregateStub{

	private final Long id;
	private final  String city;
	private final  String day;
	private final String time;
	private final Double tempAvg;
	private final Double tempMin;
	private final Double tempMax;
	private final Double tempStddev;
	private final Double windAvg;
	private final  Double windMin;
	private final  Double windMax;
	private final  Double windStddev;
	private final  Double rainAvg;
	private final  Double rainMin;
	private final  Double rainMax;
	private final  Double rainStddev;

	/**
	 * @param id
	 * @param city
	 * @param date
	 * @param time
	 * @param tempAvg
	 * @param tempMin
	 * @param tempMin2
	 * @param tempStddev
	 * @param windAvg
	 * @param windMin
	 * @param windMax
	 * @param windStddev
	 * @param rainAvg
	 * @param rainMin
	 * @param rainMax
	 * @param rainStddev
	 */
	public AggregateStub(Long id, String city, Date date, Time time, Double tempAvg, Double tempMin, Double tempMax, Double tempStddev, Double windAvg,
			Double windMin, Double windMax, Double windStddev, Double rainAvg, Double rainMin, Double rainMax, Double rainStddev) {
		
		
		this.id = id;
		this.city = city;
		this.day = date.toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
		this.time = time.toLocalTime().format(DateTimeFormatter.ISO_LOCAL_TIME);
		this.tempAvg = tempAvg;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.tempStddev = tempStddev;
		this.windAvg = windAvg;
		this.windMin = windMin;
		this.windMax = windMax;
		this.windStddev = windStddev;
		this.rainAvg = rainAvg;
		this.rainMin = rainMin;
		this.rainMax = rainMax;
		this.rainStddev = rainStddev;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @return the tempAvg
	 */
	public Double getTempAvg() {
		return tempAvg;
	}

	/**
	 * @return the tempMin
	 */
	public Double getTempMin() {
		return tempMin;
	}

	/**
	 * @return the tempMax
	 */
	public Double getTempMax() {
		return tempMax;
	}

	/**
	 * @return the tempStddev
	 */
	public Double getTempStddev() {
		return tempStddev;
	}

	/**
	 * @return the windAvg
	 */
	public Double getWindAvg() {
		return windAvg;
	}

	/**
	 * @return the windMin
	 */
	public Double getWindMin() {
		return windMin;
	}

	/**
	 * @return the windMax
	 */
	public Double getWindMax() {
		return windMax;
	}

	/**
	 * @return the windStddev
	 */
	public Double getWindStddev() {
		return windStddev;
	}

	/**
	 * @return the rainAvg
	 */
	public Double getRainAvg() {
		return rainAvg;
	}

	/**
	 * @return the rainMin
	 */
	public Double getRainMin() {
		return rainMin;
	}

	/**
	 * @return the rainMax
	 */
	public Double getRainMax() {
		return rainMax;
	}

	/**
	 * @return the rainStddev
	 */
	public Double getRainStddev() {
		return rainStddev;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"AggregateStub [id=%s, city=%s, day=%s, time=%s, tempAvg=%s, tempMin=%s, tempMax=%s, tempStddev=%s, windAvg=%s, windMin=%s, windMax=%s, windStddev=%s, rainAvg=%s, rainMin=%s, rainMax=%s, rainStddev=%s]",
				id, city, day, time, tempAvg, tempMin, tempMax, tempStddev, windAvg, windMin, windMax, windStddev, rainAvg, rainMin, rainMax, rainStddev);
	}
	
	



}
