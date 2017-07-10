/**
 * 
 */
package hu.ysmbdt.wt.persistence.repo;

import java.sql.Date;
import java.sql.Time;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Sort;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import hu.ysmbdt.wt.persistence.entity.QAggregate;

/**
 *  
 *
 * @author kalmankostenszky
 */
public final class AggregateRepositoryHelper {

	private static final Logger log = Logger.getLogger(AggregateRepositoryHelper.class);
	
	public static final Sort SORT_BY_DESC_DATE_TIME = new Sort(Sort.Direction.DESC, "date").and(new Sort(Sort.Direction.DESC, "time"));
	
	private AggregateRepositoryHelper(){
		super();
	}
	
	public static Predicate filterByDate(BooleanBuilder builder, String fromDate, String fromTime, String toDate, String toTime){
		
		log.info("filterByDate invoked");
		
		QAggregate aggregate = QAggregate.aggregate;
		BooleanBuilder where = builder == null ? new BooleanBuilder() : builder;
		if (fromDate != null && fromDate != "") {
			where = where.and(aggregate.date.goe(Date.valueOf(fromDate)));
		}
		if (fromTime != null && fromTime != "") {
			where = where.and(aggregate.time.goe(Time.valueOf(fromTime)));
		} else {
			where = where.and(aggregate.time.goe(java.sql.Time.valueOf("00:00:01")));
		}

		if (toDate != null && toDate != "") {
			where = where.and(aggregate.date.loe(Date.valueOf(toDate)));
		} else {
			where = where.and(aggregate.date.loe(Date.valueOf(fromDate)));
		}

		if (toTime != null && toTime != "") {
			where = where.and(aggregate.time.loe(Time.valueOf(toTime)));
		} else if (toDate != null && toDate != "" ) {
			where = where.and(aggregate.time.loe(java.sql.Time.valueOf("23:59:59")));
		} else {
			where = where.and(aggregate.time.loe(Time.valueOf(fromTime)));
		}
		
		log.info("predicate is: "+where);
		
		return where;
	}
}

