package com.Restuarant.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restuarant.BaseClass.Baseclass;

public class HomePage extends Baseclass {

	WebDriver driver;
	
	@FindBy(xpath = "(//span[@class='icon-bar'])[1]")
	WebElement menu;
	
	@FindBy(xpath = "//div/span[contains(@class,'store_title')]")
	WebElement StoreTitle;

	@FindBy(xpath = "//input[@id='CashinHando']")
	WebElement CashInHand;

	@FindBy(xpath = "//input[@id='waiterid']")
	WebElement WaiterCashInHand;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement SubmitButton;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement CloseButton;

	@FindBy(css = "img[alt='logo']")
	WebElement Logo;
	
	@FindBy(xpath="(//li[@class='flat-box waves-effect waves-block'])[1]")
	WebElement POS;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean IsLogoPresent() throws InterruptedException {
		// return DispLogo().isDisplayed();
		Thread.sleep(3000);
		return action.isDisplayed(driver, Logo);
	}

	public void IsStoresPresesnt(String name) {
		// List<WebElement> Stores =
		// driver.findElements(By.xpath("//a[@href='javascript:void(0)']"));
		// List<WebElement> Stores = driver.findElements(By.xpath("//li[@class='listing
		// clearfix']"));
		action.click1(menu, "Menu");
		action.click1(POS, "POS");
		List<WebElement> Stores = driver.findElements(By.xpath("//div/span[contains(@class,'store_title')]"));
		// boolean status=false;
		for (WebElement store : Stores) {
			String storeName = store.getText();
			if (storeName.contains(name)) {
				// System.out.println("Mubeena :"+storeName);
				action.click1(store, storeName);
				// status = true;
				break;
			}
		}
		// return status;
	}

	public void StoreWithWaiter() throws InterruptedException {
		IsStoresPresesnt("Magic Shop"); 
		action.type(CashInHand, "200");
		action.type(WaiterCashInHand, "200");
		action.click1(SubmitButton, "Submit");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();// accept or click ok on alert
		action.click1(CloseButton, "Close button");
	}

	public void StoreWithoutWaiter() throws InterruptedException {
		IsStoresPresesnt("Magic Shop");
		action.type(CashInHand, "200");
		action.click1(SubmitButton, "Submit");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();// accept or click ok on alert
		action.click1(CloseButton, "Close button");
	}
}
