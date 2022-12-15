package SwagLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyUserLogin {

	@Test
	public void UserLoginToSwagLabs()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		LoginPage Lp = new LoginPage(driver);
		Lp.Uname().click();
		Lp.Uname().sendKeys("standard_user");
		Lp.Pswd().click();
		Lp.Pswd().sendKeys("secret_sauce");
		Lp.LoginBtn().click();
		
		HomePage Hp = new HomePage(driver);
		Hp.YourCart().click();
		Hp.FaceBookClick().click();	
		
	}
}
