package com.Restuarant.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Restuarant.BaseClass.Baseclass;

public class ReportsPage extends Baseclass {

	WebDriver driver;

	@FindBy(xpath = "(//span[@class='icon-bar'])[1]")
	WebElement menu;

	@FindBy(xpath = "//i[@class='fa fa-line-chart']")
	WebElement Reports;

	@FindBy(xpath = "//h1[@class='statYear']")
	WebElement CurrentYear;

	@FindBy(xpath = "(//button[@class='btn btn-Year'])[1]")
	WebElement PrevYearArrow;

	//@FindBy(xpath = "(//button[@class='btn btn-Year'])[2]")
	@FindBy(xpath="(//button[@type='button'])[3]")
	WebElement NextYearArrow;

	@FindBy(css = "img[alt='logo']")
	WebElement Logo;
	
	public ReportsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Reports() throws InterruptedException {
		Thread.sleep(3000);
		action.click1(menu, "Menu option");
		action.click1(Reports, "REports option");
	}

	public int Currentyear() throws InterruptedException {
		Thread.sleep(3000);
		String CY = CurrentYear.getText();
		int cy = Integer.parseInt(CY);
		return cy;
	}

	public boolean PreviosYear() throws InterruptedException {
		boolean status = false;
		int currentYear = Currentyear();

		action.click1(PrevYearArrow, "Previous Year");
		Thread.sleep(3000);
		String PY = CurrentYear.getText();
		int py = Integer.parseInt(PY);
		if (py == (currentYear - 1)) {
			status = true;
		}
		return status;
	}

	public boolean NextYear() throws InterruptedException {
		boolean status = false;
		int currentYear = Currentyear();

		action.type(NextYearArrow, "Next Year");
		Thread.sleep(3000);
		String NY = CurrentYear.getText();
		int ny = Integer.parseInt(NY);
		if (ny == (currentYear + 1)) {
			status = true;
		}
		return status;
	}

	public boolean IsLogoPresent() throws InterruptedException {
		Thread.sleep(3000);
		return action.isDisplayed(driver, Logo);
	}
}
