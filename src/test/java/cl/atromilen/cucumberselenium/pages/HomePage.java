package cl.atromilen.cucumberselenium.pages;

import cl.atromilen.cucumberselenium.utils.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{

    @FindBy(id = "search_query_top")
    private WebElement searchBar;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    public String WindowTitle(){
        WebDriverUtils.openPage("http://automationpractice.com/index.php");
        return WebDriverUtils.getWindowTitle();
    }

    public void enterSearch(String article){
        searchBar.sendKeys(article);
    }

    public void clickSearch(){
        searchButton.click();
    }

}
