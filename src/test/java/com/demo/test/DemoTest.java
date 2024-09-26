package com.demo.test;

import assessment.demo.Utils.ReportListener;
import assessment.demo.Utils.TestdataUtil;
import assessment.demo.common.BaseClass;
import assessment.demo.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest extends BaseClass {

    @Test(dataProvider = "testdata", dataProviderClass = TestdataUtil.class)
    public void demoFlow(String testcase, String description,String user, String pwd,String sortoption, String product, String firstname, String lastname, String postalcode, String finalaction) throws InterruptedException {

        driver.get("https://www.saucedemo.com/");
        Loginpage login = new Loginpage(driver);
        login.loginActions(user, pwd);
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed!");

        String status = null;
        ProductsPage productsPage = new ProductsPage(driver);
        status = productsPage.sortitems(sortoption);
        Assert.assertTrue(status.equalsIgnoreCase("success"), "Items not in expected sort order");

        status = productsPage.addtoCart(product);
        Assert.assertTrue(status.equalsIgnoreCase("success"), "No items added to cart");

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckOutUserPage checkOutUserPage = new CheckOutUserPage(driver);
        checkOutUserPage.filluserdetails(firstname, lastname, postalcode);

        CheckOutFinalPage checkOutFinalPage = new CheckOutFinalPage(driver);
        checkOutFinalPage.checkoutActions(finalaction);
        if(finalaction.equalsIgnoreCase("finish"))
            Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"),"Not the expected page");
        if(finalaction.equalsIgnoreCase("cancel"))
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),"Not the expected page");

        checkOutFinalPage.logout();
    }

}
