GRANT SELECT, INSERT, UPDATE, DELETE ON
observations,
aggregates
TO wt_crud_role;

GRANT USAGE, SELECT, UPDATE ON
observations_observation_ID_seq,
aggregates_aggregate_ID_seq
TO wt_crud_role;
