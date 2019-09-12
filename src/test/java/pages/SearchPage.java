package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(className = "fb-filter-bar")
    private WebElement filterBox;

    @FindBy(xpath = "//*[@class='fb-price-list']//*[@class='fb-price']")
    private WebElement productPrices;

    private By productList = By.className("section__pod-top");
    private By priceListInternet = By.xpath("//*[@class='fb-price-list']//p[contains(text(),'(Internet)')]");

    public SearchPage() {
        super();
    }

    public void priceFilter(String filterType, String range) {
        searchFilter(filterType, "//*[@class='fb-filter_container']");
        searchFilter(range, "//*[@class='content-text-verticalFilter']");
    }

    private void searchFilter(String filterType, String xpath) {
        driverHelper.waitForVisibility(filterBox, 10);
        List<WebElement> filters = driver.findElements(By.xpath(xpath));
        WebElement filterSelected = null;
        int i = 0;
        while (i < filters.size()) {
            if (filters.get(i).getText().contains(filterType)) {
                filterSelected = filters.get(i);
                i++;
            } else {
                i++;
            }
        }
        if (filterSelected != null) {
            filterSelected.click();
        }
    }

    public boolean verifyPriceList (double from, double to){
        List<WebElement> pricesList = driver.findElements(priceListInternet);
        int i = 0;
        boolean response = true;
        while (response && i < pricesList.size()) {
            double price = Double.valueOf(pricesList.get(i)
                    .getText().split(" ")[1]);
            if ( from > price|| price > to) {
                response = false;
            } else {
                i++;
            }
        }
        return response;
    }

    public void selectProduct (){
        List<WebElement> productsList = driver.findElements(productList);
        int productNumber = (int)(Math.random() * productsList.size()+1);
        productsList.get(productNumber).click();
    }
}