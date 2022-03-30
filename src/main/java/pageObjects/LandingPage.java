package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private By signin = By.cssSelector("a[href*='sign_in']");

	private @FindBy(xpath = "//button[text()='NO THANKS']")
	 WebElement popup;
	private @FindBy(xpath = "//h2[text()='Featured Courses']")
	WebElement title;
	private @FindBy(css = ".nav.navbar-nav.navbar-right>li>a")
	WebElement content;
	private  By header=By.cssSelector("div[class*='video-banner'] h3");

	public void closePopup() {
		try {
			popup.click();
		}
		catch(NoSuchElementException e) {
			System.out.println("NoSuchElementException handled");

		}
	}

	public LoginPage getLogin() {
		driver.findElement(signin).click();
		LoginPage lgp = new LoginPage(driver);
		return lgp;
	}

	public WebElement getContent() {
		return content;
	}

	public WebElement getTitle() {
		return title;
	}
	public WebElement getHeader() {
		return driver.findElement(header);
	}
}
