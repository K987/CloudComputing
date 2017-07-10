#!/bin/sh

set -e

psql -v ON_ERROR_STOP=1 -d postgres -U postgres -f /init_data/01_create_schema.sql
psql -v ON_ERROR_STOP=1 -d weather_db -U postgres -f /init_data/02_create_table.sql
psql -v ON_ERROR_STOP=1 -d weather_db -U postgres -f /init_data/03_load_from_csv.sql
psql -v ON_ERROR_STOP=1 -d weather_db -U postgres -f /init_data/04_grant_access.sql
