# Reminder API

"Forget" about your worries. Reminder API is going to take care of reminding you
about them.

### Running Locally

Java: This project has been built using Java 14:
    
    > java --version
    openjdk 14.0.2 2020-07-14
    OpenJDK Runtime Environment (build 14.0.2+12-46)
    OpenJDK 64-Bit Server VM (build 14.0.2+12-46, mixed mode, sharing)

Maven: to obtain a `.jar` out of the code. Run this command.

    mvn clean package

*Note: don't forget to set the JAVA_HOME variable in Maven to point
to Java version 14 or above.

Start the application.

    java -jar target/reminder-api-<version-number>.jar
    
The application runs at `localhost:8080`

### Dependencies

This application sends the reminder messages with the help
of Twilio API. The required Twilio properties that are needed
to be set can be found in the `twilio.properties` file located
at `src/main/resources/twilio.properties`.

Right now the file contains the following:

    ACCOUNT_SID=
    AUTH_TOKEN=
    SENDING_PHONE_NO=

Those are the three parameters that need to be set before
actually being able to send a reminder. More details about 
registering an account and a phone number using Twilio's
API can be found [here](https://www.twilio.com/docs/usage/tutorials/how-to-use-your-free-trial-account).

### Application endpoint

#### Posting a new reminder

Endpoint
    
    /reminders
    
CURL command

    curl --location --request POST 'localhost:8080/reminders' ^
    --header 'Content-Type: application/json' ^
    --data-raw '{
        "name": "Pick up laundry",
        "description": "Pick up laundry from the nearby laundry shop on Cornwall Rd. SX2 UO23",
        "dueDate": <future date in this format> "2020-08-30T13:29:00.0000+03:00",
        "receiverPhoneNumber": <phone-number>
    }'
