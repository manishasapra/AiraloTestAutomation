# Airalo Test Automation Framework (Selenium)

This repository contains the automation framework to perform testing on `airalo` web and api application.

---

# Tech Stack

###  Reason to choose the below tech stack :
Primary reason was to use Selenium in order to automate the `airalo` application. I also have hands-on experience on the below technologies.

- Java 20+
- Maven 3.8+
- TestNG
- Selenium 4
- Lombok
- Extent Reports
- RestAssured

---
## Setup Instructions

- Prerequisite 
      - Provide URL, default values for the web app and api in `env.properties`.

- Clone the repository
  <pre>git clone https://github.com/manishasapra/AiraloTestAutomation</pre>
- Change directory to the cloned repository
  <pre>cd AiraloTestAutomation</pre>

### Run Locally :

- Prerequisites
  <pre>Ensure Java 20+ is installed.<br/>Install Maven (version 3.8+ recommended)</pre>
- Export secrets
  ```bash
   export CLIENT_KEY="<client_secret>"
   export CLIENT_SECRET="<client_secret>"
- Run with testng
  <pre>mvn test -Dsurefire.suiteXmlFiles=test-suite.xml</pre>

---
## Framework Highlights

### Scalability :
The framework is designed in such a way that it can easily be scaled to write mobile app test cases with very minium change.

### Maintainability :
This framework is very easy to maintain as all the dependencies are at one place also `DataProviders` are being used which makes the case independent to run on any kind of data.
