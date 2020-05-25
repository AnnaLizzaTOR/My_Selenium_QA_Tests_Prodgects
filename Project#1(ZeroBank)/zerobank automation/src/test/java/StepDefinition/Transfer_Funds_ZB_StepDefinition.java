package StepDefinition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobjects.Login_Page_ZB;
import pageobjects.Transfer_Funds_ZB;

public class Transfer_Funds_ZB_StepDefinition {
    WebDriver driver;
    Transfer_Funds_ZB transfer_funds_zb;
    Login_Page_ZB login_page_zb;
    private static final String URL = "http://zero.webappsecurity.com/login.html";
    private String USERNAME = "username";
    private String PASSWORD = "password";

    public Transfer_Funds_ZB_StepDefinition(TestContext testContext)
    {
        driver = testContext.getDriver();
        transfer_funds_zb = new Transfer_Funds_ZB(driver);
        login_page_zb = new Login_Page_ZB(driver);
    }

    @Given("^Open Login URL Of ZeroBank$")
    public void openLoginURLOfZeroBank() {
        driver.get(URL);
    }
    @And("^LogIn To ZeroBank$")
    public void loginToZeroBank() {
        login_page_zb.Full_Log_In(USERNAME, PASSWORD);
    }
    @Given("^User navigate to section of Transfer Funds\\.$")
    public void userNavigateToSectionOfTransferFunds() {
        transfer_funds_zb.Transfer_Funds_Click();
    }
    @And("^Form Account Line Random Select\\.$")
    public void formAccountLineRandomSelect() {
        transfer_funds_zb.From_Account_Random_Select();
    }
    @And("^To Account Line Random Select\\.$")
    public void toAccountLineRandomSelect() {
        transfer_funds_zb.To_Account_Random_Select();
    }

    @And("^Amount Line Random Input\\.$")
    public void amountLineRandomInput() {
        transfer_funds_zb.Amount_Random_Input_UP_to(2000);
    }

    @And("^Description Line Random Input\\.$")
    public void descriptionLineRandomInput() {
        transfer_funds_zb.Description_Input("Test Description Input");
    }

    @And("^Click Continue Button\\.$")
    public void clickContinueButton() {
        transfer_funds_zb.Click_Continue_Button();
    }

    @And("^Assert All Line Information\\.$")
    public void assertAllLineInformation() {
        transfer_funds_zb.All_Input_Verification();
    }

    @And("^Click Submit Button\\.$")
    public void clickSubmitButton() {
        transfer_funds_zb.Click_Submit_Button();
    }

    @Then("^Verification Message Of Successfully Submitted Form\\.$")
    public void verificationMessageOfSuccessfullySubmittedForm() {
        transfer_funds_zb.Verification_Massage();
    }
}
