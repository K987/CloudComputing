CREATE TABLE observations(
  observation_ID SERIAL PRIMARY KEY,
  observation_city VARCHAR(100) NOT NULL,
  observation_station INTEGER NOT NULL,
  observation_time TIMESTAMP NOT NULL,
  observation_temperature DECIMAL NOT NULL,
  observation_wind_speed DECIMAL NOT NULL,
  obeservation_rain DECIMAL NOT NULL,
  observation_sky VARCHAR(100) NOT NULL
  );

ALTER TABLE observations OWNER TO postgres;

CREATE TABLE aggregates(
    aggregate_ID SERIAL PRIMARY KEY,
    aggregate_area VARCHAR(100) NOT NULL,
    aggregate_date DATE NOT NULL,
    aggregate_time TIME NOT NULL,
    aggregate_temp_avg DECIMAL NOT NULL,
    aggragate_temp_min DECIMAL NOT NULL,
    aggragate_temp_max DECIMAL NOT NULL,
    aggregate_temp_stddev DECIMAL NOT NULL,
    aggregate_wind_avg DECIMAL NOT NULL,
    aggragate_wind_min DECIMAL NOT NULL,
    aggragate_wind_max DECIMAL NOT NULL,
    aggregate_wind_stddev DECIMAL NOT NULL,
    aggregate_rain_avg DECIMAL NOT NULL,
    aggragate_rain_min DECIMAL NOT NULL,
    aggragate_rain_max DECIMAL NOT NULL,
    aggregate_rain_stddev DECIMAL NOT NULL
    );

ALTER TABLE aggregates OWNER TO postgres;
