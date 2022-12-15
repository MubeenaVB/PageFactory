package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Restaurant.Utilities.ExcelReadTest;
import com.Restaurant.Utilities.Log;
import com.Restuarant.BaseClass.Baseclass;
import com.Restuarant.PageObjects.AddStore;
import com.Restuarant.PageObjects.AddWaiter;
import com.Restuarant.PageObjects.HomePage;
import com.Restuarant.PageObjects.LoginPage;

public class VerifyHomePageTest extends Baseclass {

	
	@Test(dataProvider = "getStoreDetails",priority=1)
	public void ShopWithWaiter(String Name,String Email,String Phone,String Country,String City,String Adrs,String Footer) throws InterruptedException {
		Log.startTestCase("ShopWithWaiter");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		AddStore As= new AddStore(driver);
		As.AddingNewStore(Name,Email,Phone,Country,City,Adrs,Footer);
		Assert.assertTrue(As.SearchStore(),"Add new store failed");
		Log.endTestCase("ShopWithWaiter");
	}
	
	@Parameters({"Name","Phone","Email"})
	@Test(priority=2)
	public void AddingWaiter(String Name,String Phone,String Email) throws InterruptedException
	{
		Log.startTestCase("AddingWaiter");
		AddWaiter Aw = new AddWaiter(driver);
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Aw.AddingNewWaiter(Name,Phone,Email,2);
		Assert.assertTrue(Aw.SearchWaiter(),"Add new waiter failed");
		HomePage Hp = new HomePage(driver);
		Hp.StoreWithWaiter();
		Assert.assertTrue(Aw.DeleteWaiter(),"Delete waiter failed");
		Log.endTestCase("AddingWaiter");
	}

	@Test(priority=3)
	public void ShopWithoutWaiter() throws InterruptedException {
		Log.startTestCase("ShopWithoutWaiter");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		AddStore As= new AddStore(driver);
		HomePage Hp = new HomePage(driver);
		Assert.assertTrue(Hp.IsLogoPresent(), "Home page is not loaded");
		Hp.StoreWithoutWaiter();
		Assert.assertTrue(As.DeleteStore(),"Delete Store failed");
		Log.endTestCase("ShopWithoutWaiter");
	}
	@DataProvider
	public Object[][] getStoreDetails()
	{
        ExcelReadTest read = new ExcelReadTest("C:\\Users\\admin\\eclipse-workspace\\RestuarantAutomation\\TestData\\InputStoreData.xlsx");
		
		int rows=read.getRowCount(0);
		Object[][] data = new Object[rows][7];
		for(int i=0;i<rows;i++)
		{
			data[i][0]=read.getData(0, i, 0);
			data[i][1]=read.getData(0, i, 1);
			data[i][2]=read.getData(0, i, 2);
			data[i][3]=read.getData(0, i, 3);
			data[i][4]=read.getData(0, i, 4);
			data[i][5]=read.getData(0, i, 5);
			data[i][6]=read.getData(0, i, 6);
		}
		return data;
	}

}
