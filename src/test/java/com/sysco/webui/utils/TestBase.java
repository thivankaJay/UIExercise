package com.sysco.webui.utils;

import com.sysco.webui.common.LoadDataProperties;
import com.sysco.webui.functions.Login;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import com.syscolab.qe.core.reporting.SyscoLabQCenter;
import com.syscolab.qe.core.reporting.SyscoLabReporting;
import com.sysco.webui.common.Constants;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Map;



@Listeners(SyscoLabListener.class)
public class TestBase extends SyscoLabListener{
    private SyscoLabListener testListeners;
    private SyscoLabQCenter syscoLabQCenter;
    public static Map<String, String> dataMap;
    protected SoftAssert softAssert;

    @BeforeClass
    public void init() {

        testListeners = new SyscoLabListener();
        syscoLabQCenter = new SyscoLabQCenter();
        startBrowser();
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        System.out.println("Test Running " + this.getClass().toString());
        dataMap = LoadDataProperties.loadDataProperties();
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp(ITestContext iTestContext) {
        try {
            syscoLabQCenter.setProjectName(Constants.TEST_PROJECT);
            syscoLabQCenter.setEnvironment(Constants.TEST_ENV);
            syscoLabQCenter.setRelease(Constants.TEST_RELEASE);
            syscoLabQCenter.setModule(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setFeature(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setClassName(iTestContext.getClass().getName());

            if (Constants.UPDATE_DASHBOARD)
                SyscoLabReporting.generateJsonFile(SyscoLabListener.getResults(), syscoLabQCenter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startBrowser() {
        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            Login.loadLoginPage(null, Constants.APP_URL);
        } else
            Login.loadLoginPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_BROWSER), Constants.APP_URL);
    }

    @AfterTest
    public void quitDriver(){
        syscoLabUI.quit();
    }
}
