Feature: Logout

  Scenario: Successful Logout
    Given I am in the Falabella homepage
    When I login with credentials
      | Fields   | Values                    |
      | Email    | challengecorreo@gmail.com |
      | Password | clavechallenge            |
    And I logout
    Then I should see in the homepage the message "Inicia sesión"