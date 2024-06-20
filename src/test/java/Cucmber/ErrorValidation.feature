
@tag
Feature: Error Validation
  I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce Page
  
  @tag1
  Scenario: Title of your scenario
    Given I landed on Ecommerce Page
  
    When Logged in the username <username> and password <password>
    
    Then "Incorrect email or password." message is displayed

    Examples: 
      | username  | password | productName  |
      | putty@gmail.com |     Password134 | ZARA COAT 3 |
