Feature: Login

  Background:
    Given I am in the Falabella homepage

  Scenario: Successful login
    When I login with credentials
      | Fields   | Values                    |
      | Email    | challengecorreo@gmail.com |
      | Password | clavechallenge            |
    Then I should see the message: Bienvenid@

  Scenario: Unsuccesful login
    When I login with credentials
      | Fields   | Values                    |
      | Email    | challengecorre@gmail.com |
      | Password | clavechalleng           |
    Then I should see a login error message that says: E-mail o clave incorrecta. Por favor inténtalo nuevamente.




