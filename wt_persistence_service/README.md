1. build the image: docker build -t <name_of_the_image> .
2. launch docker_database container if haven't launched yet
3. run command 'gradle clean build' in ./wt_persistence_service directory
3. run a container (choose an option):

  * `docker run -e "SPRING_PROFILES_ACTIVE=hardwired" --detach --name <name_of_the_container> -p 8070:8080 <name_of_the_image>`
  > all the configurations are wired in applicaton.yml:
```
  datasource:
    url: jdbc:postgresql://192.168.99.100:5432/weather_db
    username: wt_crud_user
    password: pwd123
    authentication_service:
    url: http://192.168.99.100:8080
```
---
  * `docker run -e "SPRING_PROFILES_ACTIVE=docker_env" -e "DATABASE_HOST=<ip_of_database_container>" -e "DATABASE_PORT=5432" -e "DATABASE_USER=wt_crud_user" -e "DATABASE_PASSWORD=pwd123" -e "AUTH_SERVICE_HOST=<ip_of_autch_service_container>" -e "AUTH_SERVICE_PORT=8080"--detach --name <name_of_the_container> -p 8070:8080 <name_of_the_image>`

  > to find out the host of containers run 'docker-machine ip' command
  > NOTE: default values may also change!!
---
  * `docker run -e "SPRING_PROFILES_ACTIVE=docker_linked" --link <databse_container_name>:weatherDB --link <auth_service_container_name>:authDB --detach --name <name_of_the_container> -p 8070:8080 <name_of_the_image>`
---

# Provided services:

for every service you have to put the access token in the request header "access-token" : "Bearer <token>"

1. GET <host>:8070/aggregate/{id}

  * _output:_ the weather data of the given id

2. GET <host>:8070/aggregate/cities

  * _output:_ list of cities

3. GET <host>:8070/aggregate/cities/{city}

  * output: the weather datas of the given city

4. GET <host:>8070/aggregate/city/BUDAPEST/time?fromDate=<yyyy-mm-dd>&fromTime=<hh:mm:ss>&toDate=<optional_paramater>&toTime=<optional_paramater>

  * _output:_ data of the given period in the given city

  > NOTE: toDate and toTime are optional
