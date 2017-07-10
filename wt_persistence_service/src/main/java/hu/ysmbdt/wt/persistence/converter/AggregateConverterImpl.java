/**
 * 
 */
package hu.ysmbdt.wt.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hu.ysmbdt.wt.persistence.domain.AggregateStub;
import hu.ysmbdt.wt.persistence.entity.Aggregate;
import hu.ysmbdt.wt.persistence.entity.City;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Service(value="aggregateConverter")
public class AggregateConverterImpl implements AggregateConverter {

	/* (non-Javadoc)
	 * @see hu.ysmbdt.wt.persistence.converter.AggregateConverter#to(hu.ysmbdt.wt.persistence.entity.Aggregate)
	 */
	@Override
	public AggregateStub to(Aggregate aggregate) {
		return new AggregateStub(
				aggregate.getId().longValue(),
				aggregate.getArea().getName(),
				aggregate.getDate(),
				aggregate.getTime(),
				aggregate.getTempAvg(),
				aggregate.getTempMin(),
				aggregate.getTempMax(),
				aggregate.getTempStddev(),
				aggregate.getWindAvg(),
				aggregate.getWindMin(),
				aggregate.getWindMax(),
				aggregate.getWindStddev(),
				aggregate.getRainAvg(),
				aggregate.getRainMin(),
				aggregate.getRainMax(),
				aggregate.getRainStddev()
				);
	}

	/* (non-Javadoc)
	 * @see hu.ysmbdt.wt.persistence.converter.AggregateConverter#to(java.util.List)
	 */
	@Override
	public List<AggregateStub> to(List<Aggregate> aggregates) {
		
		List <AggregateStub> stubs = new ArrayList<>();
		
		for (Aggregate aggregate : aggregates) {
			stubs.add(to(aggregate));
		}
		return stubs;
	}

	/* (non-Javadoc)
	 * @see hu.ysmbdt.wt.persistence.converter.AggregateConverter#from(hu.ysmbdt.wt.persistence.domain.AggregateStub)
	 */
	@Override
	public Aggregate from(AggregateStub aggregateStub) {
	
		return new Aggregate(
				City.valueOf(aggregateStub.getCity().toUpperCase()),
				java.sql.Date.valueOf(aggregateStub.getDay()),
				java.sql.Time.valueOf(aggregateStub.getTime()),
				aggregateStub.getTempAvg(), 
				aggregateStub.getTempMin(), 
				aggregateStub.getTempMax(), 
				aggregateStub.getTempStddev(), 
				aggregateStub.getWindAvg(), 
				aggregateStub.getWindMin(), 
				aggregateStub.getWindMax(), 
				aggregateStub.getWindStddev(), 
				aggregateStub.getRainAvg(), 
				aggregateStub.getRainMin(), 
				aggregateStub.getRainMax(), 
				aggregateStub.getRainStddev()); 
	}

	/* (non-Javadoc)
	 * @see hu.ysmbdt.wt.persistence.converter.AggregateConverter#from(java.util.List)
	 */
	@Override
	public List<Aggregate> from(List<AggregateStub> aggregateStubs) {
		List <Aggregate> stubs = new ArrayList<>();
		
		for (AggregateStub aggregateStub : aggregateStubs) {
			stubs.add(from(aggregateStub));
		}
		return stubs;
	}


	
	
	
}
