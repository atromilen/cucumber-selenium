package cl.atromilen.cucumberselenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.lang.NonNull;

public class SearchPage extends PageObject{

    @FindBy(className = "lighter")
    private WebElement resultingSearchTitle;

    @FindBy(className = "heading-counter")
    private WebElement resultsFound;

    public boolean articlePageIsDisplayed(@NonNull String article){
        var title = resultingSearchTitle.getText();
        var expected = String.format("\"%s\"", article.toUpperCase());

        return title != null && title.equals(expected);
    }

    public String getResultsFound(){
        return resultsFound.getText();
    }
}
