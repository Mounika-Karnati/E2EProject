package test.java.Academy.E2EProject;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import main.java.Academy.E2EProject.Base;
import main.java.pageObjects.LandingPage;

public class ValidateTitle extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	LandingPage lp;

	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("driver initialized");
		driver.get(prop.getProperty("url"));
		log.info("Website launched");
		lp = new LandingPage(driver);
		lp.closePopup();
	}

	@Test
	public void checkTitle() throws IOException {

		Assert.assertTrue(lp.getTitle().getText().equalsIgnoreCase("Featured Courses"));
		log.info("text successfully matched");
		Assert.assertTrue(lp.getContent().isDisplayed());
		log.info("Navigation bars displayed");

	}

	@Test
	public void checkHeader() {
		Assert.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("text successfully matched");
	}

	@AfterTest
	public void closeDriver() {

		driver.close();
	}

}
