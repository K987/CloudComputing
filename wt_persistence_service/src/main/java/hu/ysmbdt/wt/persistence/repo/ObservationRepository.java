/**
 * 
 */
package hu.ysmbdt.wt.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.ysmbdt.wt.persistence.entity.Observation;

/**
 *  
 *
 * @author kalmankostenszky
 */
public interface ObservationRepository extends JpaRepository<Observation, Long> {

	/**
	 * 
	 * @return
	 */
	List<Observation> findFirst10ByOrderByTimeDesc();
	
}
