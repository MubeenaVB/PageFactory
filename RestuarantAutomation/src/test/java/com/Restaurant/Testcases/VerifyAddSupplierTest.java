package com.Restaurant.Testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Restaurant.Utilities.Log;
import com.Restuarant.BaseClass.Baseclass;
import com.Restuarant.PageObjects.AddCustomer;
import com.Restuarant.PageObjects.LoginPage;
import com.Restuarant.PageObjects.AddSupplier;

public class VerifyAddSupplierTest extends Baseclass{

	@Parameters({"Name","Phone","Email","Discount","EditPhone","EditEmail"})
	@Test
	public void AddSupplier(String Name,String Phone,String Email,String Notes,String EditPhone,String EditEmail)
	{
		Log.startTestCase("AddSupplier");
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(),"Login not successfull");
		AddSupplier Asp = new AddSupplier(driver);
		Asp.AddingSupplier(Name, Phone, Email, Notes);
		Assert.assertTrue(Asp.SearchSupplier(),"Customer Not Added");
		Asp.EditSupplierDetails(EditPhone, EditEmail);
		Assert.assertTrue(Asp.ConfirmEdit(),"Edit is not successfull");
		Log.endTestCase("AddSupplier");
	}
	
	@Test
	public void DeleteSupplier()
	{  
		LoginPage Lp = new LoginPage(driver);
		Lp.ValidLogin();
		Assert.assertTrue(Lp.IsLogoPresent(),"Login not successfull");
		AddSupplier Asp = new AddSupplier(driver);
		Assert.assertTrue(Asp.DeleteSupplier(),"Delete Customer failed");	
	}
	
}
