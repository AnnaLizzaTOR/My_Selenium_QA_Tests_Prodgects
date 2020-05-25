package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobjects.Pay_Bills_ZB;

import java.util.concurrent.TimeUnit;

public class Pay_Bills_ZB_StepDefinition_Add_New_Payee {
    WebDriver driver;
    Pay_Bills_ZB pay_bills_zb;

    public Pay_Bills_ZB_StepDefinition_Add_New_Payee(TestContext testContext)
    {
        driver = testContext.getDriver();
        pay_bills_zb = new Pay_Bills_ZB(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @And("^User navigate to section Add New Payee\\.$")
    public void userNavigateToSectionAddNewPayee() {
        pay_bills_zb.Menu_Click_Add_New_Payee_Link();
    }

    @And("^Payee Name Line Input\\.$")
    public void payeeNameLineInput() {
        pay_bills_zb.Payee_Name_Line_Input("David");
    }

    @And("^Payee Address Line Input\\.$")
    public void payeeAddressLineInput() {
        pay_bills_zb.Payee_Address_Input_Line("2200 W Street");
    }

    @And("^Account Line Input\\.$")
    public void accountLineInput() {
        pay_bills_zb.Account_Input_Line("23236457674534");
    }

    @And("^Payee Details Line Input\\.$")
    public void payeeDetailsLineInput() {
        pay_bills_zb.Payee_Details_Input_Line("Test details");
    }

    @And("^Click Add Payee Button\\.$")
    public void clickAddPayeeButton() {
        pay_bills_zb.Click_Button_Add_New_Payee();
    }

    @Then("^Verification Message Of Successfully created new payee\\.$")
    public void verificationMessageOfSuccessfullyCreatedNewPayee() {
        pay_bills_zb.Verification_Message_For_Add_New_Payee();
    }
}
