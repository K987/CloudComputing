package hu.ysmbdt.wt.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAggregate is a Querydsl query type for Aggregate
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAggregate extends EntityPathBase<Aggregate> {

    private static final long serialVersionUID = -2048260282L;

    public static final QAggregate aggregate = new QAggregate("aggregate");

    public final EnumPath<City> area = createEnum("area", City.class);

    public final DatePath<java.sql.Date> date = createDate("date", java.sql.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> rainAvg = createNumber("rainAvg", Double.class);

    public final NumberPath<Double> rainMax = createNumber("rainMax", Double.class);

    public final NumberPath<Double> rainMin = createNumber("rainMin", Double.class);

    public final NumberPath<Double> rainStddev = createNumber("rainStddev", Double.class);

    public final NumberPath<Double> tempAvg = createNumber("tempAvg", Double.class);

    public final NumberPath<Double> tempMax = createNumber("tempMax", Double.class);

    public final NumberPath<Double> tempMin = createNumber("tempMin", Double.class);

    public final NumberPath<Double> tempStddev = createNumber("tempStddev", Double.class);

    public final TimePath<java.sql.Time> time = createTime("time", java.sql.Time.class);

    public final NumberPath<Double> windAvg = createNumber("windAvg", Double.class);

    public final NumberPath<Double> windMax = createNumber("windMax", Double.class);

    public final NumberPath<Double> windMin = createNumber("windMin", Double.class);

    public final NumberPath<Double> windStddev = createNumber("windStddev", Double.class);

    public QAggregate(String variable) {
        super(Aggregate.class, forVariable(variable));
    }

    public QAggregate(Path<? extends Aggregate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAggregate(PathMetadata metadata) {
        super(Aggregate.class, metadata);
    }

}

