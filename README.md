# GoogleJules

A simple Google search redirect application built with Spring Boot.

## Description

This application provides a simple web interface with a search bar. When you enter a query and submit, it redirects you to the Google search results for that query.

## Prerequisites

Before you begin, ensure you have the following installed:
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) version 17 or later.
- [Apache Maven](https://maven.apache.org/download.cgi)

## How to Run

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Run the application using Maven:**
   You can run the application directly using the Spring Boot Maven plugin:
   ```bash
   mvn spring-boot:run
   ```
   The application will start on the default port `8080`.

3. **Alternatively, build and run the JAR file:**
   - Package the application into a JAR file:
     ```bash
     mvn clean package
     ```
   - Run the JAR file:
     ```bash
     java -jar target/searchapp-0.0.1-SNAPSHOT.jar
     ```

## How to Use

1. Once the application is running, open your web browser and navigate to:
   ```
   http://localhost:8080
   ```

2. You will see a search page. Enter your desired search query into the input box.

3. Click the "Search" button.

4. You will be redirected to `https://www.google.com` with the search results for your query.