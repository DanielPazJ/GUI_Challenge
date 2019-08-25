package steps.filter;

import cucumber.api.java.en.Then;
import helpers.DriverHelper;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AssertFilterSteps {

    private WebDriver driver;
    private SearchPage searchPage;

    public AssertFilterSteps (){
        this.driver = DriverHelper.driver;
        this.searchPage = new SearchPage(driver);
    }

    @Then("I should see just products between {double} and {double}")
    public void iShouldSeeJustProductsBetweenAnd(double priceFrom, double priceEnd) {
        assertThat("Wrong price",searchPage.verifyPriceList(priceFrom,priceEnd),equalTo(true));
    }
}
