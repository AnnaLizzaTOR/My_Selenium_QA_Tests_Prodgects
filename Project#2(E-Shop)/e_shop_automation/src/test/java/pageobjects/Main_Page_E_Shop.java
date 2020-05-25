package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Main_Page_E_Shop {
    WebDriver driver;
    //Locators===========================================
    @FindBy(className = "logout")
    WebElement logOutButton;
    @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
    WebElement dressesLinkButton;
    //===================================================
    public Main_Page_E_Shop(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void Click_LogOut_Button()
    {
        logOutButton.click();
    }
    public void Click_Dresses_Link_Button()
    {
        dressesLinkButton.click();
    }
}
