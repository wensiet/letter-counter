# Letter counter

### Prerequisites

- Java 8+
- Maven

### How to install
1. Clone the repository to your machine
```bash
git clone https://github.com/wensiet/letter-counter.git
```
2. Build the project
```bash
mvn clean install
```

3. Run the App
```bash
java -jar target/letter-count-api-0.0.1-SNAPSHOT.jar
```


Now the app is running, you can access it on http://localhost:8080

### Tests

Run the tests using Maven
```bash
mvn test
```
Then you will see the test-cases result

### Endpoints
- **Endpoint** `/count-letters/{inputString}`
- **Method** `GET`
- **Description** `Counts unique letter occurrences`
- **Example** If we want to count letters in word `aaaaabcccc`, then we need to make a GET request to http://localhost:8080/count-letters/aaaaabcccc
  ```bash 
  curl http://localhost:8080/count-letters/aaaaabcccc
  ```
  Response:
  ```json
  {
    "a": 5,
    "c": 4,
    "b": 1
  }
  ```
