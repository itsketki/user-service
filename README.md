# User Service

The project is a microservice to manage user details through REST APIs.

## Requirements
For building and running the application you need:
- JDK 1.8
- Maven 3

## Running the application locally

1. Import the project to your favorite IDE.
2. To start application: Run as Spring Boot App.

## Usage

To call the APIs, execute the provided Postman collection.
Sample Get User Details API Request curl command -

curl --location --request GET 'http://localhost:8080/api/userdetails/5'

curl --location --request PUT 'http://localhost:8080/api/updateuser/5' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 5,
    "firstName": "Liza",
    "lastName": "Taylor",
    "title": "Ms",
    "gender": "female",
    "address": {
        "id": 3,
        "street": "Pitt st",
        "city": "Perth",
        "state": "WA",
        "postCode": 2000
    }
}'
