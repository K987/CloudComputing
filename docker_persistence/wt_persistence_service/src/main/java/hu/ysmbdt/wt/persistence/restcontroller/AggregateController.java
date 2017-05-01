/**
 * 
 */
package hu.ysmbdt.wt.persistence.restcontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import hu.ysmbdt.wt.persistence.converter.AggregateConverter;
import hu.ysmbdt.wt.persistence.domain.AggregateStub;
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
class AggregateController {

	private static final Logger log = Logger.getLogger(AggregateController.class);

	@Autowired
	private AggregateConverter converter;

	@Autowired
	private AggregateRepository repository;

	@RequestMapping(value = "/city/cities", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAvailableCities() {
		log.info("getAvailableCities invoked");

		return ResponseEntity.ok().body(Arrays.stream(City.values()).map(c -> c.getName()).collect(Collectors.toList()));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		log.info("findById invoked with param: " + id);

		return Optional.ofNullable(this.repository.findOne(id)).map(aggregate -> {
			AggregateResource body = new AggregateResource(this.converter.to(aggregate));
			return ResponseEntity.ok().body(body);
		}).orElse(ResponseEntity.notFound().build());
	}

	@RequestMapping(value = "/city/{city}", method = RequestMethod.GET, produces = "application/json")
	public Collection<AggregateStub> findByCityDescending(@PathVariable String city) {
		log.info("findByCityDescending invoked with param: " + city);

		City enumCity = checkCity(city);

		return this.converter.to(this.repository.findByArea(enumCity, AggregateRepositoryHelper.SORT_BY_DESC_DATE_TIME));

	}

	@RequestMapping(value = "/city/{city}/time", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findByCityAndDateTime(@PathVariable String city, @RequestParam("fromDate") String fromDate,
			@RequestParam("fromTime") String fromTime, @RequestParam(value = "toDate", required = false) String toDate,
			@RequestParam(value = "toTime", required = false) String toTime) {
		log.info("findByCityAndDateTime invoked: " + fromTime);

		City enumCity = checkCity(city);

		QAggregate aggregate = QAggregate.aggregate;
		Predicate where = AggregateRepositoryHelper.filterByDate(new BooleanBuilder(aggregate.area.eq(enumCity)), fromDate, fromTime, toDate, toTime);

		final List<AggregateResource> body = new ArrayList<>();

		this.repository.findAll(where, AggregateRepositoryHelper.SORT_BY_DESC_DATE_TIME)
				.forEach(agr -> body.add(new AggregateResource(this.converter.to(agr))));

		return body.size() > 0 ? ResponseEntity.ok().body(body) : ResponseEntity.notFound().build();
	}

	private City checkCity(String city) {
		City enumCity;
		try {
			enumCity = City.valueOf(city.toUpperCase());
		} catch (IllegalArgumentException e) {
			log.error("City does not exists: " + e);
			throw new RestServiceException("City does not exists. " + city, null, HttpStatus.BAD_REQUEST);
		}
		return enumCity;
	}


}
