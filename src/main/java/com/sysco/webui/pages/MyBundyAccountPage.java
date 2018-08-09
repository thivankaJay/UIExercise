package com.sysco.webui.pages;

import com.sysco.webui.utils.PageBase;
import org.openqa.selenium.By;

public class MyBundyAccountPage extends PageBase {

    private By txtHeading = By.xpath("//h1[text()='My Bundy Account']");
    private By txtName = By.xpath("//div[@class='welcome-msg']/h2[@class='sub-title']");
    private By tabProduct = By.xpath("//li[@class='link-product']");
    private By lnkExclusiveRange = By.xpath("(//a[text()='Exclusive Range'])[2]");
    private String lnkProduct = "(//a[@title='product_name'])[4]";
    private By btnAddToCart = By.xpath("//button//span[text()='Add to Cart']/../..");
    private By btnCart = By.id("cartHeader");
    private By spnCheckout = By.xpath("//span[text()='Checkout']");


    public boolean headingDisplayed() {
        syscoLabUI.sleepInMiliSeconds(3000);
        return syscoLabUI.isDisplayed(txtHeading);
    }

    public String getUserName() {
        return syscoLabUI.getText(txtName);
    }

    public void mouseHoverOnProductTab() {
        syscoLabUI.mouseHover(tabProduct);
    }

    public void clickOnProductCategory() {
        syscoLabUI.click(lnkExclusiveRange);
    }

    public void clickOnProduct(String product){
        syscoLabUI.click(By.xpath(lnkProduct.replace("product_name",product)));
    }

    public void addToCart(){
        syscoLabUI.sleepInMiliSeconds(3000);
        syscoLabUI.clickWithJavascript(btnAddToCart);
    }

    public void clickOnCart(){
        syscoLabUI.sleepInMiliSeconds(2000);
        syscoLabUI.click(btnCart);
    }

    public void clickCheckout(){
        syscoLabUI.click(spnCheckout);
    }


}
