# Simple Email Service
___

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)

## Uber Backend Challenge

This project is a simple REST API for sending emails using AWS Simple Email Service (SES) and Spring Boot.
This repository contains my solution for the [Uber Challenge - Simple Email Service](https://github.com/uber-archive/coding-challenge-tools/blob/master/coding_challenge.md).


## Table of Contents
___
- [Uber Backend Challenge](#uber-backend-challenge)
- [Features](#features)
- [How it works](#how-it-works)
- [API Endpoints](#api-endpoints)
- [AWS Credentials](#aws-credentials)
- [Running](#running)
- [Contributing](#contributing)


## Features
___
- Exposes a POST endpoint to send emails.
- Uses AWS SES as the email provider.
- Clean architecture with separation of concerns.

## How it works
___
1. Send a POST request to `/api/email` with a JSON body:
    ```json
    {
      "to": "recipient@example.com",
      "subject": "Your Subject",
      "body": "Email body text"
    }
    ```
2. The controller receives the request and delegates to the application service.
3. The application service uses a gateway to send the email.
4. The SES implementation of the gateway sends the email using AWS SES.

## AWS Credentials
___
This service expects AWS credentials and region to be set as environment variables:

- `AWS_ACCESS_KEY_ID`
- `AWS_SECRET_ACCESS_KEY`
- `AWS_REGION`

## Running
___
1. Set the required AWS environment variables.
2. Build and run the application:
    ```sh
    ./mvnw spring-boot:run
    ```
3. Send a POST request to `http://localhost:8080/api/email` as shown above.

## Contributing
___
Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.