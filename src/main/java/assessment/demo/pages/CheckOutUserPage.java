package assessment.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutUserPage {
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
        firstnametextfield.sendKeys(firstname);
        lastnametextfield.sendKeys(lastname);
        postalcodefield.sendKeys(postalcode);
        Thread.sleep(2000);
        continuebutton.click();
        Thread.sleep(2000);
    }

}
