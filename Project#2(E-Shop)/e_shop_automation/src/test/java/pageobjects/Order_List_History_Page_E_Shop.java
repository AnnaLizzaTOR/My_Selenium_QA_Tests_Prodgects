package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Order_List_History_Page_E_Shop {
    WebDriver driver;
    //Locators============================================
//    @FindBy(css = "#order-list > tbody > tr")
//    WebElement OrdersList; //Why not working, like webElement?
    By OrderList = By.cssSelector("#order-list > tbody");
    @FindBy(css = "#order-list > tbody > tr.first_item > td.history_price > span")
    WebElement orderPrice;
    //====================================================
    public Order_List_History_Page_E_Shop(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void Show_Size_Of_Order_Elements()
    {
        List<WebElement> orderList = driver.findElements(OrderList);
        System.out.println("Number of Orders is: "+orderList.size());
    }
    public String Get_Orger_Prise(){
    String orderPrice = this.orderPrice.getText();
        return orderPrice;
    }
}
