package ImagineRIS.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_THPLogin_002 extends BaseClass {

	@Test
	public void Telehealth() throws InterruptedException {
		driver.get("https://cloud1.softlinkinternational.com/TeleHealth_v2b/");
		String T1 = driver.getTitle();

		System.out.println(T1);

		if (T1.equals("Softlink TeleHealth Platform 123")) {
			Assert.assertTrue(true);
			test = extent.createTest("TC002", "The test case 1 has passed");

		} else {
			//Assert.assertTrue(false);
			test = extent.createTest("TC002", "The test case 2 has failed");
		}
	}
}
