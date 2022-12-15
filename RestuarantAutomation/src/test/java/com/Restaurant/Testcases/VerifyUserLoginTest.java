 package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Restaurant.Utilities.Log;
import com.Restuarant.BaseClass.Baseclass;
import com.Restuarant.PageObjects.LoginPage;

public class VerifyUserLoginTest extends Baseclass {

	@Test(groups= {"Smoke"})
	public void VerifyValidUserLogin() throws InterruptedException {
		Log.startTestCase("VerifyValidUserLogin");
		LoginPage Lp = new LoginPage(driver);
		Assert.assertTrue(Lp.IsLogoPresent(), "Login page is not loaded");
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(), "Home page is not loaded");
		Log.endTestCase("VerifyValidUserLogin");
		Lp.logout();
	}

	@Test(dataProvider = "getInvalidLoginDetails",groups= {"Smoke"})
	public void VerifyInvalidUserLogin(String Username, String password) throws Exception {
		Log.startTestCase("VerifyInvalidUserLogin");
		LoginPage Lp = new LoginPage(driver);
		Assert.assertTrue(Lp.SubmitButton().isDisplayed(),"Logout is not successful");
		Lp.InvalidLogin(Username, password);
		Log.startTestCase("VerifyInvalidUserLogin");
	}
	@DataProvider
	public Object[][] getInvalidLoginDetails() {
		Object[][] data = new Object[3][2];
		data[0][0] = "adm";
		data[0][1] = "password";
		data[1][0] = "admin";
		data[1][1] = "pass";
		data[2][0] = "adm";
		data[2][1] = "pass";
		return data;
	}
}
