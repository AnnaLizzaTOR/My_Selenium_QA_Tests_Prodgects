package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageobjects.Login_Page_E_Shop;

import java.util.concurrent.TimeUnit;

public class StepDefinition_Login_Page_E_Shop {
    private WebDriver driver;
    Login_Page_E_Shop login_page_e_shop;
    private static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    String user_Name = "KJHKJHKG644545KJJH4jhfkkh@gmail.com";
    String user_Password = "567r3dfgh";
    public StepDefinition_Login_Page_E_Shop(TestContext testContext)
    {
        driver = testContext.getDriver();
        login_page_e_shop = new Login_Page_E_Shop(driver);
    }
    @Given("^Open Login URL Of E-Shop$")
    public void openLoginURLOfEShop() {
        driver.get(URL);
    }

    @And("^LogIn To E-Shop$")
    public void loginToEShop() {
        login_page_e_shop.Full_Log_In(user_Name, user_Password);
    }
}
