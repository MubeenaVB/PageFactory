package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Utilities.Log;
import com.Restuarant.BaseClass.Baseclass;
import com.Restuarant.PageObjects.ClientStatsGetReport;
import com.Restuarant.PageObjects.LoginPage;
import com.Restuarant.PageObjects.ReportsPage;

public class VerifyClientStatsGetReportTest extends Baseclass {

	@Test
	public void GetReportForClientStats() throws InterruptedException {
		Log.startTestCase("GetReportForClientStats");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		ReportsPage Rp = new ReportsPage(driver);
		Rp.Reports();
		ClientStatsGetReport Gp = new ClientStatsGetReport(driver);
		Gp.ReportForClientStats();
		Assert.assertTrue(Gp.IsClientStatsDisplayed(), "Client Stats not displayed");
		Log.endTestCase("GetReportForClientStats");
	}

}
