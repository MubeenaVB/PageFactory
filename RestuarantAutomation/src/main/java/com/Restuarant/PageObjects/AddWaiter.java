package com.Restuarant.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restuarant.BaseClass.Baseclass;

public class AddWaiter extends Baseclass{

	WebDriver driver;
	
	public static String Phone1="";
	public static String Email1="";
	
	@FindBy(xpath = "(//span[@class='icon-bar'])[1]")
	WebElement menu;
	
	@FindBy(xpath="(//a[@data-toggle='dropdown'])[1]")
	WebElement PeopleDropDown;
	
	@FindBy(xpath="(//span[@class='menu-text'])[5]")
	WebElement Waiter;
	
	@FindBy(xpath="//button[@data-target='#AddWaiter']")
	WebElement AddWaiter;
	
	@FindBy(id="WaiterName")
	WebElement WaiterName;
	
	@FindBy(id="WaiterPhone")
	WebElement WaiterPhone;
	
	@FindBy(id="WaiterEmail")
	WebElement WaiterEmail;
	
	@FindBy(id="WaiterStore")
	WebElement WaiterStore;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SubmitButton;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement Search;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[1]")
	WebElement DeleteKey;
	
	@FindBy(xpath="//a[@class='btn btn-danger']")
	WebElement DeleteConfirm;
	
	@FindBy(xpath="//td[@class='sorting_1']")
	WebElement SearchResult1;
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	WebElement SearchResult2;
	
	@FindBy(xpath="(//a[@class='btn btn-default'])[2]")
	WebElement EditButton;
	
	@FindBy(xpath="(//tbody/tr/td)[2]")
	WebElement EditPhone;
	
	@FindBy(xpath="(//tbody/tr/td)[3]")
    WebElement EditEmail;
	
	public AddWaiter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void AddingNewWaiter(String Name,String Phone,String Email,int Store) throws InterruptedException
	{
		action.click1(menu, "Menu button");
		action.click1(PeopleDropDown, "People drop down");
		action.click1(Waiter, "Waiter");
		action.click1(AddWaiter, "Add Waiter");
		action.type(WaiterName, Name);
		action.type(WaiterPhone, Phone);
		action.type(WaiterEmail, Email);
		action.click1(WaiterStore, "Waiter Store");
		if(Store == 1){
		action.selectByVisibleText("MCDS", WaiterStore);
		}
		else if(Store == 2){
			action.selectByVisibleText("Magic Shop", WaiterStore);
		}
		action.click1(SubmitButton, "Submit");
	}
	
	public boolean SearchWaiter()
	{
		action.click1(menu, "Menu button");
		action.click1(PeopleDropDown, "People drop down");
		action.click1(Waiter, "Waiter");
		action.type(Search, "Kannan");
		String Result=SearchResult1.getText();
		boolean status=false;
		if(Result.contains("Kannan"))
		{
			status=true;
		}
		return status;
	}
	
	public boolean DeleteWaiter()
	{
		SearchWaiter();
		action.click1(DeleteKey, "Delete Key");
		action.click1(DeleteConfirm, "Yes,Delete it");
		action.type(Search, "Kannan");
		String Result=SearchResult2.getText();
		boolean status=false;
		if(Result.equalsIgnoreCase("No matching records found"))
		{
			status=true;
		}
		return status;
	}
	
	public void EditWaiterDetails(String EditPhone,String EditEmail)
	{
		Phone1=EditPhone;
		Email1=EditEmail;
		SearchWaiter();
		action.click1(EditButton, "Edit");
		action.type(WaiterPhone, EditPhone);
		action.type(WaiterEmail, EditEmail);
		action.click1(SubmitButton, "Submit");
	}
	public boolean ConfirmEdit()
	{
		boolean status=false;
		SearchWaiter();
		if((EditPhone.getText().equalsIgnoreCase(Phone1)) && (EditEmail.getText().equalsIgnoreCase(Email1)))
		{
			status=true;
		}
		return status;
	}
}
