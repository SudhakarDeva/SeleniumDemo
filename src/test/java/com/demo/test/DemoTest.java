package com.demo.test;

import assessment.demo.Utils.TestdataUtil;
import assessment.demo.common.BaseClass;
import assessment.demo.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest extends BaseClass {

    @Test(dataProvider="testdata",dataProviderClass = TestdataUtil.class)
    public void demoFlow(String user,String pwd,String product,String firstname,String lastname,String postalcode,String finalaction) throws InterruptedException {
    driver.get("https://www.saucedemo.com/");
//        Thread.sleep(5000);
    Loginpage login = new Loginpage(driver);
    login.loginActions(user,pwd);
    System.out.println(driver.getCurrentUrl());
    Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed!");

    ProductsPage productsPage = new ProductsPage(driver);
    String status = productsPage.addtoCart(product);
    System.out.println(driver.getCurrentUrl());
    Assert.assertTrue(status.equalsIgnoreCase("success"),"No items added to cart");

    CartPage cartPage = new CartPage(driver);
    cartPage.clickCheckout();

    CheckOutUserPage checkOutUserPage = new CheckOutUserPage(driver);
    checkOutUserPage.filluserdetails(firstname,lastname,postalcode);

    CheckOutFinalPage checkOutFinalPage = new CheckOutFinalPage(driver);
    checkOutFinalPage.checkoutActions(finalaction);

}

}
