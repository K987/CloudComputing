/**
 * 
 */
package hu.ysmbdt.wt.persistence.restcontroller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hu.ysmbdt.wt.persistence.converter.AggregateConverter;
import hu.ysmbdt.wt.persistence.domain.AggregateStub;
import hu.ysmbdt.wt.persistence.domain.ChronoStub;
import hu.ysmbdt.wt.persistence.entity.City;
import hu.ysmbdt.wt.persistence.exception.CityNotFoundException;
import hu.ysmbdt.wt.persistence.repo.AggregateRepository;

/**
 * 
 *
 * @author kalmankostenszky
 */
@RestController
@RequestMapping("/aggregate")
public class AggregateController {

	private static final Logger log = Logger.getLogger(AggregateController.class);
	
	@Autowired
	private AggregateConverter converter;

	@Autowired
	private AggregateRepository repository;

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody AggregateStub findById(@PathVariable Long id) {

		return this.converter.to(this.repository.findOne(id));
	}

	@RequestMapping(value = "/{city}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<AggregateStub> findByCityDescending(@PathVariable String city) {
		log.info("findByCityDescending invoked with param: "+city);
		
		City enumCity;
		try{
			enumCity = City.valueOf(city.toUpperCase());
		} catch (IllegalArgumentException e){
			log.error(e.getMessage());
			throw new CityNotFoundException("City does not exists", city);
		}
		
		return this.converter.to(this.repository.findByArea(enumCity,new Sort(Sort.Direction.DESC, "date").and(new Sort(Sort.Direction.DESC,"time"))));

	}
	
	@RequestMapping(value="/{city}", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<AggregateStub> findByCityAndDateTime(@PathVariable String city, @RequestBody ChronoStub body){
		log.info("findByCityAndDateTime invoked");
		
		return null;
		
		
		
	}

}
