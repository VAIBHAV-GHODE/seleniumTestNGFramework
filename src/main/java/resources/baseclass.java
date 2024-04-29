package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class baseclass {

	public WebDriver driver;
	public Properties prop;

	public static String email = generateRandomEmailID();

	public void driverInitilization() throws IOException {

		// Properties file data reading --
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

		// Access the data from properties file --

		prop = new Properties();

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		} else {

			System.out.println("please choose proper driver value");
		}

	}

	// This will help us to create uniq email addresss
	public static String generateRandomEmailID() {
		return "abc" + System.currentTimeMillis() + "@gmail.com";

	}

	@BeforeMethod
	public void launchBrowserAndUrl() throws IOException {

		driverInitilization();
		driver.get(prop.getProperty("url"));

	}

}
