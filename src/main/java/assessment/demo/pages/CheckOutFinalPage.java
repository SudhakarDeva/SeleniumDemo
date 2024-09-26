package assessment.demo.pages;

import assessment.demo.Utils.ReportListener;
import assessment.demo.Utils.Reusables;
import assessment.demo.Utils.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CheckOutFinalPage extends Reusables {
    WebDriver driver;

    public CheckOutFinalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//button[text()='Open Menu']")
    WebElement leftMenuIcon;

    @FindBy(id="logout_sidebar_link")
    WebElement logoutButton;

    public void checkoutActions(String finalaction) throws InterruptedException {

        getscreenshot("CheckoutFinalPage","Final page of checkout",driver);
        driver.findElement(By.id(finalaction)).click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        getscreenshot("OnFinalAction","Page after applying final action: "+finalaction,driver);
    }

    public void logout() throws InterruptedException {
        leftMenuIcon.click();
        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        logoutButton.click();
        Thread.sleep(1000);
    }

}
