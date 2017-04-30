package hu.ysmbdt.wt.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QObservation is a Querydsl query type for Observation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QObservation extends EntityPathBase<Observation> {

    private static final long serialVersionUID = -2002281485L;

    public static final QObservation observation = new QObservation("observation");

    public final EnumPath<City> city = createEnum("city", City.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> rain = createNumber("rain", Double.class);

    public final EnumPath<Sky> sky = createEnum("sky", Sky.class);

    public final NumberPath<Integer> station = createNumber("station", Integer.class);

    public final NumberPath<Double> tempretaure = createNumber("tempretaure", Double.class);

    public final DateTimePath<java.sql.Timestamp> time = createDateTime("time", java.sql.Timestamp.class);

    public final NumberPath<Double> windSpeed = createNumber("windSpeed", Double.class);

    public QObservation(String variable) {
        super(Observation.class, forVariable(variable));
    }

    public QObservation(Path<? extends Observation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QObservation(PathMetadata metadata) {
        super(Observation.class, metadata);
    }

}

