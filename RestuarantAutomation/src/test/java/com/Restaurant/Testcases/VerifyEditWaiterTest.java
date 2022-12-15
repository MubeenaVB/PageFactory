package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Restuarant.BaseClass.Baseclass;
import com.Restuarant.PageObjects.AddWaiter;
import com.Restuarant.PageObjects.LoginPage;

public class VerifyEditWaiterTest extends Baseclass{

	@Parameters({"Name","Phone","Email","EditPhone","EditEmail"})
	@Test
	public void AddingWaiter(String Name,String Phone,String Email,String EditPhone,String EditEmail) throws InterruptedException
	{
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(),"Login not successfull");
		AddWaiter Aw = new AddWaiter(driver);
		Aw.AddingNewWaiter(Name,Phone,Email,1);
		Assert.assertTrue(Aw.SearchWaiter(),"Add new waiter failed");
		Aw.EditWaiterDetails(EditPhone, EditEmail);
		Assert.assertTrue(Aw.ConfirmEdit(),"Edit is not successfull");
	}
	@Test
	public void DeleteWaiter()
	{  
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(),"Login not successfull");
		AddWaiter Aw = new AddWaiter(driver);
		Assert.assertTrue(Aw.DeleteWaiter(),"Delete waiter failed");	
	}
}
