package assessment.demo.Utils;

import assessment.demo.common.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reusables extends BaseClass {

    public void clearandentervalues(WebElement element,String text)
    {
        element.clear();
        element.sendKeys(text);
    }

    public void getscreenshot(String filename,String screenshotname,WebDriver driver)
    {
        String checkoutscreenshotpath = Screenshot.captureScreenshot(driver,filename);
        ReportListener.attachscreenshot(checkoutscreenshotpath,screenshotname);
    }

}
