# ClientWebservice

## Description

This is a client webservice for the Server [Webshop](https://github.com/clarabrorson/WebShopService)
 
It's a Spring Boot application that uses Spring Security to authenticate users and OAuth2 to authorize them. 
The application is connected to a MySQL database and uses Spring Data JPA to access the data. The application is also connected to the ServerWebservice: Webshop to get the data from the database.
The application features secure user registration and login functionality, and allows users to browse through products, add them to their shopping cart and place orders.


## Table of Contents

- [Installation](#installation)
- [Functionality](#functionality)
- [Usage](#usage)
- [Dependencies](#dependencies)
- [Credits](#credits)


## Functionality
### User functionality
- **All users can:**
  - Browse through articles.
  - Register an account.
  - Login to their account.
  
- **Logged-in users can:**
  - Browse through articles, add them to their shopping cart and place orders.
  - See their order history.
  

### Admin functionality
- **Admins users can:** 
  - Do everything a regular user can do.
  - Create, read, update and delete articles.
  - See all historic shopping carts.
  - See all users.
  - can buy products.
  
## Installation

+ Download and install IntelliJ IDEA or your preferred IDE [Here](https://www.jetbrains.com/idea/download/?section=windows).
+ Clone this repository and [WebShopService](https://github.com/clarabrorson/WebShopService)
to your local machine.

## Usage

### Backend - WebShopService
### 1. Set up the MySQL database:
- Open MySQL Workbench.
- Connect to your MySQL server.
- Create a new schema for the application. You can do this by clicking on the "Create a new schema in the connected server" button, entering a name for the schema, and clicking "Apply".
- Ensure that the *schema name*, *username*, and *password* in the application.properties file match your MySQL setup.

### 2. Start the WebShopService application:
- Open your IDE and run the WebShopServiceApplication class to start the application.
  
### Client Application - ClientWebService
### 3. Start the client application:
- Open your IDE and run the Main class to start the application.
- Follow the instructions in the console to use the web-shop.


## Dependencies:

- [jackson-core](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core)
- [jackson-annotations](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations)
- [httpclient5](https://mvnrepository.com/artifact/org.apache.httpcomponents.client5/httpclient5)
- [jackson-databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)


## Credits

### Collaborators in this project:
* [Clara Brorson](https://github.com/clarabrorson)
* [Fredrik Rinstad](https://github.com/Fringston)
* [Jafar Hussein](https://github.com/Jafar-Hussein)

## Badges
![badmath](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)
![badmath](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![badmath](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![badmath](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

