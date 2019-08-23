Feature: Login

  Background:
    Given I am in the Falabella homepage

  Scenario: Successful login
    When I login with valid credentials
    Then I should be logged in

  Scenario: Unsuccesful login
    When I login with invalid email and password credentials
    Then I should see a login error message




