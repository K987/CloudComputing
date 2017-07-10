/**
 * 
 */
package hu.ysmbdt.wt.persistence.domain;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

/**
 *  
 *
 * @author kalmankostenszky
 */
public class ObservationStub {

	private final Long id;
	private final String city;
	private final Integer stationNumber;
	private final String time;
	private final Double tempretaure;
	private final Double windSpeed;
	private final Double rain;
	private final String sky;

	/**
	 * @param id
	 * @param city
	 * @param station
	 * @param time
	 * @param tempretaure
	 * @param windSpeed
	 * @param rain
	 * @param sky
	 */
	public ObservationStub(Long id, String city, Integer station, Timestamp time, Double tempretaure, Double windSpeed, Double rain, String sky) {
		this.id = id;
		this.city = city;
		this.stationNumber = station;
		this.time = time.toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		this.tempretaure = tempretaure;
		this.windSpeed = windSpeed;
		this.rain = rain;
		this.sky = sky;
		
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
	 * @return the stationNumber
	 */
	public Integer getStationNumber() {
		return stationNumber;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @return the tempretaure
	 */
	public Double getTempretaure() {
		return tempretaure;
	}

	/**
	 * @return the windSpeed
	 */
	public Double getWindSpeed() {
		return windSpeed;
	}

	/**
	 * @return the rain
	 */
	public Double getRain() {
		return rain;
	}

	/**
	 * @return the sky
	 */
	public String getSky() {
		return sky;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("ObservationStub [id=%s, city=%s, stationNumber=%s, time=%s, tempretaure=%s, windSpeed=%s, rain=%s, sky=%s]", id, city,
				stationNumber, time, tempretaure, windSpeed, rain, sky);
	}
	
	

	
}
