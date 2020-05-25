package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_E_Shop
{
    WebDriver driver;
    //Locators==============================================
    @FindBy(id = "email")
    WebElement loginInputLine;
    @FindBy(id = "passwd")
    WebElement passwordInputLine;
    @FindBy(id = "SubmitLogin")
    WebElement submitLoginButton;
    //======================================================

    public Login_Page_E_Shop(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void Login_Input_Line(String login)
    {
        loginInputLine.click();
        loginInputLine.clear();
        loginInputLine.sendKeys(login);
    }
    public void Password_Input_Line(String password)
    {
        passwordInputLine.click();
        passwordInputLine.clear();
        passwordInputLine.sendKeys(password);
    }
    public void Click_Submit_Login_Button()
    {
        submitLoginButton.click();
    }
    public void Full_Log_In(String LOGIN, String PASSWORD)
    {
        Login_Input_Line(LOGIN);
        Password_Input_Line(PASSWORD);
        Click_Submit_Login_Button();
    }
}
