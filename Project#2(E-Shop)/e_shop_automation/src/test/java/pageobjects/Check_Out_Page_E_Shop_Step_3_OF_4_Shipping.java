package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Check_Out_Page_E_Shop_Step_3_OF_4_Shipping {
    WebDriver driver;
    //Locators========================================================
    @FindBy(id = "cgv")
    WebElement check_Box_Agree;
    @FindBy(css = "#form > p > button")
    WebElement proceed_to_CheckOut;

    //================================================================
    public Check_Out_Page_E_Shop_Step_3_OF_4_Shipping(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void Select_Check_Box_Agree() {
        boolean select = check_Box_Agree.isSelected();
        if (!select)
            check_Box_Agree.click();
    }
    public void Click_Proceed_To_CheckOut_Button()
    {
        proceed_to_CheckOut.click();
    }
}
