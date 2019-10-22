package com.w2sa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2sa.base.TestBase;

public class BankMngrLoginTest extends TestBase {

	@Test
	public void loginAsBankMgr() throws InterruptedException {
		log.debug("Inside login Test");
		Thread.sleep(4000);	
		driver.findElement(By.xpath(OR.getProperty("bmloginBtn"))).click();
		
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("bmloginBtn"))), "Login unsuccessful");
		log.debug("Login successfull");
		}
}
