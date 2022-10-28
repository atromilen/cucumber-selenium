package cl.atromilen.cucumberselenium.pages;

import cl.atromilen.cucumberselenium.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
    protected WebDriver driver;

    public PageObject() {
        driver = WebDriverUtils.getDriver();
        PageFactory.initElements(driver, this);
    }
}
