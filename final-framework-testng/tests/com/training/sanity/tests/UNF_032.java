package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.UniformMediumTCsPOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class UNF_032 {
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
	  public void verifyloginScreenApprearWithoutPrelogin() throws InterruptedException {
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  Thread.sleep(3000);
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			loginPOM.clickBannerLink();
			 Thread.sleep(3000);
			 js.executeScript("window.scrollBy(0,600)");
			 //driver.findElement(By.xpath("//*[@id=\"featured-grid\"]/div[1]/div/div/div[2]/div[1]")).click();
			 loginPOM.clickFrameOnYellowTshirt();
//			Actions action=new Actions(driver);
//			WebElement addToCartBtn=driver.findElement(By.xpath("//*[@id=\\\"featured-grid\\\"]/div[1]/div/div/div[2]/div[2]/button[1]/span"));	
//			action.moveToElement(addToCartBtn).click().perform();
			
			
			 //loginPOM.clickAddToCartBtnForYellowTshirt();
			 
			 loginPOM.clickChestSize();
			 Thread.sleep(1000);
			 loginPOM.clickButtonCart();
			 Thread.sleep(1000);
			 loginPOM.clickCart();
			 loginPOM.clickViewCart();
			 Thread.sleep(1000);
			 //js.executeScript("window.scrollBy(0,400)");
			 loginPOM.clickCheckOutBtn();
			 System.out.println("Product is checked Out");
  
	  }
}
