package com.automation.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.FrameworkScript;
import com.automation.helper.ExcelHelper;

public class TC_001_CreateRecord extends FrameworkScript {
	
	@Test(dataProvider = "getTestData")
	public void createRecord(String userName, String password, String firstName, String lastName, String gender,
			String date, String month, String year, String address, String mobileNumber) throws Exception {

		// Login

		driver.get("https://demo.openmrs.org/openmrs/login.htm");

		driver.findElement(By.id("username")).sendKeys(userName);

		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.id("Registration Desk")).click();

		driver.findElement(By.id("loginButton")).click();

		Thread.sleep(1000);

		// Register

		driver.findElement(By.partialLinkText("Register a patient")).click();

		Thread.sleep(1000);

		driver.findElement(By.name("givenName")).sendKeys(firstName);

		driver.findElement(By.name("familyName")).sendKeys(lastName);

		Thread.sleep(1000);

		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.id("gender-field")).sendKeys(gender);

		Thread.sleep(1000);

		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.id("birthdateDay-field")).sendKeys(date);

		driver.findElement(By.id("birthdateMonth-field")).sendKeys(month);

		driver.findElement(By.id("birthdateYear-field")).sendKeys(year);

		Thread.sleep(1000);

		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.id("address1")).sendKeys(address);

		Thread.sleep(1000);

		driver.findElement(By.id("next-button")).click();

		driver.findElement(By.name("phoneNumber")).sendKeys(mobileNumber);

		Thread.sleep(1000);

		driver.findElement(By.id("next-button")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("next-button")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("submit")).click();

		WebElement webElement = driver.findElement(By.xpath("//em[text()='Patient ID']/../span"));

		String id = webElement.getText();

		Reporter.log(id);

		Assert.assertNotNull(id);

		Thread.sleep(10000);

		// Logout

		driver.findElement(By.partialLinkText("Logout")).click();

	}
	
	@DataProvider(name = "getTestData")
	public Object[][] getTestData() throws Exception {

		return ExcelHelper.getTestData("D:\\Testdata.xlsx", "Sheet1");
	}


}
