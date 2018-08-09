package com.sysco.webui.functions;

import com.sysco.webui.pages.LoginPage;
import org.openqa.selenium.Capabilities;

/**
 * Created by dasunh on 5/21/18.
 */
public class Login {

    private static LoginPage loginPage = new LoginPage();

    public static void loadLoginPage(Capabilities capabilities, String WEB_URL) {
        loginPage = new LoginPage(capabilities, WEB_URL);
    }

    public static void quiteDriver() {
        loginPage.quitDriver();
    }

    public static void logIntoWorkday(String userId, String psw) {
        loginPage.setTxtUsername(userId);
        loginPage.setTxtPsw(psw);
        loginPage.clickSignIn();
    }
}
