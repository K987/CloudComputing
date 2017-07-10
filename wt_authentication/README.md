1. build the image: `docker build -t <name_of_the_image> .`
2. start a redis container: `docker run --detach --publish 6379:6379 --name redis redis`
3. run a container: `docker run --detach --name <name_of_the_container> --link redis:redis -p 8080:8080 <name_of_the_image>`

> NOTE: if container is deleted the content of the DB will be lost.

---

# Provided services:

1. POST <host>:8080/login

  * description: provides an access token for the given user credentials

  * _input:_
```javascript
{
  "userName" : "<name_of_the_user>",
  "userPassword" : "<userPassword>"
}
```
  * _output:_

    * if user validated (status code : 200):
```javascript
{
  "userName" : "<name_of_the_user>",
  "token" : "<token>",
  "validTo" : <token_validity_ends>
}
```
    * if user not validated (status code : 403)
```javascript
{
  "status" : 403,
  "message" : "wrong username or password"
}
```

2. POST <host>:8080/register

  * description: registers a new user

  * _input:_
```javascript
{
  "userName" : "<name_of_the_user>",
  "userPassword" : "<userPassword>"
}
```
  * _output:_

    * if user registered (status code : 204) - no content
