package assessment.demo.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportSetup {
    public static ExtentReports extent;
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest test;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    public static ExtentReports createInstance() {
        sparkReporter = new ExtentSparkReporter("./extent-reports/SparkReport.html");
        sparkReporter.config().setDocumentTitle("Automation Demo Report");
        sparkReporter.config().setReportName("Selenium Test Results");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Sudhakar", "Tester");
        extent.setSystemInfo("Environment", "Local");

        return extent;
    }
}
