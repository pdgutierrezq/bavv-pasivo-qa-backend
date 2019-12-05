# devops-pipeline-qa-serenity-example

[![gradle](https://img.shields.io/badge/gradle-v4.9.X-yellow.svg)](https://gradle.org/install/)
[![maven](https://img.shields.io/badge/maven-v3.6.X-red.svg)](https://maven.apache.org/)


>A simple Gradle & Maven project to test ADL DevOps Java Serenity &&  Cucumbert  Pipelines. `:wq`
>
>Developed with all :heart: in the world by ADL DevOps team

## Prerequisites

You will need the following things properly installed on your computer.

* [Git](http://git-scm.com/)
* [Gradle](https://gradle.org)
* [Maven](https://maven.apache.org/)


## Installation

We use [Gradle](http://www.gradle.org), a cross-platform build automation tool that help with our full development flow. 
If you prefer [install Gradle](http://www.gradle.org/installation) or use a [Gradle wrapper](http://www.gradle.org/docs/current/userguide/gradle_wrapper.html) inside this project.

* ´git clone https://github.com/avaldigitallabs/devops-pipeline-qa-example.git` this repository
* change into the new directory `cd devops-pipeline-qa-example`

##  Executing the tests

the parameter **-Denvironment** can to take values like: 

   * dev
   - stg
   + pro
   
By default, the tests will run using Chrome.

```bash
./gradlew clean test aggregate -Denvironment=pro
```
Or 
```bash
 mvn clean verify -Denvironment=stg 
```

with other webdriver

```bash
 mvn clean verify -Denvironment=stg  -Dwebdriver.driver=firefox
```
The test results will be recorded in the `target/site/serenity` directory.

## Simplified WebDriver configuration and other Serenity extras
The sample projects both use some Serenity features which make configuring the tests easier. In particular, Serenity uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.  

### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments. Here, we configure three environments, __dev__, _stg_ and _pro_, with different starting URLs for each:
```json
environments {
  default {
    webdriver.base.url = "https://duckduckgo.com"
  }
  dev {
    webdriver.base.url = "https://duckduckgo.com/dev"
  }
  stg {
    webdriver.base.url = "https://duckduckgo.com/staging"
  }
  pro {
    webdriver.base.url = "https://duckduckgo.com/prod"
  }
}
```
  
You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```json
$ mvn clean verify -Denvironment=stg
```

### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main                                  | Source main
  + test                                  |
    + java                                | Test runners and supporting code
    + com.avaldigitallabs.layer           | Package base
      + features                          | Features set
        + {feature_name}                  | Feature name
          + pages                         | Pages use with webdriver test
          + steps                         | Utility class for definition steps
        + {feature_name}Definition.java   | Definition class 
      + model                             | DTOs, Pojos, VOs, etc ...
      + utils                             | General utility class
      + RunnerTestSuite.java              | Main class
    + resources                           |
      + features                          | Feature files
          + {feature_name}                 | Feature file  specific
             {feature_name}.feature        |
      + serenity.conf                     | Config file for Serenity
serenity.properties                       | General properties Serenity
```


## Intall webdrive local

```bash
brew tap homebrew/cask && brew cask install chromedriver

```

## Want to learn more?
For more information about Serenity BDD, you can read the [**Serenity BDD Book**](https://serenity-bdd.github.io/theserenitybook/latest/index.html), the official online Serenity documentation source. Other sources include:
* **[Byte-sized Serenity BDD](https://www.youtube.com/channel/UCav6-dPEUiLbnu-rgpy7_bw/featured)** - tips and tricks about Serenity BDD
* [**Serenity BDD Blog**](https://johnfergusonsmart.com/category/serenity-bdd/) - regular articles about Serenity BDD
* [**The Serenity BDD Dojo**](https://serenitydojo.teachable.com) - Online training on Serenity BDD and on test automation and BDD in general. 
