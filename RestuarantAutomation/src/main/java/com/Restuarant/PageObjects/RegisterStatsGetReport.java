package com.Restuarant.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restuarant.BaseClass.Baseclass;

public class RegisterStatsGetReport extends Baseclass {

	WebDriver driver;

	@FindBy(xpath = "(//h3[@class='col-sm-12'])[3]")
	WebElement RegisterStatsTitle;

	@FindBy(xpath = "//span[@id='select2-StoresSelect-container']")
	WebElement RegisterList;

	@FindBy(xpath = "//input[@id='RegisterRange']")
	WebElement RegisterRange;

	@FindBy(xpath = "(//button[@class='applyBtn btn btn-sm btn-success'])[1]")
	WebElement ApplyButtonForRegisterStats;

	@FindBy(xpath = "//button[@class='btn btn-default hiddenpr']")
	WebElement GetReportCloseButton;

	@FindBy(xpath = "//button[@onclick='getRegisterReport()']")
	WebElement RegisterStatsReport;
	
	public RegisterStatsGetReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ReportForRegisterStats() throws InterruptedException {
		action.click1(RegisterList, "Register List");
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='select2-results__option']"));
		Thread.sleep(5000);
		for (WebElement register : list) {
			String registerName = register.getText();
			if (registerName.contains("Mubeena-Test")) {
				System.out.println("register name : " + registerName);
				action.click1(register, registerName);
				break;
			}
		}
		action.click1(RegisterRange, "Register Range");
		Thread.sleep(5000);
		action.type(RegisterRange, "12/11/2021 - 12/11/2022");
		action.click1(ApplyButtonForRegisterStats, "Apply");
		action.click1(RegisterStatsReport, "Get Report");
		action.click1(GetReportCloseButton, "Close");
	}

	public boolean IsRegisterStatsDisplayed() {
		return action.isDisplayed(driver, RegisterStatsTitle);
	}
}
