package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Utilities.Log;
import com.Restuarant.BaseClass.Baseclass;
import com.Restuarant.PageObjects.LoginPage;
import com.Restuarant.PageObjects.ProductStatsGetReport;
import com.Restuarant.PageObjects.ReportsPage;

public class VerifyProductStatsGetReportTest extends Baseclass {

	@Test
	public void GetReportForProductStats() throws InterruptedException {
		Log.startTestCase("GetReportForProductStats");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		ReportsPage Rp = new ReportsPage(driver);
		Rp.Reports();
		ProductStatsGetReport Ps = new ProductStatsGetReport(driver);
		Assert.assertTrue(Ps.IsProductStatsDisplayed(), "Product Stats not displayed");
		Ps.ReportForProductStats();
		Log.endTestCase("GetReportForProductStats");
	}
}
