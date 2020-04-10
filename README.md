# Golfstats Application

Application that shows a user the most important stats related to their golf game.

# Pre-requisites 

As a pre-requisite to running the Golfstats application please ensure the following:

1. Docker is installed on your local machine : https://docs.docker.com/get-docker/
2. MongoDB Compass is installed (optional) : https://www.mongodb.com/download-center/compass?tck=docs_compass

# Building and Run using Docker

Please follow the below instructions to run the GolfStats Application using docker-compose:

1. Clone the application: `git clone https://github.com/ry12300/golfStats.git`
2. Navigate to the root directory container dockerfile and docker-compose.yml
4. run: `docker build -t golfstats .`
5. run: `docker-compose up -d`

# Testing

Below are sample REST requests for the application.

The Postman collection can be imported using file: `Golfstats.postman_collection.json`

**Get all Rounds**

GET http://localhost:8080/rounds

**Create a Round**

POST http://localhost:8080/rounds 

`{
    "userId": "user5",
    "course": "pinehurst",
    "date": "20-01-2020",
    "score": 95,
    "fairwayPercentage": 19,
    "greenPercentage": 22,
    "numberOfPutts": 38,
    "notes": null
}`

**Get Specific Round**

GET http://localhost:8080/rounds/User2

**Delete a Round**

DELETE http://localhost:8080/rounds/5e39e7814a37fe3a8c31ff63

