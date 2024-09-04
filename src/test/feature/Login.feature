Feature: Login Functionality
  Background:
    Given Launching Website for testing

  Scenario:
    Given I am on login page of application
    When I enter valid user name and password
    And I click on login button
    Then I am landing on home page successfully

  Scenario: User Verify the login functionality with invalid credentials
    Given I am on login page of application
    When I enter invalid user name and password
    And I click on login button
    Then I am getting error for invalid credentials