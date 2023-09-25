@demo
Feature: SignInFeature
  This feature deals with signin functionality of the application
  Scenario Outline: SignIn with correct username and password using XPATH
    Given I navigate to the signin page
    And I click the signin button
    And I enter the "<name>" "<email>" and "<password>"
    And I click the signup button
    Then I should see the homepage
    Examples:
      | name      | email                           | password  |
      | Khushboo  | khushboo.srivastava2@kpmg.co.uk | Test123   |
  Scenario Outline: SignIn with correct username and password using ID
    Given I navigate to the signin page
    And I click the signin button
    And I enter the "<name>" "<email>" and "<password>" using ID
    And I click the signup button
    Then I should see the homepage
    Examples:
      | name      | email                           | password  |
      | Khushboo  | khushboo.srivastava2@kpmg.co.uk | Test123   |


