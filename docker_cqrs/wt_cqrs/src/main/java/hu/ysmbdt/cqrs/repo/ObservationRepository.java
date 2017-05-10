/**
 * 
 */
package hu.ysmbdt.cqrs.repo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hu.ysmbdt.cqrs.entity.City;
import hu.ysmbdt.cqrs.entity.Observation;

/**
 * 
 *
 * @author kalmankostenszky
 */
public interface ObservationRepository extends JpaRepository<Observation, Long> {

	@Query("SELECT o FROM Observation o WHERE o.city = :city and o.time BETWEEN :from AND :to")
	List<Observation> findAllByCityAndDatesBetween(
			@Param("city") City city,
			@Param("from")  Timestamp from,
			@Param("to") Timestamp to
			);
	
	//@Temporal(TemporalType.TIMESTAMP) 
}
