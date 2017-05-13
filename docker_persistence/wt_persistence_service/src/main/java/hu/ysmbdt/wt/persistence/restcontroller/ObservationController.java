/**
 * 
 */
package hu.ysmbdt.wt.persistence.restcontroller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.ysmbdt.wt.persistence.converter.ObservationConverter;
import hu.ysmbdt.wt.persistence.domain.ObservationStub;
import hu.ysmbdt.wt.persistence.repo.ObservationRepository;

/**
 *  
 *
 * @author kalmankostenszky
 */
@RestController
@RequestMapping("/observation")
public class ObservationController {
	
	private static final Logger logger = Logger.getLogger(ObservationController.class);

	@Autowired
	private ObservationRepository repository;
	
	@Autowired
	private ObservationConverter converter;
	
	@RequestMapping(value = "/latestTen", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getLatestTen(){
		logger.info("method getLatestTen invoked");
		List<ObservationStub> rtrn = this.converter.from(this.repository.findFirst10ByOrderByTimeDesc());
		if (rtrn.isEmpty()){
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(rtrn);
		}
	}
}
