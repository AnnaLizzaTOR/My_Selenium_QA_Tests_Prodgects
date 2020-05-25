import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.*;

import java.util.concurrent.TimeUnit;

public class e_shop_automation_OOP_Test {
    Actions actions;
    private static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    WebDriver driver;
    String user_Name = "KJHKJHKG644545KJJH4jhfkkh@gmail.com";
    String user_Password = "567r3dfgh";
    String totalPrise;
    @BeforeTest
    public void Set_Property()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(URL);
        Login_Page_E_Shop login_page_e_shop = new Login_Page_E_Shop(driver);
        login_page_e_shop.Full_Log_In(user_Name, user_Password);
    }
    @Test(priority = 1)
    public void e_shop_automation_Test_Select_Dresses()
    {
        Dresses_Page_E_Shop dresses_page_e_shop = new Dresses_Page_E_Shop(driver);
        dresses_page_e_shop.Click_Dresses_Link_Button();
        dresses_page_e_shop.Hover_Dress1();
        dresses_page_e_shop.Click_Add_To_Cart_Dress1();
        dresses_page_e_shop.Click_Continue_To_Shopping();
        dresses_page_e_shop.Hover_Dress2();
        dresses_page_e_shop.Click_Add_To_Cart_Dress2();
        dresses_page_e_shop.Click_Proceed_To_Checkout();
    }
    @Test(priority = 2)
    public void e_shop_automation_Test_Check_Out()
    {
        Check_Out_Page_E_Shop_Step_1_OF_4_Summary check_out_page_e_shop_step_1_of_4_summary = new Check_Out_Page_E_Shop_Step_1_OF_4_Summary(driver);
        Check_Out_Page_E_Shop_Step_2_OF_4_Address check_out_page_e_shop_step_2_of_4_address = new Check_Out_Page_E_Shop_Step_2_OF_4_Address(driver);
        Check_Out_Page_E_Shop_Step_3_OF_4_Shipping check_out_page_e_shop_step_3_of_4_shipping = new Check_Out_Page_E_Shop_Step_3_OF_4_Shipping(driver);
        Check_Out_Page_E_Shop_Step_4_OF_4_Payment check_out_page_e_shop_step_4_of_4_payment = new Check_Out_Page_E_Shop_Step_4_OF_4_Payment(driver);

        check_out_page_e_shop_step_1_of_4_summary.Click_Continue_To_CheckOut_Button();

        check_out_page_e_shop_step_2_of_4_address.Assertion_Delivery_And_Billing_Address();
        check_out_page_e_shop_step_2_of_4_address.Click_Proceed_To_CheckOut_Button();

        check_out_page_e_shop_step_3_of_4_shipping.Select_Check_Box_Agree();
        check_out_page_e_shop_step_3_of_4_shipping.Click_Proceed_To_CheckOut_Button();

        totalPrise = check_out_page_e_shop_step_4_of_4_payment.SaveTotalPrise();
        check_out_page_e_shop_step_4_of_4_payment.Click_Pay_Buy_Check_Link();
        check_out_page_e_shop_step_4_of_4_payment.Click_Confirm_My_Order_Button();
        check_out_page_e_shop_step_4_of_4_payment.Verification_Confirm_Message();
        check_out_page_e_shop_step_4_of_4_payment.Click_Back_To_Orders_Button();
    }
    @Test(priority = 3)
    public void e_shop_automation_Test_Order_List() {
        Order_List_History_Page_E_Shop order_list_history_page_e_shop = new Order_List_History_Page_E_Shop(driver);
        String orderPrise = order_list_history_page_e_shop.Get_Orger_Prise();
        Assert.assertEquals(orderPrise, totalPrise); //Verification Prise
        order_list_history_page_e_shop.Show_Size_Of_Order_Elements();
        System.out.println("Your prise is: "+ orderPrise);
    }
    @AfterTest
    public void Closed_Driver()
    {
        Main_Page_E_Shop main_page_e_shop = new Main_Page_E_Shop(driver);
        main_page_e_shop.Click_LogOut_Button();
        driver.quit();
    }
}
