package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class FilterSteps {

    private SearchPage searchPage;

    public FilterSteps() {
        this.searchPage = new SearchPage();
    }

    @When("I apply the filter for price between ([^\"]*) and ([^\"]*)")
    public void iApplyTheFilterForPriceBetweenAnd(String filterFrom, String filterTo) {
        String range = "$"+filterFrom+" - "+"$"+filterTo;
        searchPage.priceFilter(range);
    }
    @Then("I should see just products between {double} and {double}")
    public void iShouldSeeJustProductsBetweenAnd(double priceFrom, double priceEnd) {
        assertThat("Wrong price",searchPage.isPartOfPriceList(priceFrom,priceEnd),equalTo(true));
    }

}
