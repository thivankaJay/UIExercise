package com.sysco.webui.tests;


import com.sysco.webui.common.Constants;
import com.sysco.webui.functions.*;
import com.sysco.webui.pages.MyBundyAccountPage;
import com.sysco.webui.utils.DriverSetUpUtil;
import com.sysco.webui.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class WebTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
//        iTestContext.setAttribute("module","Bundabergrum");
    }

    @Test
    public void testLogin() throws Exception {
        softAssert = new SoftAssert();
        Start.selectBirthday("2003","January","20");
        softAssert.assertTrue(Start.errorMessageIsDisplayed());
        Start.selectBirthday("1985","January","20");
        softAssert.assertTrue(Welcome.welcomeMsgIsDisplayed());
        Welcome.navigateToMyAccount();
        softAssert.assertTrue(MyAccount.emailFieldDisplayed());
        softAssert.assertTrue(MyAccount.passwordFieldDisplayed());
        softAssert.assertTrue(MyAccount.loginButtonDisplayed());
        MyAccount.loginToSystem("",dataMap.get("password"));
        softAssert.assertEquals(MyAccount.getFieldValidationText(),dataMap.get("errorMsgRequiredField"));
        MyAccount.loginToSystem(dataMap.get("email"),"");
        softAssert.assertEquals(MyAccount.getFieldValidationText(),dataMap.get("errorMsgRequiredField"));
        MyAccount.loginToSystem(dataMap.get("email"),dataMap.get("password"));
        softAssert.assertTrue(MyBundyAccount.headingIsDisplayed());
        softAssert.assertEquals(MyBundyAccount.getUserName(),"HELLO, "+dataMap.get("userName")+"!");
        MyBundyAccount.gotoCart();
        MyCart.checkCartIsEmpty();
        MyBundyAccount.selectItem(dataMap.get("productName"));
        MyBundyAccount.checkout();
        softAssert.assertEquals(MyCart.getProductName(),dataMap.get("productName").toUpperCase());
        softAssert.assertEquals(MyCart.getProductPrice(),dataMap.get("productPrice"));
        MyCart.proceedCheckout();
        softAssert.assertEquals(MyCart.getFnameValue(), dataMap.get("firstName"));
        softAssert.assertEquals(MyCart.getLnameValue(), dataMap.get("lastName"));
        MyCart.continueCheckout();
        MyCart.clickPaymentOption();
        softAssert.assertAll();

















    }
}