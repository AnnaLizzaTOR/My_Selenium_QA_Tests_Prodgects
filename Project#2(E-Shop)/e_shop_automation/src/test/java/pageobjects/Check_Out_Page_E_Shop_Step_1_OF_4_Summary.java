package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Check_Out_Page_E_Shop_Step_1_OF_4_Summary {
    WebDriver driver;
    //Locators=====================================================
    @FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")
    WebElement Continue_To_CheckOut_Button;
    //========================================================
    public Check_Out_Page_E_Shop_Step_1_OF_4_Summary(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void Click_Continue_To_CheckOut_Button()
    {
        Continue_To_CheckOut_Button.click();
    }
}
