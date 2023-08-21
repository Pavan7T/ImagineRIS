package ImagineRIS.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());

		}

	}

	public String geturl() {
		String url = pro.getProperty("URL");
		return url;
	}

	public String getusername() {
		String Username = pro.getProperty("Username");
		return Username;
	}

	public String getpassword() {
		String Password = pro.getProperty("Passcode");
		return Password;
	}

	public String chromepath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String firefoxpath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getmrn() {
		String mrn = pro.getProperty("mrn");
		return mrn;
	}
}
