package ImagineRIS.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ImagineRIS.Utilities.ReadConfig;

public class LoginPage {

	WebDriver driver;
	ReadConfig readconfig = new ReadConfig();
	String url = readconfig.geturl();

	public LoginPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	@FindBy(id = "txtLoginname")
	WebElement username;

	@FindBy(id = "txtPassword")
	WebElement password;

	@FindBy(id = "btnSubmit")
	WebElement Submit;

	@FindBy(id = "btnOPD")
	WebElement OPD;

	@FindBy(id = "btnAdd")
	WebElement Add;

	@FindBy(id = "MRN")
	WebElement MRN1;

	@FindBy(id = "btnSave")
	WebElement Save;

	public void loginpage(String UserName, String Passcode) throws InterruptedException {
		username.sendKeys(UserName);
		password.sendKeys(Passcode);
		Thread.sleep(2000);
		Submit.click();
	}

	public void goTo() {
		driver.navigate().to(url);

	}

	public void Addpatient(String MRN) {
		OPD.click();
		Add.click();
		MRN1.sendKeys(MRN);
		Save.click();
	}

}
