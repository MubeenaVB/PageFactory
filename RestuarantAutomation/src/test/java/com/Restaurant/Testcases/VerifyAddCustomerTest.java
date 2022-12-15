package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Restaurant.Utilities.Log;
import com.Restuarant.BaseClass.Baseclass;
import com.Restuarant.PageObjects.LoginPage;
import com.Restuarant.PageObjects.AddCustomer;
import com.Restuarant.PageObjects.AddWaiter;

public class VerifyAddCustomerTest extends Baseclass{

	@Parameters({"Name","Phone","Email","Discount","EditPhone","EditEmail"})
	@Test
	public void AddCustomer(String Name,String Phone,String Email,String Discount,String EditPhone,String EditEmail)
	{
		Log.startTestCase("AddCustomer");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(),"Login not successfull");
		AddCustomer Ac = new AddCustomer(driver);
		Ac.AddCutomer(Name, Phone, Email, Discount);
		Assert.assertTrue(Ac.SearchCustomer(),"Customer Not Added");
		Ac.EditCustomerDetails(EditPhone, EditEmail);
		Assert.assertTrue(Ac.ConfirmEdit(),"Edit is not successfull");
		Log.endTestCase("AddCustomer");
	}
	
	@Test
	public void DeleteCustomer()
	{  
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(),"Login not successfull");
		AddCustomer Ac = new AddCustomer(driver);
		Assert.assertTrue(Ac.DeleteCustomer(),"Delete Customer failed");	
	}
}
