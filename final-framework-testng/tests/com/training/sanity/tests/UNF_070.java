package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.UniformComplexTCsPOM;
import com.training.pom.UniformMediumTCsPOM;
import com.training.pom.UniformPOM;
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

public class UNF_070 {
	private WebDriver driver;
	private String baseUrl1;
	private String baseUrl;
	private UniformComplexTCsPOM loginPOM;
	private UniformPOM loginPOM1;
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
		loginPOM = new UniformComplexTCsPOM(driver);
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
	  public void verifyPreloginUserCanPlaceOrder() throws InterruptedException {
		  loginPOM.accountLoginButton();
		  Thread.sleep(1000);
		  
		  loginPOM.loginLinkClick();
			 loginPOM.sendEmail("medhu@gmail.com");
			loginPOM.sendPassword("admin@123");
			loginPOM.loginButton();
			loginPOM.clicklogo();
		  
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  Thread.sleep(3000);
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			loginPOM.clickBannerLink();
			 Thread.sleep(3000);
			 js.executeScript("window.scrollBy(0,600)");
			 //driver.findElement(By.xpath("//*[@id=\"featured-grid\"]/div[1]/div/div/div[2]/div[1]")).click();
			 loginPOM.clickAddToCartBtnForRedTshirt();
//			Actions action=new Actions(driver);
//			WebElement addToCartBtn=driver.findElement(By.xpath("//*[@id=\\\"featured-grid\\\"]/div[1]/div/div/div[2]/div[2]/button[1]/span"));	
//			action.moveToElement(addToCartBtn).click().perform();
			
			
			 //loginPOM.clickAddToCartBtnForYellowTshirt();
			 
			 loginPOM.clickRedChestSize();
			 Thread.sleep(1000);
			 loginPOM.clickButtonCart();
			 Thread.sleep(1000);
			 loginPOM.clickCart();
			 loginPOM.clickViewCart();
			 Thread.sleep(1000);
			 //js.executeScript("window.scrollBy(0,400)");
			 loginPOM.clickCheckOutBtn();
			 System.out.println("Product is checked Out");
			 //loginPOM.sendEmail("medhu@gmail.com");
				//loginPOM.sendPassword("admin@123");
				//loginPOM.clickloginButtonOnCheckOut();
				loginPOM.clickContinueButtonPaymentAddress();
				Thread.sleep(1000);
				loginPOM.clickContinueButtonShippingAddress();
				loginPOM.deliveryMethodComment("Please Deliver between 7am to 10 am");
				loginPOM.clickContinueButtonShippingMethod();
				Thread.sleep(1000);
				loginPOM.clickReadandAgreeCheckbox();
				System.out.println("Conditions Agreed");
				loginPOM.clickContinueButtonPaymentMethod();
				loginPOM.clickButtonConfirm();
				
				driver = DriverFactory.getDriver(DriverNames.CHROME);
				loginPOM1 = new UniformPOM(driver);
				baseUrl = properties.getProperty("baseURL");
				// screenShot = new ScreenShot(driver);
				// open the browser
				driver.get(baseUrl);
				//login as an administrator
				loginPOM1.sendUserName("admin");
				loginPOM1.sendPassword("admin@123");
				loginPOM1.clickLoginBtn();
				loginPOM1.clickCatlogIconBtn();
				Thread.sleep(3000);
				//loginPOM1.clickProdLink();
				//loginPOM1.clickProdSubLink();
				//loginPOM.clickAddNewBtn();
				//loginPOM.sendProductName("Denim Trouser");
				//loginPOM.sendMetaTitle("Trouser");
				Thread.sleep(1000);
				loginPOM1.salesIcon();
				loginPOM1.clickOrderLink();
				//Thread.sleep(1000);
				loginPOM = new UniformComplexTCsPOM(driver);
				loginPOM.clickOrderViewEye();
				//driver.findElement(By.xpath("//*[@id=\"form-order\"]/div/table/tbody/tr[1]/td[8]/a[1]")).click();
				JavascriptExecutor js1=(JavascriptExecutor)driver;
				js1.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				loginPOM.clickOrderStatus();
				loginPOM.clickHistoryButton();
				
				driver = DriverFactory.getDriver(DriverNames.CHROME);
				loginPOM = new UniformComplexTCsPOM(driver);
				baseUrl1 = properties.getProperty("baseURL1");
				// screenShot = new ScreenShot(driver);
				// open the browser
				driver.get(baseUrl1);
				loginPOM.accountLoginButton();
				Thread.sleep(1000);
				loginPOM.loginLinkClick();
					 loginPOM.sendEmail("medhu@gmail.com");
					loginPOM.sendPassword("admin@123");
					loginPOM.loginButton();
					//loginPOM.clicklogo();
					loginPOM.accountLoginButton();
					Thread.sleep(1000);
				  loginPOM.clickOrderHistory();
  
	  }
}
