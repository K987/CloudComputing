/**
 * 
 */
package hu.ysmbdt.wt.persistence.repo;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Sort;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import hu.ysmbdt.wt.persistence.domain.ChronoStub;
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
	
	public static Predicate filterByDate(BooleanBuilder builder, ChronoStub body){
		
		log.info("filterByDate invoked w params: \n" + body.toString());
		
		QAggregate aggregate = QAggregate.aggregate;
		BooleanBuilder where = builder == null ? new BooleanBuilder() : builder;
		if (body.getFromDate() != null) {
			where = where.and(aggregate.date.goe(body.getFromDate()));
		}
		if (body.getFromTime() != null) {
			where = where.and(aggregate.time.goe(body.getFromTime()));
		} else {
			where = where.and(aggregate.time.goe(java.sql.Time.valueOf("00:00:01")));
		}

		if (body.getToDate() != null) {
			where = where.and(aggregate.date.loe(body.getToDate()));
		} else {
			where = where.and(aggregate.date.loe(body.getFromDate()));
		}

		if (body.getToTime() != null) {
			where = where.and(aggregate.time.loe(body.getToTime()));
		} else if (body.getToDate() != null) {
			where = where.and(aggregate.time.loe(java.sql.Time.valueOf("23:59:59")));
		} else {
			where = where.and(aggregate.time.loe(body.getFromTime()));
		}
		
		log.info("predicate is: "+where);
		
		return where;
	}
}

