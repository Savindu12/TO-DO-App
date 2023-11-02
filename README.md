# Task Management Application with Angular and Spring Boot, MySQL

This repository contains an Angular front-end, a Spring Boot back-end, and MySQL database setup for a task-management application.

## Prerequisites

Before you begin, ensure you have the following installed:

- Node.js and npm (Node Package Manager)
- Angular CLI
- Java Development Kit (JDK)
- Spring Tool Suite or any IDE for Spring Boot
- MySQL Server

## Setup Instructions

### 1. Setting Up the MySQL Database

- Install and configure MySQL.
- Create a database using the provided SQL script or manually.

### 2. Running the Spring Boot Backend

1. Open the `taskmanagementApp-backend` directory in your Java IDE (Eclipse) or Sprint Tool 4.
2. Update the `application.properties` file in the `src/main/resources` folder with your MySQL database credentials.

## properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_management_app
spring.datasource.username=root
spring.datasource.password=root

Build and run the Spring Boot application.

### 3. Running the Angular Frontend
Open a terminal and navigate to the task-management-app-frontend directory.
Install the necessary dependencies using npm install.
After the installation is complete, start the Angular application by running ng serve or ng serve -o

