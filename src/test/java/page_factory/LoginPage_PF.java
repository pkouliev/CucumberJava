package page_factory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class LoginPage_PF {

    @FindBy(id = "name")
    @CacheLookup
    WebElement txt_username;

    @FindBy(id = "password")
    @CacheLookup
    WebElement txt_password;

    @FindBy(id = "login")
    @CacheLookup
    WebElement btn_login;

    @FindBy(partialLinkText = "parvin")
    List<WebElement> myLinks;

    @FindBy(how = How.ID, using = "name")
    WebElement abc;

    WebDriver driver;

    public LoginPage_PF(WebDriver driver) {
        this.driver = driver;

//        PageFactory.initElements(driver, this);
        // PageFactory.initElements(driver, LoginPage_PF.class);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);

//        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
//        PageFactory.initElements(factory, this);
    }

    public void enterUsername(String username) {
        txt_username.sendKeys(username);
    }

    public void enterPassword(String password) {
        txt_password.sendKeys(password);
    }

    public void clickOnLogin() {
        btn_login.click();
    }
}
