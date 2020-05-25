package StepDefinition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobjects.Pay_Bills_ZB;

import java.util.concurrent.TimeUnit;

public class Pay_Bills_ZB_StepDefinition_Pay_Saved_Payee {
    WebDriver driver;
    Pay_Bills_ZB pay_bills_zb;

    public Pay_Bills_ZB_StepDefinition_Pay_Saved_Payee(TestContext testContext)
    {
        driver = testContext.getDriver();
        pay_bills_zb = new Pay_Bills_ZB(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Given("^User navigate to section Pay Bills\\.$")
    public void userNavigateToSectionPayBills() {
        pay_bills_zb.Pay_Bills_Click();
    }
    @And("^User navigate to section Pay Saved Payee\\.$")
    public void userNavigateToSectionPaySavedPayee() {
        pay_bills_zb.Menu_Click_Pay_Saved_Payee_Link();
    }

    @And("^Payee Line Random Select\\.$")
    public void payeeLineRandomSelect() {
        pay_bills_zb.Payee_Random_Select_Line();
    }

    @And("^Account Line Random Select\\.$")
    public void accountLineRandomSelect() {
        pay_bills_zb.Account_Random_Select_Line();
    }

    @And("^Amount Line Random Input_Pay Saved Payee\\.$")
    public void amountLineRandomInput_PaySavedPayee() {
        pay_bills_zb.Amount_Random_Input_Line_UP_to(2000);
    }

    @And("^Date Line Random Input\\.$")
    public void dateLineRandomInput() {
        pay_bills_zb.Date_Select_Line("2020-04-01");
    }

    @And("^Description Line Random Input_Pay Saved Payee\\.$")
    public void descriptionLineRandomInput_PaySavedPayee() {
        pay_bills_zb.Description_Input_Line("Test Description Imput");
    }

    @And("^Click Pay Button\\.$")
    public void clickPayButton() {
        pay_bills_zb.Click_Pay_Button();
    }

    @Then("^Verification Message Of Successfully Payment Form\\.$")
    public void verificationMessageOfSuccessfullyPaymentForm() {
        pay_bills_zb.Verification_Message_For_Pay_Saved_Payee();
    }
}
