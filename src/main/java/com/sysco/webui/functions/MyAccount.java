package com.sysco.webui.functions;

import com.sysco.webui.pages.MyAccountPage;
import com.sysco.webui.pages.WelcomePage;

/**
 * Created by dasunh on 5/21/18.
 */
public class MyAccount {

    private static MyAccountPage myAccountPage = new MyAccountPage();

    public static boolean emailFieldDisplayed(){
        return myAccountPage.emailFieldIsDisplayed();
    }

    public static boolean passwordFieldDisplayed(){
        return myAccountPage.passwordFieldIsDisplayed();
    }

    public static boolean loginButtonDisplayed(){
        return myAccountPage.loginButtonIsDisplayed();
    }

    public static void loginToSystem(String email, String password){
        myAccountPage.sendEmailAddress(email);
        myAccountPage.sendPassword(password);
        myAccountPage.clickLogin();
    }

    public static String getFieldValidationText(){
        return myAccountPage.getTxtFieldValidationMessage();
    }


}

