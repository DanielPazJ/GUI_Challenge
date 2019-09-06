Feature: Shopping Cart

  Background:
    Given I am in the Falabella homepage
    And I search for audifonos
    And I select a product to go to it is page
    When I add the product to the cart

  Scenario: See the confirmation message in the pop up
    Then I should see a pop up with the confirmation message: Agregado

  Scenario: Delete  a product of the shopping cart
    Given I am in the shopping cart page
    When I delete the product
    Then I should that my cart is empty by the message: Tu Bolsa de Compras está vacía. Agrega productos ahora
