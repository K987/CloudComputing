/**
 * 
 */
package hu.ysmbdt.wt.persistence.repo;

import org.springframework.data.repository.CrudRepository;

import hu.ysmbdt.wt.persistence.entity.Aggregate;

/**
 *  
 *
 * @author kalmankostenszky
 */
public interface AggregateRepository extends CrudRepository<Aggregate, Long> {

}
