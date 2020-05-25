package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Check_Out_Page_E_Shop_Step_2_OF_4_Address {
    WebDriver driver;
    //Locators=====================================================
   @FindBy(name = "processAddress")
   WebElement proceed_To_CheckOut_Button;
    //START=Delivery Address Information Locators========================
    @FindBy(css = "#address_delivery > li.address_firstname.address_lastname")
    WebElement DELIVERY_ADDRESS_Name;
    @FindBy(css = "#address_delivery > li.address_company")
    WebElement DELIVERY_ADDRESS_Comp;
    @FindBy(css = "#address_delivery > li.address_address1.address_address2")
    WebElement DELIVERY_ADDRESS_Street;
    @FindBy(css = "#address_delivery > li.address_city.address_state_name.address_postcode")
    WebElement DELIVERY_ADDRESS_city;
    //END===Delivery Address Information Locators========================
    //START=Billing Address Information Locators=========================
    @FindBy(css = "#address_invoice > li.address_firstname.address_lastname")
    WebElement BILLING_ADDRESS_Name;
    @FindBy(css = "#address_invoice > li.address_company")
    WebElement BILLING_ADDRESS_Comp;
    @FindBy(css = "#address_invoice > li.address_address1.address_address2")
    WebElement BILLING_ADDRESS_Street;
    @FindBy(css = "#address_invoice > li.address_city.address_state_name.address_postcode")
    WebElement BILLING_ADDRESS_city;
    //END===Billing Address Information Locators=========================
    //=============================================================
    public Check_Out_Page_E_Shop_Step_2_OF_4_Address(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void Assertion_Delivery_And_Billing_Address()
    {
        Assert.assertEquals(DELIVERY_ADDRESS_Name.getText(), BILLING_ADDRESS_Name.getText());
        Assert.assertEquals(DELIVERY_ADDRESS_Comp.getText(), BILLING_ADDRESS_Comp.getText());
        Assert.assertEquals(DELIVERY_ADDRESS_Street.getText(), BILLING_ADDRESS_Street.getText());
        Assert.assertEquals(DELIVERY_ADDRESS_city.getText(), BILLING_ADDRESS_city.getText());
    }
    public void Click_Proceed_To_CheckOut_Button()
    {
        proceed_To_CheckOut_Button.click();
    }
}
