package com.sysco.webui.utils;

import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.Capabilities;

public class PageBase {

    protected static SyscoLabUI syscoLabUI;

    public PageBase() {
    }

    public PageBase(Capabilities capabilities, String WEB_URL) {
        syscoLabUI = new SyscoLabWUI(capabilities);
        syscoLabUI.navigateTo(WEB_URL);
//        syscoLabUI.setTimeOut(WaitTimeUtil.LONG_TIME_OUT);
        syscoLabUI.driver.manage().window().fullscreen();
    }

    public void refreshBrowser() {
        syscoLabUI.refreshBrowser();
    }

    public static void quitDriver() {
        syscoLabUI.quit();
    }
}
