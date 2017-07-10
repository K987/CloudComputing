/**
 * 
 */
package hu.ysmbdt.wt.persistence.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Entity
@Table(name = "observations")
//@NamedQueries(value = {
//		@NamedQuery(name = Observation.FIND_ALL, query = "SELECT o FROM Observation o")
//})
public class Observation implements Serializable{

//	public static final String FIND_ALL = "Observation.findAll";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3241707737210921567L;
	
	@Id
	@SequenceGenerator(name = "OBSERVATIONS_OBSERVATIONID_GENERATOR", sequenceName = "observations_observation_ID_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OBSERVATIONS_OBSERVATIONID_GENERATOR")
	@Column(name = "observation_ID")
	private Long id;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "observation_city", nullable = false)
	private City city;
	
	@Column(name = "observation_station", nullable = false)
	private Integer station;
	
	@Column(name = "observation_time", nullable = false)
	private Timestamp time;
	
	@Column(name = "observation_temperature", nullable = false)
	private Double tempretaure;
	
	@Column(name = "observation_windSpeed", nullable = false)
	private Double windSpeed;
	
	@Column(name = "observation_rain", nullable = false)
	private Double rain;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "observation_sky", nullable = false)
	private Sky sky;
	
	public Observation(){
		super();
	}

	/**
	 * @param city
	 * @param station
	 * @param time
	 * @param tempretaure
	 * @param windSpeed
	 * @param rain
	 * @param sky
	 */
	public Observation(City city, Integer station, Timestamp time, Double tempretaure, Double windSpeed, Double rain, Sky sky) {
		super();
		this.city = city;
		this.station = station;
		this.time = time;
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
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the station
	 */
	public Integer getStation() {
		return station;
	}

	/**
	 * @param station the station to set
	 */
	public void setStation(Integer station) {
		this.station = station;
	}

	/**
	 * @return the time
	 */
	public Timestamp getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Timestamp time) {
		this.time = time;
	}

	/**
	 * @return the tempretaure
	 */
	public Double getTempretaure() {
		return tempretaure;
	}

	/**
	 * @param tempretaure the tempretaure to set
	 */
	public void setTempretaure(Double tempretaure) {
		this.tempretaure = tempretaure;
	}

	/**
	 * @return the windSpeed
	 */
	public Double getWindSpeed() {
		return windSpeed;
	}

	/**
	 * @param windSpeed the windSpeed to set
	 */
	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}

	/**
	 * @return the rain
	 */
	public Double getRain() {
		return rain;
	}

	/**
	 * @param rain the rain to set
	 */
	public void setRain(Double rain) {
		this.rain = rain;
	}

	/**
	 * @return the sky
	 */
	public Sky getSky() {
		return sky;
	}

	/**
	 * @param sky the sky to set
	 */
	public void setSky(Sky sky) {
		this.sky = sky;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Observation [id=%s, city=%s, station=%s, time=%s, tempretaure=%s, windSpeed=%s, rain=%s, sky=%s]", id, city, station, time,
				tempretaure, windSpeed, rain, sky);
	}
	
	
	
}
