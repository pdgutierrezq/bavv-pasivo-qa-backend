# Basic Arithmetic Feature
@version:Release-any
@component:Junit
Feature: Basic Arithmetic
   Calculing additions

  @issue:ISSUE-456 @TAG1
  Scenario: Addition
    Given the user want to add
    When the number a '5'
    When the number b '5'
    Then they should see '10'

  @TAG2
  Scenario: Subtraction
    Given the user want to less
    When the number a '5'
    When the number b '5'
    Then they should see '0'

  @issue:ISSUE-456 @TAG1
  Scenario: Addition 2
    Given the user want to add
    When the number a '123'
    When the number b '5'
    Then they should see '128'
