
#Welcome


**#For set up environment do the following steps:**
- Install java JDK 1.8 in your system and configurate global JAVA_HOME variable, on Mac execute command in terminal
```
brew cask install java
```
- Install Maven 3 in your system and configurate global MAVEN_HOME variable, on Mac:
```
brew install maven
```
- Download project to your machine

**#For running tests via command line do the following:**
- Open terminal, navigate to project's directory, execute command 
```
mvn clean install test
```

Report will be added to {project directory}/target/surefire-reports 

**#To get TestNg report:**

- Navigate to {project directory}/target/surefire-reports/Regression tests/Regression UI tests .html and open this one in browser


**#To get Allure report:**

- after tests will be finished execute:

```
mvn site
```

- Then navigate to {project directory}/target/site/allure-maven-plugin.html and open this one in browser


