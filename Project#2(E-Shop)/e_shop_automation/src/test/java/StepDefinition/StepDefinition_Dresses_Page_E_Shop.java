package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageobjects.Dresses_Page_E_Shop;

import java.util.concurrent.TimeUnit;

public class StepDefinition_Dresses_Page_E_Shop {
    private WebDriver driver;
    Dresses_Page_E_Shop dresses_page_e_shop;
    public StepDefinition_Dresses_Page_E_Shop(TestContext testContext)
    {
        driver = testContext.getDriver();
        dresses_page_e_shop = new Dresses_Page_E_Shop(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Given("^User Navigate to Dresses page\\.$")
    public void userNavigateToDressesPage() {
        dresses_page_e_shop.Click_Dresses_Link_Button();
    }

    @And("^Select first Random dresses\\.$")
    public void selectFirstRandomDresses() {
        dresses_page_e_shop.Hover_Dress1();
        dresses_page_e_shop.Click_Add_To_Cart_Dress1();
        dresses_page_e_shop.Click_Continue_To_Shopping();
    }

    @And("^Select second Random dresses\\.$")
    public void selectSecondRandomDresses() {
        dresses_page_e_shop.Hover_Dress2();
        dresses_page_e_shop.Click_Add_To_Cart_Dress2();
    }

    @And("^Proceed to checkout\\.$")
    public void proceedToCheckout() {
        dresses_page_e_shop.Click_Proceed_To_Checkout();
    }
}
