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
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class UNF_071 {
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
		loginPOM1 = new UniformPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		// screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void verifyAdminCanAddMultipleProductsWithRewardPoint() throws InterruptedException {
		loginPOM1.sendUserName("admin");
		loginPOM1.sendPassword("admin@123");
		loginPOM1.clickLoginBtn();
		loginPOM1.clickCatlogIconBtn();
		Thread.sleep(3000);
		loginPOM1.clickProdLink();
		loginPOM1.clickProdSubLink();
		

		loginPOM1.clickAddNewProduct();
		loginPOM1.sendProductName("Denim Blazer(2 to 3Yrs");
		loginPOM1.sendMetaTagTitle("Blazer");
		loginPOM1.clickDataTab();
		loginPOM1.sendModel("T000123");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		Actions action=new Actions(driver);
		WebElement price=driver.findElement(By.id("input-price"));
		action.moveToElement(price).click().perform();
		//driver.findElement(By.id("input-price")).sendKeys("24");
		price.sendKeys("24");
		//loginPOM1.sendPrice("245");
		WebElement qty=driver.findElement(By.id("input-quantity"));
		action.moveToElement(qty).click().perform();
		qty.clear();
		qty.sendKeys("8");
		//loginPOM1.sendQuantity("8");
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		Thread.sleep(1000);
		loginPOM1.clickLinkTab();
/*		loginPOM1.clickCategories();
		loginPOM1.selectCategories();*/
		WebElement S1=driver.findElement(By.id("input-category"));
		S1.click();
//		Select selectProduct = new Select(S1);
//		selectProduct.selectByIndex(0);
		
		driver.findElement(By.xpath("//*[@id=\'tab-links\']/div[2]/div/ul/li[1]")).click();
		
		//List<WebElement>producttotal=selectProduct.getOptions();
		
		//System.out.println("Total number of elements "+producttotal.size());
		
		loginPOM1.clickdiscountTab();
		loginPOM1.clickAddDiscount();
		loginPOM1.sendDiscountQty("2");
		loginPOM1.sendDiscountPrice("15");
		loginPOM1.sendDiscountStartDate("2019-12-03");
		loginPOM1.sendDiscountEndDate("2019-12-04");
		loginPOM1.clickRewardPointTab();
		loginPOM1.sendrewardPoint("1000");
		loginPOM1.clickSaveBtn();
		String Message=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]")).getText();
		System.out.println(Message);
		
		
		
		
		
		}


}
		
	

