package assessment.demo.pages;

import assessment.demo.Utils.Reusables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CheckOutUserPage extends Reusables {
    WebDriver driver;

    public CheckOutUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    WebElement firstnametextfield;
    @FindBy(id = "last-name")
    WebElement lastnametextfield;
    @FindBy(id = "postal-code")
    WebElement postalcodefield;
    @FindBy(id = "continue")
    WebElement continuebutton;


    public void filluserdetails(String firstname,String lastname,String postalcode) throws InterruptedException {
        clearandentervalues(firstnametextfield,firstname);
        clearandentervalues(lastnametextfield,lastname);
        clearandentervalues(postalcodefield,postalcode);
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        continuebutton.click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

}
