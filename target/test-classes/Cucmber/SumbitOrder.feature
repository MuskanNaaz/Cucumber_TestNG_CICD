
@tag
Feature: Purchase thr order for Ecommerce website
  I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce Page
  

  @tag2
  Scenario Outline: Positive Test od Sumbitting the order
    Given Logged in the username <username> and password <password>
    When I add the product <productName> in Cart
    And CheckOut <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage.

    Examples: 
      | username  | password | productName  |
      | putty@gmail.com |     Password1234 | ZARA COAT 3 |
      
