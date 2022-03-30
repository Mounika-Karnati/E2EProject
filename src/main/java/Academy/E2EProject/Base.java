package main.java.Academy.E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		// String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\MOUNIKA\\Downloads\\chromedriver.exe");
		//	ChromeOptions options=new ChromeOptions();
		//	options.addArguments("headless");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\MOUNIKA\\Downloads\\chromedriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {

		}

		return driver;

	}

	public String getScreenshotPath(String testmethodname, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\report" + testmethodname + ".png";
		FileUtils.copyFile(src, new File(dest));
		return dest;
	}
}
