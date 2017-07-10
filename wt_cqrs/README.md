1. build the image: docker build -t <name_of_the_image> .
2. launch docker_database container if haven't launched yet
3. run command 'gradle clean build' in ./wt_persistence_service directory
3. run a container (choose an option):

  * `docker run -e "SPRING_PROFILES_ACTIVE=hardwired" --detach --name <name_of_the_container> <name_of_the_image>`
  > all the configurations are wired in applicaton.yml:
```
  datasource:
    url: jdbc:postgresql://192.168.99.100:5432/weather_db
    username: wt_crud_user
    password: pwd123
```
---
  * `docker run -e "SPRING_PROFILES_ACTIVE=docker_env" -e "DATABASE_HOST=<ip_of_database_container>" -e "DATABASE_PORT=5432" -e "DATABASE_USER=wt_crud_user" -e "DATABASE_PASSWORD=pwd123" --detach --name <name_of_the_container>  <name_of_the_image>`

  > to find out the host of containers run 'docker-machine ip' command
  > NOTE: default values may also change!!
---
  * `docker run -e "SPRING_PROFILES_ACTIVE=docker_linked" --link <databse_container_name>:weatherDB --link  --detach --name <name_of_the_container> <name_of_the_image>`
---

# Provided services:

1. frequently inserts new observations to docker_database
2. frequently aggregates observation data
