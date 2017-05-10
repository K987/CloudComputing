/**
 * 
 */
package hu.ysmbdt.cqrs.schedule;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import hu.ysmbdt.cqrs.entity.Aggregate;
import hu.ysmbdt.cqrs.entity.City;
import hu.ysmbdt.cqrs.entity.Observation;
import hu.ysmbdt.cqrs.entity.Sky;
import hu.ysmbdt.cqrs.repo.AggregateRepository;
import hu.ysmbdt.cqrs.repo.ObservationRepository;

/**
 * 
 *
 * @author kalmankostenszky
 */
@Component
public class Scheduler {

	private static final Logger log = Logger.getLogger(Scheduler.class);

	private static final Random rnd = new Random();

	@Autowired
	private AggregateRepository aggregateRepository;

	@Autowired
	private ObservationRepository observationRepository;

	@Scheduled(fixedDelay = 30000)
	public void pushNewRecord() {

		for (City city : City.values()) {
			Observation observation = new Observation();
			observation.setCity(city);
			observation.setRain(rnd.nextDouble() * 5);
			observation.setSky(Sky.values()[rnd.nextInt(Sky.values().length)]);
			observation.setStation(rnd.nextInt(3)+1);
			observation.setTempretaure(rnd.nextDouble() * 30);
			observation.setWindSpeed(rnd.nextDouble() * 9);
			observation.setTime(java.sql.Timestamp.valueOf(LocalDateTime.now()));

			this.observationRepository.save(observation);
		}
	}

	@Scheduled(cron = "0 5 */1 * * *")
	public void aggregate() {

		LocalDateTime dttm = LocalDateTime.now().minusHours(1);
		LocalDateTime from = LocalDateTime.of(dttm.getYear(), dttm.getMonth(), dttm.getDayOfMonth(), dttm.getHour(), 0, 0);
		LocalDateTime to = LocalDateTime.of(dttm.getYear(), dttm.getMonth(), dttm.getDayOfMonth(), dttm.getHour(), 59, 59);

		for (City city : City.values()) {
			List<Observation> observations = this.observationRepository.findAllByCityAndDatesBetween(city, java.sql.Timestamp.valueOf(from),
					java.sql.Timestamp.valueOf(to));

			double tempAvg = observations.stream().mapToDouble(Observation::getTempretaure).average().getAsDouble();
			double tempMin = observations.stream().mapToDouble(Observation::getTempretaure).min().getAsDouble();
			double tempMax = observations.stream().mapToDouble(Observation::getTempretaure).max().getAsDouble();
			double tempStddev = calcStddev(tempAvg, observations.stream().map(Observation::getTempretaure).collect(Collectors.toList()));

			double rainAvg = observations.stream().mapToDouble(Observation::getRain).average().getAsDouble();
			double rainMin = observations.stream().mapToDouble(Observation::getRain).min().getAsDouble();
			double rainMax = observations.stream().mapToDouble(Observation::getRain).max().getAsDouble();
			double rainStddev = calcStddev(rainAvg, observations.stream().map(Observation::getRain).collect(Collectors.toList()));

			double windAvg = observations.stream().mapToDouble(Observation::getWindSpeed).average().getAsDouble();
			double windMin = observations.stream().mapToDouble(Observation::getWindSpeed).min().getAsDouble();
			double windMax = observations.stream().mapToDouble(Observation::getWindSpeed).max().getAsDouble();
			double windStddev = calcStddev(windAvg, observations.stream().map(Observation::getWindSpeed).collect(Collectors.toList()));

			Aggregate aggregate = new Aggregate();
			
			aggregate.setArea(city);
			
			aggregate.setDate(java.sql.Date.valueOf(dttm.toLocalDate()));
			aggregate.setTime(java.sql.Time.valueOf(from.toLocalTime()));
			
			aggregate.setTempAvg(tempAvg);
			aggregate.setTempMin(tempMin);
			aggregate.setTempMax(tempMax);
			aggregate.setTempStddev(tempStddev);
			
			aggregate.setRainAvg(rainAvg);
			aggregate.setRainMin(rainMin);
			aggregate.setRainMax(rainMax);
			aggregate.setRainStddev(rainStddev);
			
			aggregate.setWindAvg(windAvg);
			aggregate.setWindMin(windMin);
			aggregate.setWindMax(windMax);
			aggregate.setWindStddev(windStddev);
			
			this.aggregateRepository.save(aggregate);	
		}
	}

	/**
	 * @param tempAvg
	 * @param collect
	 * @return
	 */
	private double calcStddev(double avg, List<Double> collect) {

		if (collect.size() < 0)
			return 0;

		Double rtrn = 0.0;

		for (Double num : collect) {
			rtrn += Math.pow((num - avg), 2);
		}

		rtrn /= collect.size();
		return Math.sqrt(rtrn);
	}

}
