1. build the image: docker build -t <name of the image> .
2. run a container: docker run --detach --name <name of the container> -p 5432:5432 <name of the image>
3. get the IP address of current docker machine: docker-machine ip
4. connect to the DB via pgAdmin or psql CLI: <machine_ip>:5432 user:wt_crud_user password:pwd1234


NOTE: in aws you need to use the IP of the EC2 instance

NOTE: if container is deleted the content of the DB will be lost. 
Use a permanent external  storage and set the DB PGDATA env to point to a location on the external drive when building the container

 
