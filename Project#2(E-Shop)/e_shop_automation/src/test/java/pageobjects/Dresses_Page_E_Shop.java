package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dresses_Page_E_Shop extends Main_Page_E_Shop {
    WebDriver driver;
    Actions actions;
    //Locators==For==Dresses====================================
    //START=====Dress#1
    @FindBy(css = "#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.left-block > div > a.product_img_link > img")
    WebElement dress1;
    @FindBy(css = "#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line.hovered > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
    WebElement dress1_Add_To_Cart;
    //END=======Dress#1
    //START=====Dress#2
    @FindBy(css = "#center_column > ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img")
    WebElement dress2;
    @FindBy(css = "#center_column > ul > li:nth-child(2) > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
    WebElement dress2_Add_To_Cart;
    //END=======Dress#2
    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span")
    WebElement continue_Shopping_Button;
    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")
    WebElement proceed_to_Checkout;
    //==========================================================
    public Dresses_Page_E_Shop(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }
    public void Hover_Dress1()
    {
        actions.moveToElement(dress1).perform();
    }
    public void Click_Add_To_Cart_Dress1()
    {
        dress1_Add_To_Cart.click();
    }
    public void Click_Continue_To_Shopping()
    {
        continue_Shopping_Button.click();
    }
    public void Hover_Dress2()
    {
        actions.moveToElement(dress2).perform();
    }
    public void Click_Add_To_Cart_Dress2()
    {
        dress2_Add_To_Cart.click();
    }
    public void Click_Proceed_To_Checkout()
    {
        proceed_to_Checkout.click();
    }
}
