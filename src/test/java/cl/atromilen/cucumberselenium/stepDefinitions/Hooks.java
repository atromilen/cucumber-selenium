package cl.atromilen.cucumberselenium.stepDefinitions;

import cl.atromilen.cucumberselenium.utils.WebDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public static void setup(){
        WebDriverUtils.setupDriver();
    }

    @After
    public static void tearDown(Scenario scenario){
        WebDriverUtils.tearDown();
    }
}
