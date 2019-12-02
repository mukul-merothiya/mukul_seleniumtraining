package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.UniformMediumTCsPOM;
import com.training.pom.UniformPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class UNF_031 {
	private WebDriver driver;
	private String baseUrl1;
	private UniformMediumTCsPOM loginPOM;
	private static Properties properties;
	// private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new UniformMediumTCsPOM(driver);
		baseUrl1 = properties.getProperty("baseURL1");
		// screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl1);
	}
	

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

  @Test
  public void verifyloginError() throws InterruptedException {
	  loginPOM.clickMyAccountLink();
	  Thread.sleep(1000);
	  loginPOM.clickLoginLink();
	  loginPOM.sendEmail("neha@gmail.com");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		String warningMsg=loginPOM.getWarningTxt();
			if (warningMsg != null) {
			System.out.println(warningMsg);	
			System.out.println("login Failed");
				}
//			else {
//			       String S1=driver.findElement(By.xpath("//*[@id=\"top-links1\"]/ul/li[3]/a/span[1]")).getText();
//			       System.out.println(S1);
//			       if(S1 != null)
//			       {
//			    	   System.out.println("Login Successful");
//			    	   
//			       }
			}
			

      
		
		
	  
  }



