package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UniformPOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_015_VerifyFilterOrderDetailsByAdmin {

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
		Thread.sleep(1000);
		loginPOM.salesIcon();
		loginPOM.clickOrderLink();
		Thread.sleep(1000);
		loginPOM.clickOrderStatus();
		loginPOM.sendDateAdded("2019-11-19");
		loginPOM.sendDateModified("2019-11-19");
		/*driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/div/div[3]/div[1]/div/span/button"))
		.click();
driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/table/tbody/tr[4]/td[3]")).click();
driver.findElement(
		By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div[1]/div/div[3]/div[2]/div/span/button/i")).click();
driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/table/tbody/tr[4]/td[3]")).click();*/
loginPOM.clickOrderFilterButton();
WebElement tableobj = driver.findElement(By.xpath("//*[@id=\"form-order\"]/div/table"));
List<WebElement> rows = tableobj.findElements(By.tagName("tr"));
int rowcount = rows.size();
System.out.println("No. of Actual Rows in table = " + rowcount);
int filteredrows=rowcount-1;
System.out.println("Total Number of Data Rows "+filteredrows);
Iterator<WebElement> i = rows.iterator();
while (i.hasNext()) {
	WebElement row = i.next();

	List<WebElement> columns = row.findElements(By.tagName("td"));
	Iterator<WebElement> j = columns.iterator();
	int count = 0;
	String thirdcol = "";
	String fifthcol = "";
	while (j.hasNext()) {
		WebElement column = j.next();

		if (count == 3) {
			thirdcol = column.getText();

		} else if (count == 5) {
			fifthcol = column.getText();
			
		}

		else if (count == 6) {
			String sixthcol = column.getText();
			break;
		}
		
		if (thirdcol.equals("Pending") && fifthcol.equals("19/11/2019")) {
			filtercounter++;
		}
  	count++;
		

	}
	
	
	
}
System.out.println("Returned Filtered Rows " + filtercounter);
if (filtercounter == filteredrows) {
	System.out.println("Filters are working fine");
}

	
		
		

	}
}
