package assessment.demo.pages;

import assessment.demo.Utils.ReportListener;
import assessment.demo.Utils.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutFinalPage {
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

        String checkoutscreenshotpath = Screenshot.captureScreenshot(driver,"CheckOutFinal");
        ReportListener.attachscreenshot(checkoutscreenshotpath);

        driver.findElement(By.id(finalaction)).click();
        Thread.sleep(2000);

        leftMenuIcon.click();
        Thread.sleep(1000);

        logoutButton.click();
        Thread.sleep(1000);

    }

}
