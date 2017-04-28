GRANT SELECT, INSERT, UPDATE, DELETE ON
observations,
aggregates
TO wt_crud_role;

GRANT USAGE, SELECT, UPDATE ON
observation_ID_seq,
aggregate_ID_seq
TO wt_crud_role;
