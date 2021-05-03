package page_factory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class HomePage_PF {

    @FindBy(id = "logout")
    @CacheLookup
    WebElement btn_logout;

    WebDriver driver;

    public HomePage_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        // PageFactory.initElements(driver, HomePage_PF.class);
    }

    public void checkLogoutIsDisplayed() {
        btn_logout.isDisplayed();
    }
}
