package assessment.demo.Utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

    // Method to capture a screenshot
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        // Create a timestamp to make each screenshot name unique
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = screenshotName + "_" + timestamp + ".png";
        String destinationPath = System.getProperty("user.dir") + "/extent-reports/screenshots/" + fileName;

        // Create a screenshot and save it to the specified location
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        try {
            File destination = new File(destinationPath);
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot taken: " + destinationPath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }

        return destinationPath;
    }
}

