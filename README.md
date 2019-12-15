# Golfstats application

Application that shows a user the most important stats related to their golf game.

# Building and running
To build and run the application:

gradle clean bootRun -To run a build and test

gradle clean build - To create a self-contained executable jar

# Docker

docker build -t golfstats . - To build docker image (run from root dir)

docker run -p 8080:8080 golfstats - To run docker container (from root dir)

# Testing

http://localhost:8080/scores/identity123 - in Browser or Postman etc