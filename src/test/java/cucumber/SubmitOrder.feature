@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

  Background: 
    Given I landed on Ecommerce page

 @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username "<name>" and password "<password>"
    When I add the "<productName>" to cart
    And Checkout "<productName>" and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on the ConfirmationPage

    Examples: 
      | name                | password        | productName   |
      | speedgsg1@gmail.com | 6AXqNjf##BkuBjC | IPHONE 13 PRO |
