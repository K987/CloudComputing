CREATE DATABASE weather_db encoding 'UTF-8' LC_COLLATE='hu_HU.UTF_8' LC_CTYPE='hu_HU.UTF-8' TEMPLATE=template0;
CREATE ROLE wt_crud_role WITH NOSUPERUSER NOCREATEDB NOCREATEROLE;
CREATE USER wt_crud_user;
ALTER USER wt_crud_user PASSWORD 'pwd123';
GRANT wt_crud_role TO wt_crud_user;
