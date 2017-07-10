#using small linux distro for postgres https://hub.docker.com/_/postgres/
FROM postgres:9.6-alpine

#set locale to hu
#RUN localedef -i hu_HU -c -f UTF-8 -A /usr/share/locale/locale.alias hu_HU.UTF-8
ENV LANG hu_HU.utf8

#copy db init files
RUN mkdir /init_data
COPY *.sql /init_data/
COPY *.csv /init_data/

#copy database init script
COPY createDB.sh /docker-entrypoint-initdb.d/
