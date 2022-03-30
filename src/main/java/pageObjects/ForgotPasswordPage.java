package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	public WebDriver driver;

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_email")
	WebElement email;
	@FindBy(css = "input[name='commit']")
	WebElement send;
	

	public WebElement enterEmail() {
		return email;
	}

	public WebElement resetPwd() {
		return send;

	}
}
