package com.Restuarant.PageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restaurant.Utilities.ExcelLibrary;
import com.Restuarant.BaseClass.Baseclass;

public class LoginPage extends Baseclass {

	WebDriver driver;

	@FindBy(xpath = "//input[@type='text']")
	WebElement UserName;

	@FindBy(xpath = "//input[@type='password']")
	WebElement Password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement Submit;

	@FindBy(css = "img[alt='logo']")
	WebElement Logo;

	@FindBy(xpath = "//i[@class='fa fa-sign-out fa-lg']")
	WebElement logout;

	@FindBy(xpath = "(//span[@class='icon-bar'])[1]")
	WebElement menu;
	
	public WebElement DispLogo() {
		return Logo;
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement Uname() {
		return UserName;
	}

	public WebElement Password() {
		return Password;
	}

	public WebElement SubmitButton() {
		return Submit;
	}
	
	public WebElement MenuButton() {
		return menu;
	}

	public WebElement LogoutButton() {
		return logout;
	}

	// Method to check whether the Login page is loaded properly
	// If present will get True else will get false
	public Boolean IsLogoPresent() {
		// return DispLogo().isDisplayed();
		return action.isDisplayed(driver, Logo);
	}

	// Created for login.This method will call at test case
	public void ValidLogin() {
		action.type(UserName, prop.getProperty("Username"));
		action.type(Password, prop.getProperty("Password"));
		action.click1(Submit, "Login button");
		/*
		 * Uname().click(); Uname().sendKeys(prop.getProperty("Username"));
		 * Password().click(); Password().sendKeys(prop.getProperty("Password"));
		 * SubmitButton().click();
		 */
	}

	public void InvalidLogin(String Username, String password) {
		action.type(UserName, Username);
		action.type(Password, password);
		action.click1(Submit, "Login button");
	}
	/*public void InvalidLogin() throws Exception
	{
		ExcelLibrary ex=new ExcelLibrary();
		ArrayList<String> list = ex.getData("TestCases");
		String arr=list.get(0);
		System.out.println("from excel : "+arr);
	}*/
	
	public void logout() {
		
		action.click1(menu, "Menu button");
		action.click1(logout, "Logout button");
		/*
		 * Menu().click(); Logout().click();
		 */
	}
}
