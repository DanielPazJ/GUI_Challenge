Feature: Filter

  Scenario: Filter the price
    Given I am in the Falabella homepage
    And I search for cremas
    When I apply the filter for price between 5.000 and 20.000
    Then I should see just products between 5.000 and 20.000
