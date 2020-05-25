package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_ZB {
    WebDriver driver;
    //Locators=======================================
    @FindBy(id = "user_login")
    WebElement loginInputLine;
    @FindBy(id = "user_password")
    WebElement passwordInputLine;
    @FindBy(name = "submit")
    WebElement signInButton;
    //===============================================
    public Login_Page_ZB(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void Login_Input_Line(String loginInput)
    {
        //loginInputLine.click();
        loginInputLine.clear();
        loginInputLine.sendKeys(loginInput);
    }
    public void Password_Input_Line(String passwordInput)
    {
        //passwordInputLine.click();
        passwordInputLine.clear();
        passwordInputLine.sendKeys(passwordInput);
    }
    public void click_Sign_In_Button()
    {
        signInButton.click();
    }
    public void Full_Log_In(String LOGIN, String PASSWORD)
    {
        Login_Input_Line(LOGIN);
        Password_Input_Line(PASSWORD);
        click_Sign_In_Button();
    }
}
