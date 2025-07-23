# Simple Email Service (Spring Boot + AWS SES)

This project is a simple REST API for sending emails using AWS Simple Email Service (SES) and Spring Boot.

## Features

- Exposes a POST endpoint to send emails.
- Uses AWS SES as the email provider.
- Clean architecture with separation of concerns.

## How it works

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

## Project Structure

- `controllers/` - REST controllers (HTTP endpoints)
- `application/` - Application services (business logic)
- `adapters/` - Abstractions for external services (gateways)
- `infrastructure/ses/` - AWS SES implementation of the email gateway
- `configuration/` - Spring beans and AWS SES client configuration
- `core/` - Domain models and exceptions

## AWS Credentials

This service expects AWS credentials and region to be set as environment variables:

- `AWS_ACCESS_KEY_ID`
- `AWS_SECRET_ACCESS_KEY`
- `AWS_REGION`

## Running

1. Set the required AWS environment variables.
2. Build and run the application:
    ```sh
    ./mvnw spring-boot:run
    ```
3. Send a POST request to `http://localhost:8080/api/email` as shown above.

##