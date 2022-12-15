package com.Restuarant.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restuarant.BaseClass.Baseclass;

public class ClientStatsGetReport extends Baseclass {

	WebDriver driver;

	@FindBy(xpath = "(//h3[@class='col-sm-12'])[1]")
	WebElement ClientStatsTitle;

	@FindBy(xpath = "//span[@id='select2-customerSelect-container']")
	WebElement clientList;

	@FindBy(xpath = "(//h3[@class='col-sm-12'])[2]")
	WebElement productList;

	@FindBy(xpath = "(//h3[@class='col-sm-12'])[3]")
	WebElement storeListForRegisterStats;

	@FindBy(xpath = "(//h3[@class='col-sm-12'])[4]")
	WebElement storeListForStockStats;

	@FindBy(xpath = "//input[@id='CustomerRange']")
	WebElement CustomerRange;

	@FindBy(xpath = "(//button[@class='applyBtn btn btn-sm btn-success'])[1]")
	WebElement ApplyButtonForClientStats;

	@FindBy(xpath = "//button[@onclick='getCustomerReport()']")
	WebElement ClientStatsReport;

	@FindBy(xpath = "//button[@class='btn btn-default hiddenpr']")
	WebElement GetReportCloseButton;
	
	public ClientStatsGetReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ReportForClientStats() throws InterruptedException {
		action.click1(clientList, "Client List");
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='select2-results__option']"));
		Thread.sleep(5000);
		for (WebElement client : list) {
			String clientName = client.getText();
			if (clientName.contains("happy")) {
				System.out.println("client name : " + clientName);
				action.click1(client, clientName);
				break;
			}
		}
		action.click1(CustomerRange, "Customer Range");
		Thread.sleep(5000);
		action.type(CustomerRange, "12/11/2021 - 12/11/2022");
		action.click1(ApplyButtonForClientStats, "Apply");
		action.click1(ClientStatsReport, "Get Report");
		action.click1(GetReportCloseButton, "Close");
	}

	/*
	 * public void SelectFromDropDown(WebElement clientList2) { String
	 * input=clientList2; List<WebElement> selectClient =
	 * driver.findElements(By.xpath(clientList2)); for(WebElement
	 * client:selectClient) { String clientName=client.getText();
	 * if(clientName.equalsIgnoreCase("happy")) { action.click1(client, clientName);
	 * } } }
	 */

	public boolean IsClientStatsDisplayed() {
		return action.isDisplayed(driver, ClientStatsTitle);
	}
}
