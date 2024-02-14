package rshetty.resources;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public WebDriver driver;
	static ExtentReports extent;
	
    @BeforeTest
    public static ExtentReports getReportObject()
    {
        
        String logPath = System.getProperty("user.dir")+"\\reports\\log.html";
        System.out.println(logPath);
        ExtentSparkReporter reporter = new ExtentSparkReporter(logPath);  // ExtentSParkReporter creates an HTML page and do some configs
        reporter.config().setReportName("Error Validation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);  //ExtentSParkReporter should be attached to this main ExtentReports class
        extent.setSystemInfo("Tester Name", "Bhargav");
        return extent;
        
    }
}
