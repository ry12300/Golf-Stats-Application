# Golfstats Application

Application that shows a user the most important stats related to their golf game.

# Building and Run using Docker

Please follow the below instructions to run the GolfStats Application using docker-compose:

1. Clone the application: https://github.com/ry12300/golfStats.git
2. Navigate to the root directory containing build.gradle
3. run: "gradle clean build" and check that \build\libs\golfstats-0.0.1-SNAPSHOT.jar is present
4. run: "docker build -t golfstats ."
5. run: "docker-compose up -d"

# Testing

Below are sample REST requests for the application.

The Postman collection can be imported using file: Golfstats.postman_collection.json

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

