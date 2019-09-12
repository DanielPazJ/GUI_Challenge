package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.DriverFactory;

public class Hook {

    @Before
    public void initializeTest(){
        DriverFactory.getDriver();
    }

    @After
    public void endTest(){
        DriverFactory.quitDriver();
    }
}
