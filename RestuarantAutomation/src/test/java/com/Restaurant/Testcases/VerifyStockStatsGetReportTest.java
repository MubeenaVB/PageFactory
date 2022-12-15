package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Restaurant.Utilities.Log;
import com.Restuarant.BaseClass.Baseclass;
import com.Restuarant.PageObjects.LoginPage;
import com.Restuarant.PageObjects.ReportsPage;
import com.Restuarant.PageObjects.StockStatsGetReport;

public class VerifyStockStatsGetReportTest extends Baseclass {

	@Test
	public void GetReportForStockStats() throws InterruptedException {
		Log.startTestCase("GetReportForStockStats");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		ReportsPage Rp = new ReportsPage(driver);
		Rp.Reports();
		StockStatsGetReport St = new StockStatsGetReport(driver);
		Assert.assertTrue(St.IsStockStatsDisplayed(), "Stock Stats not displayed");
		St.ReportForStockStats();
		Log.endTestCase("GetReportForStockStats");
	}
}
