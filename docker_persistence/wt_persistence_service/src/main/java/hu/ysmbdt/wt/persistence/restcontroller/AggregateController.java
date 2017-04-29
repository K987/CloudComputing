/**
 * 
 */
package hu.ysmbdt.wt.persistence.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.ysmbdt.wt.persistence.converter.AggregateConverter;
import hu.ysmbdt.wt.persistence.domain.AggregateStub;
import hu.ysmbdt.wt.persistence.repo.AggregateRepository;

/**
 *  
 *
 * @author kalmankostenszky
 */
@RestController
@RequestMapping("/Aggregate")
public class AggregateController {

	@Autowired
	private AggregateConverter converter;
	
	@Autowired
	private AggregateRepository repository;
	
	@RequestMapping(value="/getById/{id}", method=RequestMethod.GET, produces="application/json")
	public AggregateStub findById(@PathVariable Long id){
		
		return this.converter.to(this.repository.findOne(id));
	}
	
}
