COPY observations(observation_city,  observation_station,  observation_time,  observation_temperature,  observation_wind_speed, obeservation_rain, observation_sky)
FROM '/init_data/observations.csv' DELIMITER ';' CSV HEADER;

COPY aggregates(aggregate_area,aggregate_date,aggregate_time,aggregate_temp_avg,aggragate_temp_min,aggragate_temp_max,aggregate_temp_stddev,aggregate_wind_avg,aggragate_wind_min,aggragate_wind_max,aggregate_wind_stddev,aggregate_rain_avg,aggragate_rain_min,aggragate_rain_max,aggregate_rain_stddev)
FROM '/init_data/aggregates.csv' DELIMITER ';' CSV HEADER;
