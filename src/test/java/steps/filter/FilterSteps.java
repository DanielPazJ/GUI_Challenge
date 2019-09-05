package steps.filter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.SearchPage;
import steps.Hook;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class FilterSteps {

    private HomePage homePage;
    private SearchPage searchPage;

    public FilterSteps() {
        this.homePage = new HomePage(Hook.driver);
        this.searchPage = new SearchPage(Hook.driver);
    }

    @And("I search for ([^\"]*)")
    public void iSearchFor(String product) {
        homePage.searchProduct(product);
    }

    @When("I apply the filter for ([^\"]*) between ([^\"]*) and ([^\"]*)")
    public void iApplyTheFilterForPriceBetweenAnd(String filterType,String filterFrom, String filterTo) {
        String range = "$"+filterFrom+" - "+"$"+filterTo;
        searchPage.priceFilter(filterType, range);
    }
    @Then("I should see just products between {double} and {double}")
    public void iShouldSeeJustProductsBetweenAnd(double priceFrom, double priceEnd) {
        assertThat("Wrong price",searchPage.verifyPriceList(priceFrom,priceEnd),equalTo(true));
    }

}
