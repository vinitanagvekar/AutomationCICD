
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
  Background: 
  Given: I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <prodname> in the cart
    And Checkout <prodname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

    Examples: 
      | name              | password   | prodname    |
      | vinitest@test.com | Test@123   | ZARA COAT 3 |
