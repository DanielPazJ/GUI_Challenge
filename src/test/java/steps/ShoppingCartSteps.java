package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ProductPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import helpers.DriverHelper;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ShoppingCartSteps {

    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;
    private SearchPage searchPage;
    private DriverHelper driverHelper;

    public ShoppingCartSteps () {
        this.driverHelper = new DriverHelper();
        this.productPage = new ProductPage();
        this.searchPage = new SearchPage();
        this.shoppingCartPage = new ShoppingCartPage();
    }

    @Given("I am in a product page")
    public void iAmInAProductPage() throws IOException {
        driverHelper.openPage("productPage");
    }

    @And("I select a product to go to it is page")
    public void iSelectAProductToGoToItIsPage() {
        searchPage.selectRandomProduct();
    }

    @When("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        productPage.addToShoppingCart();
    }

    @Then("I should see a pop up with the confirmation message: ([^\"]*)")
    public void iShouldSeeAPopUpWithTheConfirmationMessage(String message) {
        assertThat("Wrong Message", productPage.getShoppingCartMessage(),equalTo(message));
    }

    @Given("I am in the shopping cart page")
    public void iAmInTheShoppingCartPage() throws IOException {
        driverHelper.openPage("bagPage");
    }

    @When("I delete the product")
    public void iDeleteTheProduct() {
        shoppingCartPage.deleteProduct();
    }

    @Then("I should that my cart is empty by the message: ([^\"]*)")
    public void iShouldThatMyCartIsEmptyByTheMessage(String message) {
        assertThat("Wrong Message",shoppingCartPage.getShoppingCartEmptyMessage(),equalTo(message));
    }
}
