/**
 * 
 */
package hu.ysmbdt.wt.persistence.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import hu.ysmbdt.wt.persistence.entity.Aggregate;
import hu.ysmbdt.wt.persistence.entity.City;

/**
 *  
 *
 * @author kalmankostenszky
 */
public interface AggregateRepository extends CrudRepository<Aggregate, Long>, QueryDslPredicateExecutor<Aggregate>{

	/**
	 * @param city
	 * @return
	 */
	List<Aggregate> findByArea(City area, Sort sort);
	
	

	
}
