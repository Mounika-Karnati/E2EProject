package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_email")
	WebElement email;
	@FindBy(id = "user_password")
	WebElement pwd;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;
	By frgtpwd=By.cssSelector("a[href*='index']");
	
	public WebElement Email() {
		return email;

	}

	public WebElement password() {
		return pwd;
	}

	public WebElement logIn() {
		return submit;
	}

	public ForgotPasswordPage forgotPwd() {
		driver.findElement(frgtpwd).click();
		return new ForgotPasswordPage(driver);

	}
}
