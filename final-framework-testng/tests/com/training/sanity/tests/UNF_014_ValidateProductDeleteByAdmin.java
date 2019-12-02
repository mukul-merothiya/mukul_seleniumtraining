package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
//import com.training.pom.LoginPOM;
import com.training.pom.UniformPOM;
//import com.training.pom.VerifyProdListPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_014_ValidateProductDeleteByAdmin {

	private WebDriver driver;
	private String baseUrl;
	private UniformPOM loginPOM;
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
		loginPOM = new UniformPOM(driver);
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
	public void validLoginTest() throws InterruptedException {
		
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		loginPOM.clickCatlogIconBtn();
		Thread.sleep(1000);
		loginPOM.clickProdLink();
		loginPOM.clickProdSubLink();
		Thread.sleep(1000);
		loginPOM.prodName("Blazer(II-V)");
		loginPOM.clickProductFilterButton();
		loginPOM.clickTableCheckBox();
		loginPOM.clickDeleteProduct();
	    Alert alertwindow=driver.switchTo().alert();
		String alertmessage=alertwindow.getText();
		Thread.sleep(1000);
		alertwindow.accept();

	   System.out.println(loginPOM.successAlertText());
		
		
		
	}
}
