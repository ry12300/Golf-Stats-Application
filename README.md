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

Get all Rounds

GET http://localhost:8080/rounds

Create a Round

POST http://localhost:8080/rounds 

{
    "userId": "user5",
    "course": "pinehurst",
    "date": "20-01-2020",
    "score": 95,
    "fairwayPercentage": 19,
    "greenPercentage": 22,
    "numberOfPutts": 38,
    "notes": null
}

Get Specific Round

GET http://localhost:8080/rounds/User2

Delete a Round

DELETE http://localhost:8080/rounds/5e39e7814a37fe3a8c31ff63

