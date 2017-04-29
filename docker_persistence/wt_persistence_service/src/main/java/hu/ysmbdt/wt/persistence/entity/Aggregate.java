/**
 * 
 */
package hu.ysmbdt.wt.persistence.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

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
@Table(name = "aggregates")
//@NamedQueries(value = {
//		@NamedQuery(name = Aggregate.FIND_ALL, query = "SELECT a FROM Aggregate a"),
//		@NamedQuery(name = Aggregate.FIND_BY_ID, query= "SELECT a FROM Aggregate a WHERE :"+Aggregate.ID )
//})
public class Aggregate implements Serializable{

//	public static final String FIND_ALL = "Aggregate.findAll";
//	public static final String FIND_BY_ID = "Aggregate.findAll";
//	public static final String ID = "id";
//	
	/**
	 * 
	 */
	private static final long serialVersionUID = -34915809800775562L;

	@Id
	@SequenceGenerator(name = "AGGREGATES_AGGREGATEID_GENERATOR", sequenceName = "aggregates_aggregate_ID_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AGGREGATES_AGGREGATEID_GENERATOR")
	@Column(name = "aggregate_ID")
	private Long id;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "aggregate_area", nullable = false)
	private City area;
	
	@Column(name = "aggregate_date", nullable = false)
	private Date date;
	
	@Column(name = "aggregate_time", nullable = false)
	private Time time;
	
	@Column(name = "aggregate_temp_avg", nullable = false)
	private Double tempAvg;
	
	@Column(name = "aggregate_temp_min", nullable = false)
	private Double tempMin;
	
	@Column(name = "aggregate_temp_max", nullable = false)
	private Double tempMax;
	
	@Column(name = "aggregate_temp_stddev", nullable = false)
	private Double tempStddev;
	
	@Column(name = "aggregate_wind_avg", nullable = false)
	private Double windAvg;
	
	@Column(name = "aggregate_wind_min", nullable = false)
	private Double windMin;
	
	@Column(name = "aggregate_wind_max", nullable = false)
	private Double windMax;
	
	@Column(name = "aggregate_wind_stddev", nullable = false)
	private Double windStddev;
	
	@Column(name = "aggregate_rain_avg", nullable = false)
	private Double rainAvg;
	
	@Column(name = "aggregate_rain_min", nullable = false)
	private Double rainMin;
	
	@Column(name = "aggregate_rain_max", nullable = false)
	private Double rainMax;
	
	@Column(name = "aggregate_rain_stddev", nullable = false)
	private Double rainStddev;
	
	public Aggregate(){
		super();
	}

	/**
	 * @param area
	 * @param date
	 * @param time
	 * @param tempAvg
	 * @param tempMin
	 * @param tempMax
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
	public Aggregate(City area, Date date, Time time, Double tempAvg, Double tempMin, Double tempMax, Double tempStddev, Double windAvg,
			Double windMin, Double windMax, Double windStddev, Double rainAvg, Double rainMin, Double rainMax, Double rainStddev) {
		super();
		this.area = area;
		this.date = date;
		this.time = time;
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
	 * @return the area
	 */
	public City getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(City area) {
		this.area = area;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the time
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Time time) {
		this.time = time;
	}

	/**
	 * @return the tempAvg
	 */
	public Double getTempAvg() {
		return tempAvg;
	}

	/**
	 * @param tempAvg the tempAvg to set
	 */
	public void setTempAvg(Double tempAvg) {
		this.tempAvg = tempAvg;
	}

	/**
	 * @return the tempMin
	 */
	public Double getTempMin() {
		return tempMin;
	}

	/**
	 * @param tempMin the tempMin to set
	 */
	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}

	/**
	 * @return the tempMax
	 */
	public Double getTempMax() {
		return tempMax;
	}

	/**
	 * @param tempMax the tempMax to set
	 */
	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}

	/**
	 * @return the tempStddev
	 */
	public Double getTempStddev() {
		return tempStddev;
	}

	/**
	 * @param tempStddev the tempStddev to set
	 */
	public void setTempStddev(Double tempStddev) {
		this.tempStddev = tempStddev;
	}

	/**
	 * @return the windAvg
	 */
	public Double getWindAvg() {
		return windAvg;
	}

	/**
	 * @param windAvg the windAvg to set
	 */
	public void setWindAvg(Double windAvg) {
		this.windAvg = windAvg;
	}

	/**
	 * @return the windMin
	 */
	public Double getWindMin() {
		return windMin;
	}

	/**
	 * @param windMin the windMin to set
	 */
	public void setWindMin(Double windMin) {
		this.windMin = windMin;
	}

	/**
	 * @return the windMax
	 */
	public Double getWindMax() {
		return windMax;
	}

	/**
	 * @param windMax the windMax to set
	 */
	public void setWindMax(Double windMax) {
		this.windMax = windMax;
	}

	/**
	 * @return the windStddev
	 */
	public Double getWindStddev() {
		return windStddev;
	}

	/**
	 * @param windStddev the windStddev to set
	 */
	public void setWindStddev(Double windStddev) {
		this.windStddev = windStddev;
	}

	/**
	 * @return the rainAvg
	 */
	public Double getRainAvg() {
		return rainAvg;
	}

	/**
	 * @param rainAvg the rainAvg to set
	 */
	public void setRainAvg(Double rainAvg) {
		this.rainAvg = rainAvg;
	}

	/**
	 * @return the rainMin
	 */
	public Double getRainMin() {
		return rainMin;
	}

	/**
	 * @param rainMin the rainMin to set
	 */
	public void setRainMin(Double rainMin) {
		this.rainMin = rainMin;
	}

	/**
	 * @return the rainMax
	 */
	public Double getRainMax() {
		return rainMax;
	}

	/**
	 * @param rainMax the rainMax to set
	 */
	public void setRainMax(Double rainMax) {
		this.rainMax = rainMax;
	}

	/**
	 * @return the rainStddev
	 */
	public Double getRainStddev() {
		return rainStddev;
	}

	/**
	 * @param rainStddev the rainStddev to set
	 */
	public void setRainStddev(Double rainStddev) {
		this.rainStddev = rainStddev;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Aggregate [id=%s, area=%s, date=%s, time=%s, tempAvg=%s, tempMin=%s, tempMax=%s, tempStddev=%s, windAvg=%s, windMin=%s, windMax=%s, windStddev=%s, rainAvg=%s, rainMin=%s, rainMax=%s, rainStddev=%s]",
				id, area, date, time, tempAvg, tempMin, tempMax, tempStddev, windAvg, windMin, windMax, windStddev, rainAvg, rainMin, rainMax, rainStddev);
	}
	
	
	
	
	
	
}
