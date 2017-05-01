1. build the image: docker build -t <name_of_the_image> .
2. launch docker_database container if haven't launched yet
3. run command 'gradle clean build' in ./wt_persistence_service directory
3. run a container (choose an option):
  
  
  a. docker run -e "SPRING_PROFILES_ACTIVE=hardwired" --detach --name <name_of_the_container> -p 8070:8080 <name_of_the_image>
    all the configurations are wired in applicaton.yml:
 
     datasource:
        url: jdbc:postgresql://192.168.99.100:5432/weather_db
        username: wt_crud_user
        password: pwd123
      authentication_service:
        url: http://192.168.99.100:8080
 
 
      b. docker run -e "SPRING_PROFILES_ACTIVE=docker_env" -e "DATABASE_HOST=<ip_of_database_container>" -e "DATABASE_PORT=5432" -e "DATABASE_USER=wt_crud_user" -e "DATABASE_PASSWORD=pwd123" -e "AUTH_SERVICE_HOST=<ip_of_autch_service_container>" -e "AUTH_SERVICE_PORT=8080"--detach --name <name_of_the_container> -p 8070:8080 <name_of_the_image>
      
    to find out the host of containers run 'docker-machine ip' command
    
    NOTE: default values may also change!!
 
 
      c. docker run -e "SPRING_PROFILES_ACTIVE=docker_linked" --link <databse_container_name>:weatherDB --link <auth_service_container_name>:authDB --detach --name <name_of_the_container> -p 8070:8080 <name_of_the_image>
  
  not yet tested

Provided services:

for every service you have to put the access token in the request header "access-token" : "Bearer <token>"

GET <host>:8070/aggregate/getById/{id}
      
      output: the weather data of the given id
      
GET <host>:8070/aggregate/{city}
     
     output: the weather datas of the given city (acceptable: DEBRECEN,BUDAPEST,SZEGED,SOPRON)
      
POST <host>:8070/aggregate/{city}
      
      input {
              "fromDate": "yyyy-mm-dd",
              "fromTime": "hh:00:00",
              "toDate": "yyyy-mm-dd",
              "toTime": "hh:00:00"
          }
      
      output: data of the given period in the given city
      
      NOTE: toDate and toTime are optional
