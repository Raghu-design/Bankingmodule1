package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class TC_LoginTest_001 extends BaseClass {

	 @Test
	public void loginTest() throws InterruptedException, IOException
	
	{
	  
		logger.info("URL is Opened");
		  
		  LoginPage lp=new LoginPage(driver);
		  
		  Thread.sleep(2000);
		  lp.clickBankDomain();
		  Thread.sleep(2000);
		  lp.setUserName(username);
		  logger.info("Entered username");
		  lp.setPassword(password);
		  logger.info("Entered password");
		  lp.clickSubmit();
		  logger.info("clicked Submit");
		  Thread.sleep(5000);
		  
	  if(driver.getCurrentUrl().equals("http://demo.guru99.com/V1/html/Managerhomepage.php"))
	  {
	    Assert.assertTrue(true);
		logger.info("Login test passed");
		    
	  }
	  else
	 {
		  captureScreen(driver,"loginTest");
		  Assert.assertTrue(false);
		  logger.info("Login test failed");
	  }
		
	}
}
