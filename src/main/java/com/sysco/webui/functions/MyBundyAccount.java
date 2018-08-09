package com.sysco.webui.functions;

import com.sysco.webui.pages.MyAccountPage;
import com.sysco.webui.pages.MyBundyAccountPage;

/**
 * Created by dasunh on 5/21/18.
 */
public class MyBundyAccount {

    private static MyBundyAccountPage myBundyAccountPage = new MyBundyAccountPage();

    public static boolean headingIsDisplayed(){
        return myBundyAccountPage.headingDisplayed();
    }

    public static String getUserName(){
        return myBundyAccountPage.getUserName();
    }

    public static void selectItem(String item){
        myBundyAccountPage.mouseHoverOnProductTab();
        myBundyAccountPage.clickOnProductCategory();
        myBundyAccountPage.clickOnProduct(item);
        myBundyAccountPage.addToCart();
    }

    public static void checkout(){
        myBundyAccountPage.clickOnCart();
        myBundyAccountPage.clickCheckout();
    }



}

