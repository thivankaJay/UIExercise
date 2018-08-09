package com.sysco.webui.pages;

import com.sysco.webui.utils.PageBase;
import org.openqa.selenium.By;

public class WelcomePage extends PageBase {

    private By myAccount = By.xpath("//li/a[@title='My Account']");
    private By imgWelcome = By.xpath("(//img[@alt='Welcome to Bundaberg'])[2]");

    public void clickMyAccount(){
        syscoLabUI.sleepInMiliSeconds(2000);
        syscoLabUI.click(myAccount);
    }

    public boolean welcomeMsgIsDisplayed(){
        return syscoLabUI.isDisplayed(imgWelcome);
    }



}
