package com.training.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UniformMediumTCsPOM {

private WebDriver driver; 
	
	public UniformMediumTCsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	//Actions action=new Actions(driver);
	
	@FindBy(id="input-email")
	private WebElement email;
	@FindBy(id="input-password")
	private WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginButton;
	@FindBy(xpath="//*[@id=\"top-links1\"]/ul/li[3]/a")
	private WebElement clickMyAccount;
	@FindBy(xpath="//*[@id=\"top-links1\"]/ul/li[3]/ul/li[2]/a")
	private WebElement clickloginLink;
	
	@FindBy(xpath="/html/body/div[1]/div[1]")
	private WebElement warningMsg;
	
	@FindBy(xpath="//*[@id=\"banner0\"]/div/a/img")
	private WebElement bannerlink;
	
	@FindBy(xpath="//*[@id=\"featured-grid\"]/div[1]/div/div/div[2]/div[2]/button[1]/span")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"featured-grid\"]/div[1]/div/div/div[2]/div[1]")
	private WebElement clickFrameOnYellowTshirt;
	
	@FindBy(xpath="//*[@id=\"top-links1\"]/ul/li[3]/a/span[2]")
	private WebElement clickAccountLogin;
	
	public void accountLoginButton()
	{
		this.clickAccountLogin.click();
	}
	
	
	@FindBy(xpath="//*[@id=\"top-links1\"]/ul/li[3]/ul/li[2]/a")
	private WebElement loginlink;
	
	public void loginLinkClick()
	{
		this.loginlink.click();
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	private WebElement loginbutton;
	
	public void loginButton()
	{
		this.loginButton.click();
	}
	
	@FindBy(xpath="//*[@id=\"logo\"]/h1/a")
	private WebElement logo;
	
	public void clicklogo()
	{
		this.logo.click();
	}
	
	
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	
	public void clickLoginBtn() {
		this.loginButton.click(); 
	}

	public void clickMyAccountLink() {
		this.clickMyAccount.click();
	}
	public void clickLoginLink() {
		this.clickloginLink.click();
	}
	
	public String getWarningTxt()
	{
		return this.warningMsg.getText();
	}
	
	public void clickBannerLink() {
		this.bannerlink.click();
	}

	
	public void clickAddToCartBtnForYellowTshirt() {
		this.addToCartBtn.click();
		//action.moveToElement(addToCartBtn).click().perform();
	}
	
	public void clickFrameOnYellowTshirt() {
		this.clickFrameOnYellowTshirt.click();
		//action.moveToElement(addToCartBtn).click().perform();
	}
	
	@FindBy(xpath="//*[@id=\"input-option382\"]")
    private WebElement chestSize;
	
	public void clickChestSize()
	{
		this.chestSize.click();
		Select selectProduct = new Select(chestSize);
		selectProduct.selectByIndex(3);
		this.chestSize.click();
	}
	
	@FindBy(xpath="//*[@id=\"button-cart\"]")
    private WebElement buttonCart;
	
	public void clickButtonCart() {
		this.buttonCart.click();
		//action.moveToElement(addToCartBtn).click().perform();
	}
	@FindBy(xpath="//*[@id=\"cart\"]")
    private WebElement Cart;
	
	public void clickCart() {
		this.Cart.click();
		
	}
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")
    private WebElement viewCart;
	
	public void clickViewCart() {
		this.viewCart.click();
		
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[2]/a")
    private WebElement checkOutBtn;
	
	public void clickCheckOutBtn() {
		this.checkOutBtn.click();
		
	}
	
	@FindBy(xpath="//*[@id=\"featured-grid\"]/div[2]/div/div/div[1]/a/img")
	private WebElement clickFrameOnRedTshirt;
	
	public void clickAddToCartBtnForRedTshirt() {
		this.clickFrameOnRedTshirt.click();
		//action.moveToElement(addToCartBtn).click().perform();
	}
	
	@FindBy(xpath="//*[@id=\"input-option376\"]")
    private WebElement redchestSize;
	
	public void clickRedChestSize()
	{
		this.redchestSize.click();
		Select selectProduct = new Select(redchestSize);
		selectProduct.selectByIndex(3);
		this.redchestSize.click();
	}
	
	@FindBy(id="button-login")
	private WebElement loginButtonCheckOut;
	
	public void clickloginButtonOnCheckOut()
	{
				this.loginButtonCheckOut.click();
	}
	
	@FindBy(id="button-payment-address")
	private WebElement continueButtonPaymentAddress;
	
	public void clickContinueButtonPaymentAddress()
	{
				this.continueButtonPaymentAddress.click();
	}
	
	@FindBy(id="button-shipping-address")
	private WebElement continueButtonShippingAddress;
	
	public void clickContinueButtonShippingAddress()
	{
				this.continueButtonShippingAddress.click();
	}
	@FindBy(xpath="//*[@id=\"collapse-shipping-method\"]/div/p[4]/textarea")
	private WebElement deliveryMethodComment;
	
	public void deliveryMethodComment(String comments)
	{
				this.deliveryMethodComment.sendKeys(comments);
	}
	@FindBy(id="button-shipping-method")
	private WebElement continueButtonShippingMethod;
	
	public void clickContinueButtonShippingMethod()
	{
				this.continueButtonShippingMethod.click();
	}
	
	@FindBy(xpath="//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")
	private WebElement readAndAgree;
	
	public void clickReadandAgreeCheckbox()
	{
				this.readAndAgree.click();
	}
	@FindBy(id="button-payment-method")
	private WebElement continueButtonPaymentMethod;
	
	public void clickContinueButtonPaymentMethod()
	{
				this.continueButtonPaymentMethod.click();
	}
	@FindBy(id="button-confirm")
	private WebElement buttonConfirm;
	
	public void clickButtonConfirm()
	{
				this.buttonConfirm.click();
	}
	@FindBy(xpath="//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label/input")
	private WebElement guestRadiobutton;
	
	public void clickGuestRadioButton()
	{
				this.guestRadiobutton.click();
	}

	
	@FindBy(id="button-account")
	private WebElement continueButtonAccount;
	
	public void clickContinueButtonAccount()
	{
				this.continueButtonAccount.click();
	}
	
	@FindBy(id="input-payment-firstname")
	private WebElement paymentFirstName;
	
	public void sendPaymentFirstName(String paymentFirstName)
	{
				this.paymentFirstName.sendKeys(paymentFirstName);
	}
	
	@FindBy(id="input-payment-lastname")
	private WebElement paymentLastName;
	
	public void sendPaymentlastName(String PaymentLastName)
	{
				this.paymentLastName.sendKeys(PaymentLastName);
	}
	
	@FindBy(id="input-payment-address-1")
	private WebElement paymentAddress1;
	
	public void sendPaymentAddress1(String Address1)
	{
				this.paymentAddress1.sendKeys(Address1);
	}
	@FindBy(id="input-payment-email")
	private WebElement paymentEmail;
	
	public void sendPaymentEmail(String Email)
	{
				this.paymentEmail.sendKeys(Email);
	}
	@FindBy(xpath="//*[@id=\"input-payment-telephone\"]")
	private WebElement paymentTelephone;
	
	public void sendPaymentTelephone(String paymentTelephone)
	{
				this.paymentTelephone.sendKeys(paymentTelephone);
	}
	@FindBy(id="input-payment-city")
	private WebElement paymentCity;
	
	public void sendPaymentCity(String paymentcity)
	{
				this.paymentCity.sendKeys(paymentcity);
	}
	@FindBy(id="input-payment-postcode")
	private WebElement paymentPostcode;
	
	public void sendPaymentPasscode(String paymentPostcode)
	{
				this.paymentPostcode.sendKeys(paymentPostcode);
	}
	@FindBy(id="input-payment-country")
    private WebElement paymentCountry;
	
	public void selectPaymentCountry()
	{
		this.paymentCountry.click();
		Select selectProduct = new Select(paymentCountry);
		selectProduct.selectByVisibleText("India");
		this.paymentCountry.click();
	}
	@FindBy(id="input-payment-zone")
    private WebElement paymentState;
	
	public void selectPaymentState()
	{
		this.paymentState.click();
		Select selectProduct = new Select(paymentState);
		selectProduct.selectByVisibleText("Karnataka");
		this.paymentState.click();
	}
	
	@FindBy(id="button-guest")
	private WebElement continueButtonGuest;
	
	public void clickContinueButtonGuest()
	{
				this.continueButtonGuest.click();
	}
	
	
	
	
	
	
	
	
}
