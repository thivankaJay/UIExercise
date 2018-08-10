package com.sysco.webui.pages;

import com.sysco.webui.utils.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by dasunh on 5/21/18.
 */
public class MyCartPage extends PageBase {
    private By txtPrice = By.xpath("(//div[@id='shopping-cart-table']//span[@class='cart-price']/span)[1]");
    private By txtProductName = By.xpath("//div[@id='shopping-cart-table']//h2/a");
    private By btnProceedCheckout = By.xpath("(//button[@title='Proceed to Checkout'])[1]");
    private By txtCheckoutFName = By.id("billing:firstname");
    private By txtCheckoutLName = By.id("billing:lastname");
    private By btnDeliveryContinue = By.id("delivery-address-button");
    private By btnShippingContinue = By.id("shipping-method-button");
    private By radBtnCreditCart = By.xpath("(//label[contains(text(),'Credit Card')])[1]");
    private By txtCartEmpty = By.xpath("//p[@class='cart-empty']");
    private By lstCart = By.xpath("//ol/li//a[@title='Remove']");

    public String getPrice(){
        syscoLabUI.sleepInMiliSeconds(5000);

        return syscoLabUI.getText(txtPrice);
    }

    public void removeElement(){
        List<WebElement> cartElements = syscoLabUI.findElements(lstCart);
        for (WebElement element: cartElements) {
            syscoLabUI.click(element);
            syscoLabUI.clickOkInWindowsAlert();
        }
    }


    public boolean cartIsEmpty(){
        return syscoLabUI.isDisplayed(txtCartEmpty);
    }

    public String getProductName(){
        syscoLabUI.sleepInMiliSeconds(5000);
        return syscoLabUI.getText(txtProductName);
    }

    public void clickProceedButton(){
        syscoLabUI.click(btnProceedCheckout);
    }

    public String getFnameValue(){
        syscoLabUI.sleepInMiliSeconds(2000);
        return syscoLabUI.getAttribute(txtCheckoutFName,"value");
    }

    public String getLnameValue(){
        syscoLabUI.sleepInMiliSeconds(2000);
        return syscoLabUI.getAttribute(txtCheckoutLName,"value");
    }

    public void clickDeliveryContinue(){
        syscoLabUI.click(btnDeliveryContinue);
    }

    public void clickShippingContinue(){
        syscoLabUI.sleepInMiliSeconds(3000);
        syscoLabUI.click(btnShippingContinue);
    }

    public void clickPaymentOption(){
        syscoLabUI.sleepInMiliSeconds(2000);
        syscoLabUI.click(radBtnCreditCart);
    }
}
