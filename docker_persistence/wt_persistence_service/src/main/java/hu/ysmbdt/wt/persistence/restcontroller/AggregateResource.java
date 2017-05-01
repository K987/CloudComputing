/**
 * 
 */
package hu.ysmbdt.wt.persistence.restcontroller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import hu.ysmbdt.wt.persistence.domain.AggregateStub;

/**
 * 
 *
 * @author kalmankostenszky
 */
public class AggregateResource extends ResourceSupport {

	private final Long aggregateId;
	private final AggregateStub aggregate;

	public AggregateResource(AggregateStub stub){
		this.aggregateId = stub.getId();
		this.aggregate = stub; 
		
		initSelfLink();
		initCityLink();
		initPreviousHourLink();
		initNextHour();
	}

	/**
	 * 
	 */
	private void initNextHour() {
		LocalTime current = LocalTime.parse(aggregate.getTime());
		LocalTime next = current.plusHours(1);
		LocalDate day = LocalDate.parse(aggregate.getDay());
		if (next.compareTo(current) < 0 ){
			 day = day.plusDays(1);
		}
		super.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(AggregateController.class).findByCityAndDateTime(this.aggregate.getCity(), day.toString() , next.toString()+":00", "", "")).withRel("next hour"));
		
	}

	/**
	 * 
	 */
	private void initPreviousHourLink() {
		LocalTime current = LocalTime.parse(aggregate.getTime());
		LocalTime previous = current.minusHours(1);
		LocalDate day = LocalDate.parse(aggregate.getDay());
		if (previous.compareTo(current) > 0 ){
			 day = day.minusDays(1);
		}
		super.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(AggregateController.class).findByCityAndDateTime(this.aggregate.getCity(), day.toString() , previous.toString()+":00", "", "")).withRel("prvious hour"));
	}

	/**
	 * 
	 */
	private void initCityLink() {
		super.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(AggregateController.class).findByCityDescending(this.aggregate.getCity()))
				.withRel("getCity"));
	}

	/**
	 * 
	 */
	private void initSelfLink() {
		super.add(ControllerLinkBuilder.linkTo(AggregateController.class).slash(this.aggregateId).withSelfRel());
	}

	/**
	 * @return the id
	 */
	public Long getAggregateId() {
		return aggregateId;
	}

	/**
	 * @return the body
	 */
	public AggregateStub getBody() {
		return aggregate;
	}
}
