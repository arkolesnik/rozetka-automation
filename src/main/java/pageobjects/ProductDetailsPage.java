package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPage extends AbstractPage {

    @FindBy(className = "g-rating-reviews-link-medium")
    private WebElement linkReviews;

    @FindBy(className = "g-rating-stars-i-medium")
    private WebElement iconStars;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getNumberOfReviews() {
        String linkText = $(linkReviews).getText();
        return linkText.replaceAll("[^0-9]", "");
    }

    public String getStarsStyleAttribute() {
        return $(iconStars).getAttribute("style");
    }


}


