Feature: Registration

  Scenario: Invalid registration
    Given I am in the Falabella homepage
    When I try to register with the information
      | Fields           | Values         |
      | First Name       | Diana          |
      | Father Last Name | Hernandez      |
      | Mother Last Name | Hernandez      |
      | Email Address    | test@gmail.com |
      | Password         | Test1234       |
      | Confirm Password | Test1234       |
      | ID Number        | 1015896457     |
      | Gender           | Female         |
      | Birthday date    | 5/05/1995      |
      | Cellphone        |                |
    And I try to save my data
    Then I should see an error message that says: Debes ingresar un celular