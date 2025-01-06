  @tag
  Feature: Error Validations
  @tag1
  Scenario Outline: Title of your scenario outline
     Given I landed on Ecommerce page
     When Logged in with username "<name>" and password "<password>"
    Then "Incorrect email or password." message is displayed 

Examples: 
      | name                | password        |
      | speedgsg1@gmail.com | AXqNjfBkuBjC   | 
