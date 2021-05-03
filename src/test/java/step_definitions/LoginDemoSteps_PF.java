package step_definitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import page_factory.HomePage_PF;
import page_factory.LoginPage_PF;

import java.util.concurrent.*;

public class LoginDemoSteps_PF {

    WebDriver driver = null;
    LoginPage_PF login;
    HomePage_PF home;

    @Given("browser is open")
    public void browser_is_open() {

        System.out.println(" === I am inside LoginDemoSteps_PF class === ");

        System.out.println("Inside Step - browser is open");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @And("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("Inside Step - user is on login page");
        driver.navigate().to("https://example.testproject.io/web/");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() throws InterruptedException {
        System.out.println("Inside Step - user enters username and password");
        driver.findElement(By.id("name")).sendKeys("Parvin");
        driver.findElement(By.id("password")).sendKeys("12345");

        Thread.sleep(2000);
    }

    @When("^user enters (.*) and (.*)$")
    public void user_enters_and(String username, String password) throws InterruptedException {
        System.out.println("Inside Step - user enters username and password");

        login = new LoginPage_PF(driver);

        login.enterUsername(username);
        login.enterPassword(password);

//        driver.findElement(By.id("name")).sendKeys(username);
//        driver.findElement(By.id("password")).sendKeys(password);

        Thread.sleep(2000);
    }

    @When("user clicks on login")
    public void user_clicks_on_login() {
        System.out.println("Inside Step - user clicks on login");

        login.clickOnLogin();
        //driver.findElement(By.id("login")).click();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() throws InterruptedException {
        System.out.println("Inside Step - user is navigated to the home page");

        home = new HomePage_PF(driver);

        home.checkLogoutIsDisplayed();
        //driver.findElement(By.id("logout")).isDisplayed();

        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
