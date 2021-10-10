Ruangguru QA Test
# Ruangguru QA Test 1

This project contains the solution to the QA test given to Aditya Jonany on October 10th 2021

## How to set up the project
1. Pull this project into your local
2. Open this project in your IDE
3. Import the POM dependencies if required

## How to run the whole feature test
This will run the whole scenarios
1. run ```mvn test``` command on the terminal. If you're using IntelliJ, you need to click ```CTRL + ENTER``` instead of just ```ENTER```
2. Wait until you see "BUILD SUCCESS" in the console output
3. There are 2 HTML reporters that you can use to see the results
    - in the console output, search for "View your Cucumber Report at:" and then click on the link bellow that text
    - go to target/reports/report.html

## How to run specific scenarios in the feature file
Lets say you only want to run the scenario to test the get API
1. First, pick your scenario of choice from the src/test/java/features/gorestUsersAPITests.feature file
2. look at the tag above with the "@" symbol
3. Then go to the TestRunner class
4. Update CucumberOptions Add the "tag" field under "plugin" field and include your choice. For example, if you want to run only @CurrentTest scenario, then update it like this:
  ```
  @CucumberOptions(
        features="src/test/java/features",
        glue={"stepDefs"},
        plugin={"html:target/reports/report.html"},
        tags = "@CurrentTest"
)
```
