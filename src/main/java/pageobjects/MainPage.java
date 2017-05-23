package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends AbstractPage {

    @FindBy(className = "rz-header-search-input-text")
    private WebElement inputSearch;

    @FindBy(css = "[name='rz-search-button']")
    private WebElement buttonSearch;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void executeSearch(String searchQuery) {
        $(inputSearch).setValue(searchQuery);
        $(buttonSearch).click();
    }

}
