package com.inetbanking.testCases;
import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;




public class TC_LoginTest_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		LoginPage login=new LoginPage(driver);
		login.clickBankDomain();
		Thread.sleep(200);
		login.setUserName(user);
		logger.info("user name provided");
		login.setPassword(pwd);
		logger.info("password provided");
		login.clickSubmit();
		Thread.sleep(6000);
		
		if(isAlertPresent()==true)
		{
				
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");
			}
		
	}
	

	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/TestData.xlsx";
		
		int rownum=XLUtils.getRowCount(path,"data");
		int colcount=XLUtils.getCellCount(path,"data",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
			
		{
			
			for(int j=0;j<colcount;j++)
				
			{
				
				logindata[i-1][j]=XLUtils.getCellData(path,"data",i,j);
			}
			
		}
			return logindata;	
		}
		
	
		
				
			
		}
			



