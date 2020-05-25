package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Random;

public class Transfer_Funds_ZB extends Main_PageZB {

    WebDriver driver;
    Random random;

    //Locators================================
    @FindBy(id = "tf_fromAccountId")
    WebElement from_Account_Select_Line;
    @FindBy(id = "tf_toAccountId")
    WebElement to_Account_Select_Line;
    @FindBy(id = "tf_amount")
    WebElement amount_Input_Line;
    @FindBy(id = "tf_description")
    WebElement description_Input_Line;
    @FindBy(id = "btn_submit")
    WebElement continue_AND_Submit_Button;
    @FindBy(css = "#transfer_funds_content > div > div > div.alert.alert-success")
    WebElement checking_Message;
    //========================================
    //Some Variables==========================
    String saveOptionForVerification_From_Account;
    String saveOptionForVerification_To_Account;
    String saveOptionForVerification_Amount;
    String saveOptionForVerification_Description;
    //========================================

    public Transfer_Funds_ZB(WebDriver driver) {
        super(driver);
        this.driver = driver;
        random = new Random();
        PageFactory.initElements(driver, this);
    }

    public void From_Account_Random_Select() {
        from_Account_Select_Line.click();
        Select from_Account = new Select(from_Account_Select_Line);
        int select_Size = from_Account.getOptions().size();
        int random_Index = random.nextInt(select_Size);
        from_Account.selectByIndex(random_Index);
        String saveOptionForVerification = Cud_String_Method(from_Account.getFirstSelectedOption().getText());
        saveOptionForVerification_From_Account = saveOptionForVerification.trim();
    }

    public void To_Account_Random_Select() {
        to_Account_Select_Line.click();
        Select to_Account = new Select(to_Account_Select_Line);
        int select_Size = to_Account.getOptions().size();
        int random_Index = random.nextInt(select_Size);
        to_Account.selectByIndex(random_Index);
        String saveOptionForVerification = Cud_String_Method(to_Account.getFirstSelectedOption().getText());
        saveOptionForVerification_To_Account = saveOptionForVerification.trim();
    }

    public void Amount_Random_Input_UP_to(int UP_to) {
        amount_Input_Line.click();
        amount_Input_Line.clear();
        int random_amount = random.nextInt(UP_to);
        amount_Input_Line.sendKeys("" + random_amount);
        saveOptionForVerification_Amount = "" + random_amount;
//        amount_Input_Line.sendKeys(UP_to);
//        saveOptionForVerification_Amount = UP_to;
    }

    public void Description_Input(String descriptionInput) {
        description_Input_Line.click();
        description_Input_Line.clear();
        description_Input_Line.sendKeys(descriptionInput);
        saveOptionForVerification_Description = descriptionInput;
    }

    public void Click_Continue_Button() {
        continue_AND_Submit_Button.click();
    }

    public void Click_Submit_Button() {
        continue_AND_Submit_Button.click();
    }

    public String Checking_Message() {
        String message = checking_Message.getText();
        return message;
    }

    public void Verification_Massage() {
        String checking_Message = Checking_Message();
        String assert_Message = "You successfully submitted your transaction.";
        Assert.assertEquals(checking_Message, assert_Message);
    }


    public void All_Input_Verification() {
        Assert.assertEquals(saveOptionForVerification_From_Account, from_Account_Select_Line.getAttribute("value").trim());
        Assert.assertEquals(saveOptionForVerification_To_Account, to_Account_Select_Line.getAttribute("value").trim());
        Assert.assertEquals(saveOptionForVerification_Amount, amount_Input_Line.getAttribute("value").trim());
        Assert.assertEquals(saveOptionForVerification_Description, description_Input_Line.getAttribute("value").trim());
    }

    private String Cud_String_Method(String forCheck)
    {
        char x='0';
        String reSave = "";
        int i = 0;
        while (x != '(')
        {
            char oneLether = forCheck.charAt(i);
            i++;
            if (oneLether != '(')
            reSave = reSave + oneLether;
            else break;
            x = oneLether;
        }
//        for (int z = 0; z<=forCheck.length(); z++)
//        {
//            char one_Letter = forCheck.charAt(z);
//            if (one_Letter != '(')
//                reSave = reSave+one_Letter;
//            else break;
//        }
        return reSave;
    }
}
