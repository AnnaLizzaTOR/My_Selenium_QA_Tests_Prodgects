package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Check_Out_Page_E_Shop_Step_4_OF_4_Payment {
    WebDriver driver;
    //Locators=============================================
    @FindBy(css = "#total_price")
    WebElement total_prise;
    @FindBy(css = "#HOOK_PAYMENT > div:nth-child(2) > div > p > a")
    WebElement pay_Buy_Check_Click;
    //After Click 1=======================================
    @FindBy(css = "#cart_navigation > button")
    WebElement Confirm_My_Order_Button;
    //After Click 2========================================
    @FindBy(css = "#center_column > p.alert.alert-success")
    WebElement Confirmation_Message;
    @FindBy(css = "#center_column > p.cart_navigation.exclusive > a")
    WebElement Back_To_Orders_Button;
    //=====================================================
    //Some Varebles========================================
    String SaveTotalPrice;
    //=====================================================
    public Check_Out_Page_E_Shop_Step_4_OF_4_Payment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String SaveTotalPrise()
    {
        String totalPrice = total_prise.getText();
        SaveTotalPrice = totalPrice;
        return totalPrice;
    }
    public void Click_Pay_Buy_Check_Link()
    {
        pay_Buy_Check_Click.click();
    }
    public void Click_Confirm_My_Order_Button()
    {
        Confirm_My_Order_Button.click();
    }
    public void Verification_Confirm_Message()
    {
        String message = Confirmation_Message.getText();
        String assertionMessage = "Your order on My Store is complete.";
        Assert.assertEquals(message, assertionMessage);
    }
    public void Click_Back_To_Orders_Button()
    {
        Back_To_Orders_Button.click();
    }
}
