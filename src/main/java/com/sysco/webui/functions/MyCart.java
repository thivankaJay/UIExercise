package com.sysco.webui.functions;

import com.sysco.webui.pages.MyBundyAccountPage;
import com.sysco.webui.pages.MyCartPage;

/**
 * Created by dasunh on 5/21/18.
 */
public class MyCart {

    private static MyCartPage myCartPage = new MyCartPage();


    public static String getProductPrice(){
        return myCartPage.getPrice();
    }

    public static String getProductName(){
        return myCartPage.getProductName();
    }

    public static void proceedCheckout(){
        myCartPage.clickProceedButton();
    }

    public static String getFnameValue(){
        return myCartPage.getFnameValue();
    }

    public static String getLnameValue(){
        return myCartPage.getLnameValue();
    }

    public static void continueCheckout(){
        myCartPage.clickDeliveryContinue();
        myCartPage.clickShippingContinue();
    }

    public static void clickPaymentOption(){
        myCartPage.clickPaymentOption();
    }

}

