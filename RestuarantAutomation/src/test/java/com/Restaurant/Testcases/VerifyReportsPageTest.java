package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Utilities.Log;
import com.Restuarant.BaseClass.Baseclass;
import com.Restuarant.PageObjects.LoginPage;
import com.Restuarant.PageObjects.ReportsPage;

public class VerifyReportsPageTest extends Baseclass {

	@Test
	public void SelectReportsOption() throws InterruptedException{
		Log.startTestCase("SelectReportsOption");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		ReportsPage Rp = new ReportsPage(driver);
		Assert.assertTrue(Rp.IsLogoPresent(),"Home page not loaded");
		Rp.Reports();
		Log.endTestCase("SelectReportsOption");
	}

	@Test
	public void ReveExpnOnPreviousYear() throws InterruptedException {
		Log.startTestCase("ReveExpnOnPreviousYear");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		ReportsPage Rp = new ReportsPage(driver);
		Rp.Reports();
		Assert.assertTrue(Rp.PreviosYear(), "Previous year data is not displayed correctly");
		Log.endTestCase("ReveExpnOnPreviousYear");
	}

	@Test
	public void ReveExpnOnNextYear() throws InterruptedException {
		Log.startTestCase("ReveExpnOnNextYear");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		ReportsPage Rp = new ReportsPage(driver);
		Rp.Reports();
		Assert.assertTrue(Rp.NextYear(), "Next year data is not displayed correctly");
		Log.endTestCase("ReveExpnOnNextYear");
	}
}
