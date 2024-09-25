package assessment.demo.pages;


import assessment.demo.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loginpage {

    WebDriver driver;

    @FindBy(id="user-name")
    WebElement username;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="login-button")
    WebElement loginbutton;

    public Loginpage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void loginActions(String name,String pwd)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(username));
        username.clear();
        username.sendKeys(name);
        password.clear();
        password.sendKeys(pwd);

        loginbutton.click();
        System.out.println("Login actions completed");
    }

}
