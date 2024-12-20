# Selenium Java Automation Project

## Project Overview
This is an automation project using Selenium, Java, Maven, and ExtentReports. The project is designed to automate web application testing with the following features:
- **ExtentReports** for clear and graphical test results.
- **Screenshot capture** on test failure.
- **Data-Driven Framework** for login functionality with both valid and invalid data using TestNG and Excel files.
- **Log4j** integration for logging detailed test descriptions.
- **TestNG XML** to run the test cases.
- **Page Object Model (POM)** to maintain elements and locators.
- **Configuration files** like `config.properties` and **Excel connection code** for managing data.
- **Selenium Grid** integration for parallel execution across multiple devices without the need for physical devices via Docker integration using YAML files.


### **Details of the Folders and Files**
- **pom/**: Contains the Page Object Model (POM) classes where all web elements like Xpath, ID, and Name are defined.
- **base/**: Contains the base class for handling browser connections, OS connections, and Selenium Grid integration.
- **utils/**: Contains utility classes such as:
  - **Data Driven Framework** for reading data from Excel files.
  - **ExtentReports** integration for test reports.
  - **Log4j** for logging test execution details.
- **config/**: Stores configuration files like `config.properties` and Selenium Grid configurations.
- **tests/**: Contains the actual test cases for various functionalities. Each test is divided by functionality, and test data is read from Excel or `config.properties`.
- **reports/**: Stores generated test reports from TestNG and ExtentReports.

## Setup Instructions
Follow these steps to set up and run the project:

### Step 1: Create a Maven Project
1. Create a new Maven project using your IDE (e.g., IntelliJ, Eclipse).
2. Add the necessary dependencies to your `pom.xml` file, including Selenium, TestNG, ExtentReports, Log4j, and any other libraries you need.

### Step 2: Create Required Folders and Packages
Create the following folder structure:

1. **POM Package**:
   - Include all element locators (XPaths, IDs, names).
   - Each page of the application should have a corresponding POM class with its elements.

2. **Test Base Package**:
   - Include classes for browser connection, configuration properties, Selenium Grid, and operating system connections.
   - This class will initialize the browser, handle the driver setup, and include other configuration details.

3. **Test Cases Package**:
   - Create test case classes for each page or functionality (e.g., login, form submission).
   - These test cases should not have hardcoded values; use data-driven approach (Excel files, config properties).

4. **Utilities Class**:
   - **Data Driven Code**: For reading data from Excel files and using them in the test cases.
   - **ExtentReport Code**: For generating detailed and graphical test reports.
   - **Log4j**: For logging detailed information about test execution.

### Step 3: Add Test Data and Configurations
1. Add **test data** to an Excel sheet for login test cases and other input fields.
2. Add configuration details in `config.properties`, such as browser type, grid configuration, and other environment details.

### Step 4: Run Tests Using TestNG
1. **Create TestNG XML**:
   - Use the TestNG XML file to define the test suite, including test classes and parameters.

2. **Run Tests**:
   - Execute tests via **TestNG** or **Maven**:
     ```bash
     mvn test
     ```
   - Alternatively, you can run the tests using the TestNG XML configuration.

### Step 5: Docker Integration (Optional)
To run tests on multiple devices using Selenium Grid:
1. Configure **Docker** containers and set up Selenium Grid in the `docker-compose.yml` or related YAML files.
2. Set up the remote WebDriver in your test base class to run the tests on the grid.

## Sample Code
Here is a basic example of how to run a login test case using the Data-Driven Framework:

```java
@Test(dataProvider = "loginData")
public void testLogin(String username, String password) {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.example.com/login");

    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
    loginPage.clickLoginButton();

    String actualTitle = driver.getTitle();
    Assert.assertTrue(actualTitle.contains("Dashboard"));
    driver.quit();
}

@DataProvider(name = "loginData")
public Object[][] getData() {
    return new ExcelReader().getTestData("loginTestData.xlsx", "Sheet1");
}
Log4j Configuration Example
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
    <appender name="console" class="org.apache.log4j.ConsoleAppender">
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%d{ISO8601} [%t] %-5p %c - %m%n"/>
        </layout>
    </appender>

    <root>
        <level value="debug"/>
        <appender-ref ref="console"/>
    </root>
</log4j:configuration>






