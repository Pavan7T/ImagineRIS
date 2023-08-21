package ImagineRIS.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ImagineRIS.PageObject.LoginPage;

public class TC_LoginPage_001 extends BaseClass {

	@Test
	public void loginmodule() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.goTo();
		logger.info("Hitted Application URl");
		// Thread.sleep(5000);
		lp.loginpage(Username, Passcode);
		captureScreenshot(driver, "LoginCredntials");
		logger.info("Username and Password entered");
		Thread.sleep(3000);
		lp.Addpatient(mrn);
		logger.info("Patient added successfully");
		test = extent.createTest("TC_LoginPage_001", "The test case 1 has passed");
	}

}
