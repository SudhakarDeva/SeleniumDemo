package assessment.demo.Utils;

import assessment.demo.common.BaseClass;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener extends BaseClass implements ITestListener {
    private static ExtentReports extent = ExtentReportSetup.getInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        Object[] parameters = result.getParameters();
        ExtentTest test = extent.createTest(parameters[0].toString(),parameters[1].toString());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        extentTest.get().log(Status.FAIL, result.getThrowable());

        WebDriver driver = ((BaseClass) result.getInstance()).driver;
        String screenshotPath = Screenshot.captureScreenshot(driver, "FailureScreen");
        attachscreenshot(screenshotPath,"FailureScreen");
    }

    public static void attachscreenshot(String screenshotPath,String screenshotname) {
        try {
            extentTest.get().addScreenCaptureFromPath(screenshotPath,screenshotname);
        } catch (Exception e) {
            extentTest.get().log(Status.FAIL, "Screenshot attachment failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
        extentTest.get().log(Status.SKIP, result.getThrowable());
    }

}