package step_definitions;

import Helpers.ProductDetailsPageHelper;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.MainPage;
import pageobjects.ProductDetailsPage;

public class SearchStepDefs {

    private WebDriver driver;
    private MainPage mainPage;
    private ProductDetailsPage productDetailsPage;
    private ProductDetailsPageHelper productDetailsPageHelper;

    @Before
    public void setUp() {
        driver = new ChromeDriver();

        mainPage = new MainPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPageHelper = new ProductDetailsPageHelper(driver);
    }

    @Given("^I am on the Main page$")
    public void iAmOnBasePage() {
        mainPage.visit();
    }

    @When("^I search for a product by article number \"([^\"]*)\"$")
    public void iSearchForAProductByArticleNumber(String articleNumber) {
        mainPage.executeSearch(articleNumber);
        Assert.assertTrue("Product details page is not open! \n",
                mainPage.checkPageUrlContainsText(articleNumber));
    }

    @Then("^I see number of reviews for this product is \"([^\"]*)\" and number of stars is \"([^\"]*)\"$")
    public void iSeeLettersInTheRightPartSortedInDescendingOrder(String numberOfReviews, String numberOfStars) {
        StringBuilder error = new StringBuilder();
        if (!productDetailsPage.getNumberOfReviews().equals(numberOfReviews)) {
            error.append("Number of reviews is not as expected! \n");
        }
        if (!productDetailsPageHelper.isNumberOfStarsAsExpected(numberOfStars)) {
            error.append("Number of stars is not as expected! \n");
        }
        Assert.assertTrue(error.toString(), error.toString().isEmpty());
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

}
