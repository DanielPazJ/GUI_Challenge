Feature: Login


  Scenario: Successful sign in
    Given  I am in the Falabella homepage
    When I sign in with valid credentials
    Then I should be signed in

  Scenario: Invalid sign in
    Given I am in the Falabella homepage
    When I sign in with invalid credentials
    Then I should see a sign in error

  Scenario: Successful sign out
    Given I am signed in the Falabella page
    When I sign out
    Then I should be signed out



