Feature: Logout

Background:
  Given I am in the Falabella homepage
  And I login with valid credentials
  And I should be logged in

  Scenario: Successful Logout
    When I click logout
    Then I should be signed out