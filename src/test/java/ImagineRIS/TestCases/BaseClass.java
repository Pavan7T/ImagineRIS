package ImagineRIS.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ImagineRIS.Utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String Username = readconfig.getusername();
	public String Passcode = readconfig.getpassword();
	public String mrn = readconfig.getmrn();
	public static Logger logger;

	public static WebDriver driver;

	public ExtentReports extent;
	public ExtentTest test;
	public ExtentHtmlReporter htmlReporter;

	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/extent-report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		htmlReporter.config().setDocumentTitle("ImagineRIS Automation Test Report");
		htmlReporter.config().setReportName("ImagineRIS");
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('ZZZ')'");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getTestName());
		} else {
			test.log(Status.SKIP, result.getTestName());
		}

		// driver.quit();
	}

	@AfterSuite
	public void TearDown() {
		extent.flush();
	}

	@Parameters({ "browser" })
	@BeforeClass
	public void setup(String br) {

		logger = Logger.getLogger("Imagine Diagnostics Suit");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.chromepath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.firefoxpath());
			driver = new FirefoxDriver();

		} else if (br.equals("edge")) {
			// System.setProperty("webdriver.chrome.driver", readconfig.getbrowserpath());
			// driver = new ChromeDriver();
		}

	}

	@AfterClass
	public void teardown() {
		driver.quit();

	}

	public static void captureScreenshot(WebDriver driver, String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			FileHandler.copy(source, new File("./Screenshots/" + screenshotName + ".png"));

			logger.info("Screenshot Taken");
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}

}
