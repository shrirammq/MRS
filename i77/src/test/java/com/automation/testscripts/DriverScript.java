package com.automation.testscripts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.FrameworkScript;
import com.automation.helper.ExcelHelper;
import com.automation.helper.ProjectHelper;

public class DriverScript extends FrameworkScript {

	@Test(dataProvider = "getTestData")
	public void execute(String tcName, String stepName, String action, String properties, String data) {

		WebElement webElement = null;

		// FindElement
		webElement = ProjectHelper.findElement(driver, properties);

		// Action
		ProjectHelper.execuetAction(driver, webElement, action, data);

	}

	@DataProvider(name = "getTestData")
	public Object[][] getTestData() throws Exception {
		return ExcelHelper.getTestData("D:\\KeywordDriven.xlsx", "Sheet1");
	}

}
