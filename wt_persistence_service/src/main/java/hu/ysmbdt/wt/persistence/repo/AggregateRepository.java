/**
 * 
 */
package hu.ysmbdt.wt.persistence.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import hu.ysmbdt.wt.persistence.entity.Aggregate;
import hu.ysmbdt.wt.persistence.entity.City;

/**
 *  
 *
 * @author kalmankostenszky
 */
public interface AggregateRepository extends  JpaRepository<Aggregate, Long>, QueryDslPredicateExecutor<Aggregate>{

	/**
	 * @param city
	 * @return
	 */
	List<Aggregate> findByArea(City area, Sort sort);


	
}
