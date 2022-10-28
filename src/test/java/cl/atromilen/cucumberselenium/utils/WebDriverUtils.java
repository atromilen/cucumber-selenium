package cl.atromilen.cucumberselenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtils {
    private static WebDriverUtils webDriverUtils;
    private static WebDriver driver;

    public WebDriverUtils() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        if (webDriverUtils == null){
            setupDriver();
        }
        return driver;
    }

    public static void setupDriver(){
        if (webDriverUtils == null){
            webDriverUtils = new WebDriverUtils();
        }
    }

    public static void tearDown(){
        if (driver != null){
            driver.close();
            driver.quit();
        }

        webDriverUtils = null;
    }

    /*
    * General actions
    * */
    public static void openPage(String url){
        getDriver().get(url);
    }

    public static String getWindowTitle(){
        return getDriver().getTitle();
    }
}
