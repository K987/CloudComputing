/**
 * 
 */
package hu.ysmbdt.wt.persistence.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import hu.ysmbdt.wt.persistence.domain.ObservationStub;
import hu.ysmbdt.wt.persistence.entity.Observation;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Service(value = "observationConverter")
public class ObservationConverterImpl implements ObservationConverter {

	/* (non-Javadoc)
	 * @see hu.ysmbdt.wt.persistence.converter.ObservationConverter#from(hu.ysmbdt.wt.persistence.entity.Observation)
	 */
	@Override
	public ObservationStub from(Observation observation) {
		
		return new ObservationStub(
				observation.getId().longValue(),
				observation.getCity().getName(),
				observation.getStation(),
				observation.getTime(),
				observation.getTempretaure(),
				observation.getWindSpeed(),
				observation.getRain(),
				observation.getSky().getName()
				);
		
				
	}

	/* (non-Javadoc)
	 * @see hu.ysmbdt.wt.persistence.converter.ObservationConverter#from(java.util.List)
	 */
	@Override
	public List<ObservationStub> from(List<Observation> observations) {
		List<ObservationStub> rtrn = new ArrayList<>();
		for (Observation observation : observations) {
			rtrn.add(from(observation));
		}
		return rtrn;
	}

	/* (non-Javadoc)
	 * @see hu.ysmbdt.wt.persistence.converter.ObservationConverter#to(hu.ysmbdt.wt.persistence.domain.ObservationStub)
	 */
	@Override
	public Observation to(ObservationStub observationStub) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see hu.ysmbdt.wt.persistence.converter.ObservationConverter#to(java.util.List)
	 */
	@Override
	public List<ObservationStub> to(List<ObservationStub> observationStub) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
