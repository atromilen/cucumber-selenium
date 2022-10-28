package cl.atromilen.cucumberselenium.stepDefinitions;

import cl.atromilen.cucumberselenium.pages.HomePage;
import cl.atromilen.cucumberselenium.pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchDefinitions {
    private final HomePage homePage = new HomePage();
    private final SearchPage searchPage = new SearchPage();

    @Given("^the user is in the index page$")
    public void theUserIsInIndexPage(){
        assertEquals("My Store", homePage.WindowTitle());
    }

    @When("the user enters {string} in the search bar")
    public void theUserEntersArticleInTheSearchBar(String article){
        homePage.enterSearch(article);
    }

    @When("the user clicks the search button")
    public void theUserClicksTheButtonSearch(){
        homePage.clickSearch();
    }

    @Then("the {string} page appears showing {int} articles")
    public void theArticlePageAppears(String article, int results){
        assertTrue(searchPage.articlePageIsDisplayed(article));
        String expectedResults = (results == 1) ? "%s result has been found." : "%s results have been found.";
        assertEquals(searchPage.getResultsFound(), String.format(expectedResults, results));
    }

}
