package helpers;

import org.openqa.selenium.WebDriver;
import pageobjects.ProductDetailsPage;

import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPageHelper {

    private ProductDetailsPage productDetailsPage;

    public ProductDetailsPageHelper(WebDriver driver) {
        productDetailsPage = new ProductDetailsPage(driver);
    }

    public boolean isNumberOfStarsAsExpected(String numberOfStars) {
        String attribute = productDetailsPage.getStarsStyleAttribute();
        switch (Integer.valueOf(numberOfStars)) {
            case 5:
                return attribute.contains("100%");
            case 4:
                return attribute.contains("80%");
            case 3:
                return attribute.contains("60%");
            case 2:
                return attribute.contains("40%");
            case 1:
                return attribute.contains("20%");
            default:
                throw new IllegalArgumentException("Number of stars should be from 1 to 5");
        }
    }
}
