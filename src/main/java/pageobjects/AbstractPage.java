package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    private WebDriver driver;
    protected static final String URL = "http://rozetka.com.ua";

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public void visit() {
        driver.get(URL);
    }

    public boolean checkPageUrlContainsText(String text) {
        return driver.getCurrentUrl().contains(text);
    }
}
