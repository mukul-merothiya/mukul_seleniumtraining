package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.training.generics.ScreenShot;
//import com.training.pom.LoginPOM;
import com.training.pom.UniformPOM;
//import com.training.pom.VerifyProdListPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_013_VerifyProductFilterByAdmin {

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
		int filtercounter = 0;
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		loginPOM.clickCatlogIconBtn();
		Thread.sleep(3000);
		loginPOM.clickProdLink();
		loginPOM.clickProdSubLink();
		loginPOM.prodName("Blazer Girls(7-8)");
		loginPOM.clickProductFilterButton();
		
		WebElement tableobj = driver.findElement(By.id("form-product"));
		List<WebElement> rows = tableobj.findElements(By.tagName("tr"));
		int rowcount = rows.size();
		System.out.println("No. of Actual Rows in table = " + rowcount);
		int filteredrows = rowcount - 1;
		System.out.println("Total Number of Data Rows " + filteredrows);
		Iterator<WebElement> i = rows.iterator();
		while (i.hasNext()) {
			WebElement row = i.next();

			List<WebElement> columns = row.findElements(By.tagName("td"));
			Iterator<WebElement> j = columns.iterator();
			int count = 0;
			String thirdcol = "";
			while (j.hasNext()) {
				WebElement column = j.next();

				if (count == 2) {
					thirdcol = column.getText();
					System.out.println(thirdcol);
					if (thirdcol.equals("Blazer Girls(7-8)")) {
						filtercounter++;
					break;
				}
			
				}
				
				count++;
			}

			// screenShot.captureScreenShot("First");
			
		}
		System.out.println("Returned Filtered Rows " + filtercounter);
		if (filtercounter == filteredrows) {
			System.out.println("Product Filter is working fine");
		}

	}
}

