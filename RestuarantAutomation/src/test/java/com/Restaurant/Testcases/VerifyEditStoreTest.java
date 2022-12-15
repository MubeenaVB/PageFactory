package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Restaurant.Utilities.ExcelReadTest;
import com.Restaurant.Utilities.Log;
import com.Restuarant.BaseClass.Baseclass;
import com.Restuarant.PageObjects.AddStore;
import com.Restuarant.PageObjects.LoginPage;

public class VerifyEditStoreTest extends Baseclass{

	@Test(dataProvider = "getStoreDetails",priority=1)
	public void AddingStore(String Name,String Email,String Phone,String Country,String City,String Adrs,String Footer) throws InterruptedException
	{
		Log.startTestCase("AddingStore");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(),"Login not successfull");
		AddStore As= new AddStore(driver);
		As.AddingNewStore(Name,Email,Phone,Country,City,Adrs,Footer);
		Assert.assertTrue(As.SearchStore(),"Add new store failed");
		As.EditStoreDetails();
		Assert.assertTrue(As.ConfirmEdit(),"Edit is not successfull");
		Log.endTestCase("AddingStore");
	}
	@Test(priority=2)
	public void AddTableInStore() throws InterruptedException
	{
		Log.startTestCase("AddTableInStore");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(),"Login not successfull");
		AddStore As= new AddStore(driver);
		As.AddZone();
		As.AddTable();
		Assert.assertTrue(As.TableValidation(),"Table Not created");
		Log.endTestCase("AddTableInStore");
		
	}
	@Test(priority=3,dependsOnMethods= {"AddTableInStore"})
	public void DeleteStore()
	{
		Log.startTestCase("DeleteStore");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(),"Login not successfull");
		AddStore As= new AddStore(driver);
		Assert.assertTrue(As.DeleteStore(),"Delete Store failed");
		Log.endTestCase("DeleteStore");
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
