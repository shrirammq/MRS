package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class RegisterPage {

	@FindBy(partialLinkText = "Register a patient")
	private WebElement lnkRegister = null;

	@FindBy(name = "givenName")
	private WebElement txtFirstName = null;

	@FindBy(name = "familyName")
	private WebElement txtLastName = null;

	@FindBy(id = "next-button")
	private WebElement btnNext = null;

	@FindBy(id = "gender-field")
	private WebElement lstGender = null;

	@FindBy(id = "birthdateDay-field")
	private WebElement txtDate = null;

	@FindBy(id = "birthdateMonth-field")
	private WebElement lstMonth = null;

	@FindBy(id = "birthdateYear-field")
	private WebElement txtYear = null;

	@FindBy(id = "address1")
	private WebElement txtAddress = null;

	@FindBy(name = "phoneNumber")
	private WebElement txtMobileNumber = null;

	@FindBy(id = "submit")
	private WebElement btnConfirm = null;

	@FindBy(xpath = "//em[text()='Patient ID']/../span")
	private WebElement webElement = null;
	
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void createRecord(String firstName, String lastName, String gender,
			String date, String month, String year, String address, String mobileNumber) throws Exception {

		lnkRegister.click();

		Thread.sleep(1000);

		txtFirstName.sendKeys(firstName);

		txtLastName.sendKeys(lastName);

		Thread.sleep(1000);

		btnNext.click();

		lstGender.sendKeys(gender);

		Thread.sleep(1000);

		btnNext.click();

		txtDate.sendKeys(date);

		lstMonth.sendKeys(month);

		txtYear.sendKeys(year);

		Thread.sleep(1000);

		btnNext.click();

		txtAddress.sendKeys(address);

		Thread.sleep(1000);

		btnNext.click();

		txtMobileNumber.sendKeys(mobileNumber);

		Thread.sleep(1000);

		btnNext.click();

		Thread.sleep(1000);

		btnNext.click();

		Thread.sleep(1000);

		btnConfirm.click();

		String id = webElement.getText();

		Reporter.log(id);

		Assert.assertNotNull(id);

		Thread.sleep(10000);

	}

}
