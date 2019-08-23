package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.DriverHelper;

public class Hook {

    @Before
    public static void initializeTest(){

        DriverHelper.initializeDriver();
    }

    @After
    public static void endTest(){
        DriverHelper.closeDriver();
    }
}
