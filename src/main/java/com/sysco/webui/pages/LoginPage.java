package com.sysco.webui.pages;

import com.sysco.webui.utils.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

/**
 * Created by dasunh on 5/21/18.
 */
public class LoginPage extends PageBase {
    private By txtUsername = By.xpath("");
    private By txtPsw = By.xpath("");
    private By btnSignIn = By.xpath("");

    public LoginPage() {
    }

    public LoginPage(Capabilities capabilities, String WEB_URL) {
        super(capabilities, WEB_URL);
    }

    public void setTxtUsername(String userName) {
        syscoLabUI.sendKeys(txtUsername, userName);
    }

    public void setTxtPsw(String psw) {
        syscoLabUI.sendKeys(txtPsw, psw);
    }

    public void clickSignIn() {
        syscoLabUI.click(btnSignIn);
        syscoLabUI.sleep(4);
    }
}
