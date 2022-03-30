package test.java.Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.Academy.E2EProject.Base;
import main.java.pageObjects.ForgotPasswordPage;
import main.java.pageObjects.LandingPage;
import main.java.pageObjects.LoginPage;

public class HomePage extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("driver initialized");
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) {
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.closePopup();
		// lp.getLogin().click();

		LoginPage lgp = lp.getLogin();

		lgp.Email().sendKeys(username);
		lgp.password().sendKeys("password");
		lgp.logIn().click();
		ForgotPasswordPage fp = lgp.forgotPwd();
		fp.enterEmail().sendKeys("hhj@.com");
		fp.resetPwd().click();
	}

	@AfterTest
	public void closeDriver() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "abc@qw.com";
		data[0][1] = "123456";
		data[1][0] = "ghgfg@qw.com";
		data[1][1] = "dff";
		return data;
	}
}
