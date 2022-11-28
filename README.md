# RestAssuredFramework

This project has a RestAssured based API testing framework. Underlying, it uses RestAssured -API testing library, TestNG - Third-party free library for Running tests, and for Reporting, Extent Reports (library for interactive and detailed reports for tests). This framework can be used for any Restful application to create API tests.


# Contents

##	Framework Details
####	. Base API
####	. Framework - What and Why?
####  . Project structure
####	. Properties


##  Installation
#### o	Steps to follow to setup API automation in local system

## Framework Details

### Base API
I have used Almosafer API as a basis for the API test framework.

### Framework - What and Why?
This Test Automation Framework is created using Java + Junit + Cucumber + RestAssured + ExtentReports, which can be used across different api based applications. With this framework in place, whenever we need to automate API's, we would not need to start from scratch, and begin with developing the test cases straight away.

### Project structure
This project uses a standard Maven Java project with standard java folder structure and POM.xml

### Properties
src/test/resources/config/common.properties is a simple common properties file to store various constants like application URL, token etc...

### FeatureFiles Location
src/test/java/org/api/automation/features
### StepDefs Location
src/test/java/org/api/automation/step_defs
### Test Runner
src/main/java/org/api/automation/runner/TestRunner.java

## Installation
#### Steps to follow to setup API automation in local system:
#### Install Java: [Skip this step if already installed]
#### •	Check if Java is installed.
#### o	In terminal enter java -version to check if java is installed in the system.
#### o	In terminal enter javac -version to check if java compiler is installed in the system.
#### o	Any version of java greater than 1.8 is supported.
#### o	Install java development kit if not available.

### Install Eclipse / Any other latest IDE [Skip this step if already installed]:
#### •	Install eclipse photon if not available.
#### o	Download eclipse installer.
#### o	Run eclipse installer.
#### o	Select install eclipse for java developers.
#### o	Open workbench.

## Get Code base:
#### •	Clone restassuredFramework
#### 	url : https://github.com/ejajahamadqa/RestAssuredFramework.git







