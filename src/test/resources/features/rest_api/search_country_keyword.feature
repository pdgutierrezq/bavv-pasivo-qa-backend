# Google Feature
@version:Release-2
@component:API
Feature: Rest test
  brief description

  @TAG1 @TAG2 @issue:ETSY-101
  Scenario: search Country US
    Given the URL 'http://api.worldbank.org/v2/country/us?format=json'
    When I check the application status
    Then the API should contains 'United States of America'


  Scenario: search Country IN
    Given the URL 'http://api.worldbank.org/v2/country/in?format=json'
    When I check the application status
    Then the API should contains 'India'

  Scenario: search Country CO
    Given the user want to Colombia URL
    When I check the application status
    Then the API should contains 'Colombia'
