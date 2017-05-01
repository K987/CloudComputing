1. build the image: docker build -t <name_of_the_image> .
2. start a redis container: docker run --detach --publish 6379:6379 --name redis redis
3. run a container: docker run --detach --name <name_of_the_container> --link redis:redis -p 8080:8080 <name_of_the_image>

NOTE: if container is deleted the content of the DB will be lost.

Provided services:

POST <host>:8080/login
  description: provides an access token for the given user credentials
  input:
      {
        "userName" : "<name_of_the_user>", 
        "userPassword" : "<userPassword>"
      }
  
  output
    if user validated:
      {
        "userName" : "<name_of_the_user>",
        "token" : "<token>",
        "validTo" : <token_validity_ends>
      }
      
      NOTE: at current stage of implementation acceptable user and password is (Kalman pwd123)
      NOTE: at current stage token is askljkfds123242
      NOTE: at current stage token doesn't expire
