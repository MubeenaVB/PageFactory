package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//POM with page factory
	
	WebDriver driver;
	
	@FindBy(id="shopping_cart_container")
	WebElement Cart;
	
	@FindBy(xpath="//li[@class='social_facebook']")
	WebElement Facebook;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement YourCart()
	{
		return Cart;
	}
	public WebElement FaceBookClick()
	{
		return Facebook;
	}
}
