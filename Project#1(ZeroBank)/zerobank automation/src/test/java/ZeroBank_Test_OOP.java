import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import pageobjects.Login_Page_ZB;
import pageobjects.Main_PageZB;
import pageobjects.Pay_Bills_ZB;
import pageobjects.Transfer_Funds_ZB;
import java.util.concurrent.TimeUnit;

public class ZeroBank_Test_OOP {
    Actions actions;
    private static final String URL = "http://zero.webappsecurity.com/login.html";
    WebDriver driver;
    String user_Name = "username";
    String user_Password = "password";
    @BeforeTest
    public void Set_Property()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @BeforeMethod
    public void Log_In()
    {
        driver.get(URL);
        Login_Page_ZB login_page_zb = new Login_Page_ZB(driver);
        login_page_zb.Full_Log_In(user_Name, user_Password);
    }
    @Test(dataProvider = "moneyTransferData")
    public void Transfer_funds_Form_Test(String amount, String description) {
        Transfer_Funds_ZB transfer_funds_zb = new Transfer_Funds_ZB(driver);
        transfer_funds_zb.Transfer_Funds_Click();
        transfer_funds_zb.From_Account_Random_Select();
        transfer_funds_zb.To_Account_Random_Select();
        transfer_funds_zb.Amount_Random_Input_UP_to(2000);
        transfer_funds_zb.Description_Input(description);
        transfer_funds_zb.Click_Continue_Button();
        transfer_funds_zb.All_Input_Verification();
        transfer_funds_zb.Click_Submit_Button();
        transfer_funds_zb.Verification_Massage();
    }
    @DataProvider(name = "moneyTransferData")
    public Object[][] getDataMonyTransfer()
    {
        return new Object[][]{
                {"1000", "Test description"},
                {"500", "Description"},
                {"100.5", "Double"}
        };
    }
    @Test (dependsOnMethods = {"Transfer_funds_Form_Test"}, alwaysRun = true)
    public void Pay_Bills_Add_New_Payee_Form_Test() throws InterruptedException {
        Pay_Bills_ZB pay_bills_zb = new Pay_Bills_ZB(driver);
        pay_bills_zb.Pay_Bills_Click();
        pay_bills_zb.Menu_Click_Add_New_Payee_Link();
        pay_bills_zb.Payee_Name_Line_Input("David");
        pay_bills_zb.Payee_Address_Input_Line("4025 W Cornelia Ave Chicago IL 00000");
        pay_bills_zb.Account_Input_Line("80975342126544");
        pay_bills_zb.Payee_Details_Input_Line("Test Details");
        pay_bills_zb.Click_Button_Add_New_Payee();
        pay_bills_zb.Verification_Message_For_Add_New_Payee();
    }
    @Test(dependsOnMethods = {"Pay_Bills_Add_New_Payee_Form_Test"}, alwaysRun = true)
    public void Pay_Bills_Pay_Saved_Payee_Form_Test()
    {
        Pay_Bills_ZB pay_bills_zb = new Pay_Bills_ZB(driver);
        pay_bills_zb.Pay_Bills_Click();
        pay_bills_zb.Menu_Click_Pay_Saved_Payee_Link();
        pay_bills_zb.Payee_Random_Select_Line();
        pay_bills_zb.Account_Random_Select_Line();
        pay_bills_zb.Amount_Random_Input_Line_UP_to(2000);
        pay_bills_zb.Date_Select_Line("2020-04-17");
        pay_bills_zb.Description_Input_Line("Test Description");
        pay_bills_zb.Click_Pay_Button();
        pay_bills_zb.Verification_Message_For_Pay_Saved_Payee();
    }
    @AfterMethod
    public void Log_Out() {
        Main_PageZB main_pageZB = new Main_PageZB(driver);
        main_pageZB.Full_Log_Out();
    }
    @AfterTest
    public void Closed_Driver()
    {
        driver.quit();
    }
}
