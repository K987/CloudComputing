1. build the image: `docker build -t <name_of_the_image> .``
2. run a container: `docker run --detach --name <name_of_the_container> -p 5432:5432 <name_of_the_image>`
3. get the IP address of current docker machine: `docker-machine ip`
4. connect to the DB via pgAdmin or psql CLI: `<machine_ip>:5432 user:wt_crud_user password:pwd1234`
---
> NOTE: in aws you need to use the IP of the EC2 instance. Alternatively you can skip this and use Amazon RDS.

> NOTE: if container is deleted the content of the DB will be lost.
