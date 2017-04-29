/**
 * 
 */
package hu.ysmbdt.wt.persistence.repo;

import org.springframework.data.repository.CrudRepository;

import hu.ysmbdt.wt.persistence.entity.Observation;

/**
 *  
 *
 * @author kalmankostenszky
 */
public interface ObservationRepository extends CrudRepository<Observation, Long> {

	
	
}
