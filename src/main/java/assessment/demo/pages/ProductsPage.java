package assessment.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartIcon;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement cartCount;

    public String addtoCart(String itemname) throws InterruptedException {
//        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("add-to-cart-sauce-labs-" + itemname)).click();
        System.out.println("Added " + itemname + " to the cart");
        Thread.sleep(3000);
        String status = null;
        try {
            System.out.println("Items added to cart : " + cartCount.getText());
            status = "success";
        } catch (Exception e) {
            status = "fail";
            }
        cartIcon.click();
        Thread.sleep(2000);
        return status;
    }

}
