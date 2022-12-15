package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	//Page object model without page factory
	
	WebDriver driver;
	By Username = By.id("user-name");
	By Password = By.id("password");
	By LoginButton = By.id("login-button");
	
	public LoginPage (WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement Uname()
	{
		return driver.findElement(Username);
	}
	public WebElement Pswd()
	{
		return driver.findElement(Password);
	}
	public WebElement LoginBtn()
	{
		return driver.findElement(LoginButton);
	}
	
}
