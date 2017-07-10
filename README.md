# CloudComputing

Docker mini projects for Amazon ECS play-around

## docker_authentication

node.js authentication service over redis DB

## docker_persistence

Sring boot DAO layer and REST interface for db CRUD
uses: docker_database

## docker_database

PostgreSql database for persistence

## docker_cqrs

Spring boot application produces input data and frequently aggregates observations
uses: docker_database

## launch order in docker:
  1. docker_authentication
  2. docker_database (in dev env, in prod use Amazon RDS postgres)
  3. docker_persistence
  4. docker_cqrs
