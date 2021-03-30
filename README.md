# Api Test Framework

### Main libraries used:
- Rest Assured (for REST service)
- Junit 5 (run test and create assertions)
- Cucumber (run test and read gherkin syntax)
- Allure 2 (test report)

___

### Rest Assured Doc (filter created)
https://www.javadoc.io/doc/com.jayway.restassured/rest-assured/1.4/com/jayway/restassured/path/json/JsonPath.html

https://rest-assured.io/

___

### Test Data - actors.json
https://gotoqa.ru/test-data/actors.json

___

Running tests locally:
### 1 (Cucumber Runner)
mvn clean test

### 2 (Cucumber Runner)
features/Actors.feature -> choose: Run Feature (start all Scenarios)
features/Actors.feature -> choose: Run Scenario (start the single scenario)

### 3 (Junit Runner)
tests/RunCucumberTest.java -> Run RunCucumberTest
___

### Allure Report
mvn clean test

Plugins -> allure -> allure:report -> Run (Generating report)

Plugins -> allure -> allure:serve -> Run (Starting localhost web server)

