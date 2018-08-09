package com.sysco.webui.functions;

import com.sysco.webui.pages.LoginPage;
import com.sysco.webui.pages.StartPage;
import org.openqa.selenium.Capabilities;

/**
 * Created by dasunh on 5/21/18.
 */
public class Start {

    private static StartPage startPage = new StartPage();

    public static void selectBirthday(String year, String month, String day){

        startPage.selectYear(year);
        startPage.selectMonth(month);
        startPage.selectDay(day);
        startPage.clickEnter();
    }

    public static boolean errorMessageIsDisplayed(){
       return startPage.errorMessageIsDisplayed();
    }


}

