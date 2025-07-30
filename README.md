# Hamcrest Demo

A Java project demonstrating the use of [Hamcrest](http://hamcrest.org/) matchers, including custom matcher implementations, matcher debugging, and error message construction. The project uses Maven for build management and JUnit 5 for testing.

## Project Structure

## Features

- **Custom Matchers:**
    - Email validation matcher
    - Regex matcher
    - Lambda-based matcher
    - Divisibility matcher with English error messages
    - Logging-enabled matchers for debugging

- **JUnit 5 Tests:**
    - Tests for built-in and custom Hamcrest matchers
    - Error message validation
    - Matcher debugging and logging

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.x

### Build and Test

To build the project and run all tests:

```sh
mvn clean test

Test reports are generated in target/surefire-reports/.


Usage
See the test classes in src/test/java/ for examples of using Hamcrest matchers and writing custom matchers.


License
This project is for educational/demo purposes.