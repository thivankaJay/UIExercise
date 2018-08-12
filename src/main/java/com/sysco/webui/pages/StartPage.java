package com.sysco.webui.pages;

import com.sysco.webui.utils.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class StartPage extends PageBase {

    private By drpDwnYear = By.id("age_select_year");
    private By drpDwnMonth = By.id("age_select_month");
    private By drpDwnDay = By.id("age_select_day");
    private By btnEnter = By.id("age_confirm_btn");
    private By txtMissingField = By.xpath("//span[@data-lang='missing_fields']");


    public void selectYear(String year) {
        syscoLabUI.refreshBrowser();
        syscoLabUI.sleepInMiliSeconds(5000);
        syscoLabUI.selectFromDropDown(drpDwnYear, year);
    }

    public void selectMonth(String month) {
        syscoLabUI.selectFromDropDown(drpDwnMonth, month);
    }

    public void selectDay(String day) {
        syscoLabUI.selectFromDropDown(drpDwnDay, day);
    }

    public void clickEnter() {
        syscoLabUI.click(btnEnter);
    }

    public void getMissingFeildErrorMessgae() {
        syscoLabUI.getText(txtMissingField);
    }

    public boolean errorMessageIsDisplayed(){
        return syscoLabUI.isDisplayed(txtMissingField);
    }

}
