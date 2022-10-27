package cl.atromilen.cucumberselenium.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SearchSteps {

    private static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Given("the user is in the index page")
    public void theUserIsInIndexPage(){
        driver.get("http://automationpractice.com/index.php");
        String title = driver.getTitle();

        Assert.assertEquals("My Store", title);
    }

    @When("the user type dresses in the search bar")
    public void theUserTypeDressesInTheSearchBar(){
        driver.findElement(By.id("search_query_top")).sendKeys("dresses");
    }

    @When("the user clicks the search button")
    public void theUserClicksTheButtonSearch(){
        driver.findElement(By.name("submit_search")).click();
    }

    @Then("the dresses page appears")
    public void theDressesPageAppears(){
        var title =driver.findElement(By.className("lighter")).getText();
        Assert.assertEquals(title.toUpperCase(), "\"DRESSES\"");
    }

}
