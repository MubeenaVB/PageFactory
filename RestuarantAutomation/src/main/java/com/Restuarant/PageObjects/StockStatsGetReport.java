package com.Restuarant.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restuarant.BaseClass.Baseclass;

public class StockStatsGetReport extends Baseclass {

	WebDriver driver;

	@FindBy(xpath = "(//h3[@class='col-sm-12'])[4]")
	WebElement StockStatsTitle;

	@FindBy(xpath = "//span[@id='select2-StockSelect-container']")
	WebElement StockList;

	@FindBy(xpath = "//button[@class='btn btn-default hiddenpr']")
	WebElement GetReportCloseButton;

	@FindBy(xpath = "//button[@onclick='getStockReport()']")
	WebElement StockStatsReport;
	
	@FindBy(xpath="(//input[@class='form-control'])[4]")
	WebElement DaterRange;
	
	public StockStatsGetReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ReportForStockStats() throws InterruptedException {
		Thread.sleep(3000);
		action.click1(StockList, "Stock List");
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='select2-results__option']"));
		Thread.sleep(5000);
		for (WebElement stock : list) {
			String stockName = stock.getText();
			if (stockName.contains("Disney")) {
				System.out.println("Stock name : " + stockName);
				action.click1(stock, stockName);
				break;
			}
		}
		action.isEnabled(driver, DaterRange);//should be disables 		
		action.click1(StockStatsReport, "Get Report");
		action.click1(GetReportCloseButton, "Close");
	}

	public boolean IsStockStatsDisplayed() {
		return action.isDisplayed(driver, StockStatsTitle);
	}
}
