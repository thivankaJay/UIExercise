package com.sysco.webui.pages;

import com.sysco.webui.utils.PageBase;
import org.openqa.selenium.By;

public class MyAccountPage extends PageBase {

    private By txtEmailAddress = By.xpath("//input[@title='Email Address']");
    private By txtPassword = By.xpath("//input[@title='Password']");
    private By btnLogin = By.xpath("//button//span[text()='Login']");
    private By txtValidation = By.xpath("//div[@class='validation-advice']");

    public void sendEmailAddress(String email){
        syscoLabUI.sleepInMiliSeconds(1000);
        syscoLabUI.sendKeys(txtEmailAddress, email);
    }

    public void sendPassword(String password){
        syscoLabUI.sleepInMiliSeconds(1000);
        syscoLabUI.sendKeys(txtPassword, password);
    }

    public void clickLogin(){
        syscoLabUI.click(btnLogin);
    }

    public boolean emailFieldIsDisplayed(){
        return syscoLabUI.isDisplayed(txtEmailAddress);
    }

    public boolean passwordFieldIsDisplayed(){
        return syscoLabUI.isDisplayed(txtPassword);
    }

    public boolean loginButtonIsDisplayed(){
        return syscoLabUI.isDisplayed(btnLogin);
    }

    public String getTxtFieldValidationMessage(){
        return syscoLabUI.getText(txtValidation);
    }

}
