# Logisticks-Online Merchandise Delivery

## Spring Boot Java Project with SQL and Frontend

This project is a simple merchandise delivery platform, which delivers product from one location to another. The delivery of the items are taken care by the agent.
The project can also be viewed here [GitHub](https://github.com/CSS301P-2023-06/logisticks.git)

## Prerequisites

Before running this project, make sure you have the following software installed:

- [Java](https://www.java.com/en/download/)
- [Gradle](https://gradle.org/install/)
- [Node.js](https://nodejs.org/en/download/)
- [npm](https://www.npmjs.com/get-npm)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

You also need a running SQL database to use with the project. This project is set up to use MySQL, but you can use any database supported by Spring Boot by modifying the application properties file.

## Creating MySQL database
1. Open MySQL in your local computer
2. Copy the contents of `backend/src/main/resources/create.sql`
3. Paste it onto MySQL to create database logisticks with relevant tables needed to run the project
4. The application properties file is located in `backend/src/main/resources/application.properties`. This file contains the configuration settings for the application. You can modify these settings to use your local database by changing the username and password for execution of the project

## Running the Backend

1. Make sure you have IntelliJ IDEA installed on your machine.
2. Open the project folder in the IDE.
3. Navigate to `backend/src/test/java/com/example/logisticksApplicationTests.java` and click on the "Run" button that appears on the Navigation Bar of the IDE.
4. The backend should now be running on `http://localhost:8080`.

## Running the Frontend

1. Open a new terminal or command prompt window.
2. Navigate to the `frontend` folder of the project.
3. Install the required dependencies by running the following command:
    npm install
4. Run the frontend by running the following command:
    npm run dev

5. The frontend should now be running on `http://localhost:5173`.

## Accessing the Application

You can access the application by opening your web browser and navigating to `http://localhost:5173`. This will display the frontend of the application. The frontend interacts with the backend by making API requests to `http://localhost:8080`.




