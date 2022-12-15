package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Utilities.Log;
import com.Restuarant.BaseClass.Baseclass;
import com.Restuarant.PageObjects.LoginPage;
import com.Restuarant.PageObjects.RegisterStatsGetReport;
import com.Restuarant.PageObjects.ReportsPage;

public class VerifyRegisterStatsGetReportTest extends Baseclass {

	@Test
	public void GetReportForRegisterStats() throws InterruptedException {
		Log.startTestCase("GetReportForRegisterStats");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		ReportsPage Rp = new ReportsPage(driver);
		Rp.Reports();
		RegisterStatsGetReport Rs = new RegisterStatsGetReport(driver);
		Assert.assertTrue(Rs.IsRegisterStatsDisplayed(), "Register Stats not displayed");
		Rs.ReportForRegisterStats();
		Log.endTestCase("GetReportForRegisterStats");
	}
}
