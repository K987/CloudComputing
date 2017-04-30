/**
 * 
 */
package hu.ysmbdt.wt.persistence.restcontroller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import hu.ysmbdt.wt.persistence.auth.ClientAuthenticationService;
import hu.ysmbdt.wt.persistence.converter.AggregateConverter;
import hu.ysmbdt.wt.persistence.domain.AggregateStub;
import hu.ysmbdt.wt.persistence.domain.ChronoStub;
import hu.ysmbdt.wt.persistence.entity.Aggregate;
import hu.ysmbdt.wt.persistence.entity.City;
import hu.ysmbdt.wt.persistence.entity.QAggregate;
import hu.ysmbdt.wt.persistence.exception.RestServiceException;
import hu.ysmbdt.wt.persistence.repo.AggregateRepository;
import hu.ysmbdt.wt.persistence.repo.AggregateRepositoryHelper;

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
	
	@Autowired
	private ClientAuthenticationService authService;

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody AggregateStub findById(@PathVariable Long id) {
		log.info("findById invoked with param: " + id);
		return this.converter.to(this.repository.findOne(id));
	}

	@RequestMapping(value = "/{city}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<AggregateStub> findByCityDescending(@PathVariable String city,@RequestHeader(value="access-token") String token) {
		log.info("findByCityDescending invoked with param: " + city);
		
		checkToken(token);
		City enumCity = checkCity(city);

		return this.converter.to(this.repository.findByArea(enumCity, AggregateRepositoryHelper.SORT_BY_DESC_DATE_TIME));

	}

	@RequestMapping(value = "/{city}", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<AggregateStub> findByCityAndDateTime(@PathVariable String city, @RequestBody String json) {
		log.info("findByCityAndDateTime invoked with param: city:"+city +"\n body: "+json);

		City enumCity = checkCity(city);
		ChronoStub body = convertFromJson(json, ChronoStub.class);

		QAggregate aggregate = QAggregate.aggregate;
		Predicate where = AggregateRepositoryHelper.filterByDate(new BooleanBuilder(aggregate.area.eq(enumCity)), body);

		return this.converter.to((List<Aggregate>) this.repository.findAll(where, AggregateRepositoryHelper.SORT_BY_DESC_DATE_TIME));
	}

	private City checkCity(String city) {
		City enumCity;
		try {
			enumCity = City.valueOf(city.toUpperCase());
		} catch (IllegalArgumentException e) {
			log.error("City does not exists: "+ e);
			throw new RestServiceException("City does not exists. " + city, null, HttpStatus.BAD_REQUEST);
		}
		return enumCity;
	}

	private <T extends Object> T convertFromJson(String json, Class<T> type) {
		ObjectMapper mapper = new ObjectMapper();
		T body = null;
		try {
			body = mapper.readValue(json, type);
		} catch (JsonParseException e) {
			log.error("JSON is not wellformed: "+ e);
			throw new RestServiceException("JSON is not wellformed", null, HttpStatus.NOT_ACCEPTABLE);
		} catch (JsonMappingException e) {
			log.error("invalid parameter: "+e);
			throw new RestServiceException("invalid parameter", null, HttpStatus.BAD_REQUEST);
		} catch (IOException e) {
			log.error("unknown error:" +e);
			throw new RestServiceException("unknown error", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return body;
	}
	
	private void checkToken(String token){
		
		if (!this.authService.checkToken(token)){
			throw new RestServiceException(null, "Invalid token", HttpStatus.FORBIDDEN);
		}
	}

}
