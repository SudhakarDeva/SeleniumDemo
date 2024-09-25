package assessment.demo.pages;

import assessment.demo.Utils.ReportListener;
import assessment.demo.Utils.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    WebElement checkoutbutton;

    public void clickCheckout()
    {
        String checkoutscreenshotpath = Screenshot.captureScreenshot(driver,"CartPage");
        ReportListener.attachscreenshot(checkoutscreenshotpath);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        checkoutbutton.click();
    }

}
