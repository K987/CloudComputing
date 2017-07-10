/**
 * 
 */
package hu.ysmbdt.wt.persistence.converter;

import java.util.List;

import hu.ysmbdt.wt.persistence.domain.ObservationStub;
import hu.ysmbdt.wt.persistence.entity.Observation;

/**
 *  
 *
 * @author kalmankostenszky
 */
public interface ObservationConverter {

	/**
	 * 
	 * @param observation
	 * @return
	 */
	ObservationStub from(Observation observation);
	
	/**
	 * 
	 * @param observations
	 * @return
	 */
	List<ObservationStub> from(List<Observation> observations);
	
	/**
	 * 
	 * @param observationStub
	 * @return
	 */
	Observation to(ObservationStub observationStub);
	
	/**
	 * 
	 * @param observationStub
	 * @return
	 */
	List<ObservationStub> to(List<ObservationStub> observationStub);
	
	
}
