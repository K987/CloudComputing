/**
 * 
 */
package hu.ysmbdt.wt.persistence.converter;

import java.util.List;

import hu.ysmbdt.wt.persistence.domain.AggregateStub;
import hu.ysmbdt.wt.persistence.entity.Aggregate;

/**
 *  
 *
 * @author kalmankostenszky
 */
public interface AggregateConverter {

	/**
	 * 
	 * @param aggregate
	 * @return
	 */
	AggregateStub to(Aggregate aggregate);
	
	/**
	 * 
	 * @param aggregates
	 * @return
	 */
	List<AggregateStub> to(List<Aggregate> aggregates);
	
	/**
	 * 
	 * @param aggregateStub
	 * @return
	 */
	Aggregate from(AggregateStub aggregateStub);
	
	/**
	 * 
	 * @param aggregateStubs
	 * @return
	 */
	List<Aggregate> from(List<AggregateStub> aggregateStubs);
	
	
}
