package com.w2sa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2sa.base.TestBase;

public class AddCustomerTest extends TestBase {

	@Test(dataProvider="getData")
	public void addCustomer(String firstName, String lastName, String postCode, String alertext) throws InterruptedException {

		driver.findElement(By.xpath(OR.getProperty("addCustomerBtn"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(firstName);
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastName);
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postCode);
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("addBtn"))).click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(alertext));

		alert.accept();
	}
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetname = "AddCustomerTest";
		int rows = excel.getRowCount(sheetname);
		int cols = excel.getColumnCount(sheetname);
		
		Object[][] data = new Object[rows-1][cols];
		
		for(int rowNum = 2; rowNum<=rows; rowNum ++) {
			for(int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetname,colNum,rowNum);
			}
		}
		return data; 
	}
}
