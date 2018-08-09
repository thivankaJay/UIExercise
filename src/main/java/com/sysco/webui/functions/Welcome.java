package com.sysco.webui.functions;

import com.sysco.webui.pages.StartPage;
import com.sysco.webui.pages.WelcomePage;

/**
 * Created by dasunh on 5/21/18.
 */
public class Welcome {

    private static WelcomePage welcomePage = new WelcomePage();

    public static void navigateToMyAccount(){
        welcomePage.clickMyAccount();
    }

    public static boolean welcomeMsgIsDisplayed(){
        return welcomePage.welcomeMsgIsDisplayed();
    }




}

