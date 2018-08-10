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
        iTestContext.setAttribute("feature", "orders - rumCheckout");
        iTestContext.setAttribute("module","Bundabergrum");
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
        MyAccount.loginToSystem("","12345678");
        softAssert.assertEquals(MyAccount.getFieldValidationText(),"This is a required field.");
        MyAccount.loginToSystem("williamjacob802@gmail.com","");
        softAssert.assertEquals(MyAccount.getFieldValidationText(),"This is a required field.");
        MyAccount.loginToSystem("williamjacob802@gmail.com","12345678");
        softAssert.assertTrue(MyBundyAccount.headingIsDisplayed());
        /*softAssert.assertEquals(MyBundyAccount.getUserName(),"HELLO, WILLIAM JACOB!");
        MyBundyAccount.selectItem("Royal Liqueur - Mixed Pack 4");
        MyBundyAccount.checkout();
        softAssert.assertEquals(MyCart.getProductName(),"ROYAL LIQUEUR - MIXED PACK 4");
        softAssert.assertEquals(MyCart.getProductPrice(),"$129.95");
        MyCart.proceedCheckout();
        softAssert.assertEquals(MyCart.getFnameValue(),"william");
        softAssert.assertEquals(MyCart.getLnameValue(),"jacob");
        MyCart.continueCheckout();
        MyCart.clickPaymentOption();*/
        softAssert.assertAll();

















    }
}