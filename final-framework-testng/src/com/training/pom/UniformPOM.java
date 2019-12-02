package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UniformPOM {
	private WebDriver driver; 
	
	public UniformPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id=\'content\']/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"input-name\"]")
	private WebElement prodName;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	@FindBy(xpath="//*[@id=\'button-menu\']")
	private WebElement catlogiconBtn; 
	
	@FindBy(xpath="//*[@id=\"catalog\"]/a/span")
	private WebElement prodLink; 
	
	@FindBy(xpath="//*[@id=\"catalog\"]/ul/li[2]/a")
	private WebElement prodLink1;
	
	@FindBy(xpath="//*[@id=\"form-product\"]/div/table/tbody/tr[1]/td[1]/input")
	private WebElement tableChkbox;
	
	@FindBy(id="button-filter")
	private WebElement buttonFilter;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button[2]")
	private WebElement deleteProduct;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
	private WebElement successText;
	
	@FindBy(xpath="//*[@id=\"sale\"]/a/span")
	private WebElement salesIcon;
	
	
	public void clickCatlogIconBtn() {
		this.catlogiconBtn.click();
	}
	public void clickProdLink() {
		this.prodLink.click(); 
	}
	public void clickProdSubLink() {
		this.prodLink1.click(); 
	}
	
	public void prodName(String prodName) {
		this.prodName.sendKeys(prodName);
		
	}
	public void clickProductFilterButton()
	{
		this.buttonFilter.click();
	}
	public void clickTableCheckBox()
	{
		this.tableChkbox.click();
	}
	public void clickDeleteProduct()
	{
		this.deleteProduct.click();
	}
	
	public String successAlertText()
	{
		return this.successText.getText();
		
	}
	public void salesIcon()
	{
		this.salesIcon.click();
	}
	@FindBy(xpath="//*[@id=\"sale\"]/ul/li[1]/a")
    private WebElement orderLink;
	
	public void clickOrderLink()
	{
		this.orderLink.click();
	}
	
	@FindBy(id="input-order-status")
    private WebElement orderStatus;
	
	public void clickOrderStatus()
	{
		this.orderStatus.click();
		Select selectProduct = new Select(orderStatus);
		selectProduct.selectByVisibleText("Pending");
	}
	
	@FindBy(id="button-filter")
	private WebElement buttonOrderFilter;
	
	public void clickOrderFilterButton()
	{
		this.buttonOrderFilter.click();
	}
	
	
	@FindBy(id="input-date-added")
	private WebElement dateAdded;
	
	public void sendDateAdded(String dateAdded) {
		this.dateAdded.clear(); 
		this.dateAdded.sendKeys(dateAdded); 
	}
	
	@FindBy(id="input-date-modified")
	private WebElement dateModified;
	
	public void sendDateModified(String dateModified) {
		this.dateModified.clear(); 
		this.dateModified.sendKeys(dateModified); 
	}
	
	
	
}



