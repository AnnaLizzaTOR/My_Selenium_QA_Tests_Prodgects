package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Random;

public class Pay_Bills_ZB extends Main_PageZB{
    WebDriver driver;
    Random random;
    //Locators==For==Menu====================
    @FindBy(linkText = "Pay Saved Payee")
    WebElement pay_Saved_Payee_Link;
    @FindBy(linkText = "Add New Payee")
    WebElement add_New_Payee_Link;
    //=======================================
    //Locators==For==(Pay Saved Payee)==Link=
    @FindBy(id = "sp_payee")
    WebElement payee_Select_Line;
    @FindBy(id = "sp_account")
    WebElement account_Select_Line;
    @FindBy(id = "sp_amount")
    WebElement amount_Input_Line;
    @FindBy(id = "sp_date")
    WebElement date_Select_Line;
    @FindBy(id = "sp_description")
    WebElement description_Input_Line;
    @FindBy(id = "pay_saved_payees")
    WebElement pay_Button;
    @FindBy(id = "alert_content")
    WebElement checking_Message_For_Pay_Saved_Payee;
    //=======================================
    //Locators==For==(Add New Payee)==Link===
    @FindBy(id = "np_new_payee_name")
    WebElement payee_Name_Input_Line;
    @FindBy(id = "np_new_payee_address")
    WebElement payee_Address_Input_Line;
    @FindBy(id = "np_new_payee_account")
    WebElement account_Input_Line;
    @FindBy(id = "np_new_payee_details")
    WebElement payee_Details_Input_Line;
    @FindBy(id = "add_new_payee")
    WebElement add_New_Payee_Click_Button;
    @FindBy(id = "alert_content")
    WebElement checking_Message_For_Add_New_Payee;
    //=======================================
    //Some Variables=========================
    String name_Fore_Verification_Message;
    //=======================================

    public Pay_Bills_ZB(WebDriver driver) {
        super(driver);
        this.driver = driver;
        random = new Random();
        PageFactory.initElements(driver, this);
    }
    //START Functions for Pay Saved Payee========================================
    public void Menu_Click_Pay_Saved_Payee_Link()
    {
        pay_Saved_Payee_Link.click();
    }
    public void Payee_Random_Select_Line()
    {
        payee_Select_Line.click();
        Select Payee_Line_Select = new Select(payee_Select_Line);
        int rand_Size = Payee_Line_Select.getOptions().size();
        int rand_index = random.nextInt(rand_Size);
        Payee_Line_Select.selectByIndex(rand_index);
    }
    public void Account_Random_Select_Line()
    {
        account_Select_Line.click();
        Select Account_Line_Select = new Select(account_Select_Line);
        int rand_Size = Account_Line_Select.getOptions().size();
        int rand_index = random.nextInt(rand_Size);
        Account_Line_Select.selectByIndex(rand_index);
    }
    public void Amount_Random_Input_Line_UP_to(int UP_to)
    {
        int random_Amount = random.nextInt(UP_to);
        amount_Input_Line.click();
        amount_Input_Line.clear();
        amount_Input_Line.sendKeys(""+random_Amount);
    }
    public void Date_Select_Line(String date)   //Change for random select!!!
    {
        //date_Select_Line.clear();
        date_Select_Line.sendKeys(date);
        date_Select_Line.submit();
    }
    public void Description_Input_Line(String description)
    {
        description_Input_Line.click();
        description_Input_Line.clear();
        description_Input_Line.sendKeys(description);
    }
    public void Click_Pay_Button()
    {
        pay_Button.click();
    }
    public String Checking_Message_For_Pay_Saved_Payee()
    {
        String message = checking_Message_For_Pay_Saved_Payee.getText();
        return message;
    }
    public void Verification_Message_For_Pay_Saved_Payee()
    {
        String message = Checking_Message_For_Pay_Saved_Payee();
        String assert_Message = "The payment was successfully submitted.";
        Assert.assertEquals(message, assert_Message);
    }
    //END OF Functions for Pay Saved Payee===================================
    //=======================================================================
    //START Functions for Add New Payee======================================
    public void Menu_Click_Add_New_Payee_Link()
    {
        add_New_Payee_Link.click();
    }
    public void Payee_Name_Line_Input(String Payee_Name)
    {
        payee_Name_Input_Line.click();
        payee_Name_Input_Line.clear();
        payee_Name_Input_Line.sendKeys(Payee_Name);
        name_Fore_Verification_Message = Payee_Name;
    }
    public void Payee_Address_Input_Line(String Payee_Address_Input)
    {
        payee_Address_Input_Line.click();
        payee_Address_Input_Line.clear();
        payee_Address_Input_Line.sendKeys(Payee_Address_Input);
    }
    public void Account_Input_Line(String AccountInput)
    {
        account_Input_Line.click();
        account_Input_Line.clear();
        account_Input_Line.sendKeys(AccountInput);
    }
    public void Payee_Details_Input_Line(String DetailsInput)
    {
        payee_Details_Input_Line.click();
        payee_Details_Input_Line.clear();
        payee_Details_Input_Line.sendKeys(DetailsInput);
    }
    public  void Click_Button_Add_New_Payee()
    {
        add_New_Payee_Click_Button.click();
    }
    public String Checking_Message_For_Add_New_Payee()
    {
        String message = checking_Message_For_Add_New_Payee.getText();
        return message;
    }
    public void Verification_Message_For_Add_New_Payee()
    {
        String checking_Message = Checking_Message_For_Add_New_Payee();
        String assert_Message = "The new payee "+name_Fore_Verification_Message+" was successfully created.";
        Assert.assertEquals(checking_Message, assert_Message);
    }
}