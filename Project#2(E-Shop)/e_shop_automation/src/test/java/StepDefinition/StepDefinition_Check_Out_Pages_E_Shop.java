package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.*;

import java.util.concurrent.TimeUnit;

public class StepDefinition_Check_Out_Pages_E_Shop {
    public WebDriver driver;

    private Check_Out_Page_E_Shop_Step_1_OF_4_Summary check_out_page_e_shop_step_1_of_4_summary;
    private Check_Out_Page_E_Shop_Step_2_OF_4_Address check_out_page_e_shop_step_2_of_4_address;
    private Check_Out_Page_E_Shop_Step_3_OF_4_Shipping check_out_page_e_shop_step_3_of_4_shipping;
    private Check_Out_Page_E_Shop_Step_4_OF_4_Payment check_out_page_e_shop_step_4_of_4_payment;
    private Order_List_History_Page_E_Shop order_list_history_page_e_shop;
    String totalPrise;

    public StepDefinition_Check_Out_Pages_E_Shop(TestContext testContext)
    {
        driver = testContext.getDriver();
        check_out_page_e_shop_step_1_of_4_summary = new Check_Out_Page_E_Shop_Step_1_OF_4_Summary(driver);
        check_out_page_e_shop_step_2_of_4_address = new Check_Out_Page_E_Shop_Step_2_OF_4_Address(driver);
        check_out_page_e_shop_step_3_of_4_shipping = new Check_Out_Page_E_Shop_Step_3_OF_4_Shipping(driver);
        check_out_page_e_shop_step_4_of_4_payment = new Check_Out_Page_E_Shop_Step_4_OF_4_Payment(driver);
        order_list_history_page_e_shop = new Order_List_History_Page_E_Shop(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @And("^Click continue at summary Page\\.$")
    public void clickContinueAtSummaryPage() {
        check_out_page_e_shop_step_1_of_4_summary.Click_Continue_To_CheckOut_Button();
    }

    @And("^Verification & Compare Delivery and Billing Address\\.$")
    public void verificationCompareDeliveryAndBillingAddress() {
        check_out_page_e_shop_step_2_of_4_address.Assertion_Delivery_And_Billing_Address();
    }

    @And("^Click Continue Button\\.$")
    public void clickContinueButton() {
        check_out_page_e_shop_step_2_of_4_address.Click_Proceed_To_CheckOut_Button();
    }

    @And("^Select Agree And Click Submit button\\.$")
    public void selectAgreeAndClickSubmitButton() {
        check_out_page_e_shop_step_3_of_4_shipping.Select_Check_Box_Agree();
        check_out_page_e_shop_step_3_of_4_shipping.Click_Proceed_To_CheckOut_Button();
    }

    @And("^Select Payment Method \\(Check\\)\\.$")
    public void selectPaymentMethodCheck() {
        totalPrise = check_out_page_e_shop_step_4_of_4_payment.SaveTotalPrise();
        check_out_page_e_shop_step_4_of_4_payment.Click_Pay_Buy_Check_Link();
        check_out_page_e_shop_step_4_of_4_payment.Click_Confirm_My_Order_Button();
    }

    @And("^Verification of success order\\.$")
    public void verificationOfSuccessOrder() {
        check_out_page_e_shop_step_4_of_4_payment.Verification_Confirm_Message();
    }

    @And("^Click to Order History List\\.$")
    public void clickToOrderHistoryList() {
        check_out_page_e_shop_step_4_of_4_payment.Click_Back_To_Orders_Button();
    }
    @Then("^Verification and print last order prise\\.$")
    public void verificationAndPrintLastOrderPrise() {
        String orderPrise = order_list_history_page_e_shop.Get_Orger_Prise();
        Assert.assertEquals(orderPrise, totalPrise); //Verification Prise
        order_list_history_page_e_shop.Show_Size_Of_Order_Elements();
        System.out.println("Your prise is: "+ orderPrise);
    }
}
