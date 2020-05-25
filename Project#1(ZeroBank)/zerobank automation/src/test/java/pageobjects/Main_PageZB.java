package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Main_PageZB {
    WebDriver driver;
    //Locators====================================
    @FindBy(linkText = "Transfer Funds")
    WebElement transfer_Funds;
    @FindBy(linkText = "Pay Bills")
    WebElement pay_Bills;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div/ul/li[3]") //Do not work with other locators(Full xPath Only)! Why?
    WebElement user_Name_Menu_Dropdown_Open;
    @FindBy(id = "logout_link")
    WebElement logout_link;
    //============================================
    public Main_PageZB(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void Transfer_Funds_Click()
    {
        transfer_Funds.click();
    }
    public void Pay_Bills_Click()
    {
        pay_Bills.click();
    }
    private void User_Name_Menu_Dropdown_Open()
    {
        user_Name_Menu_Dropdown_Open.click();
    }
    private void Logout_Link_Click()
    {
        logout_link.click();
    }
    public void Full_Log_Out()
    {
        User_Name_Menu_Dropdown_Open();
        Logout_Link_Click();
    }
}
