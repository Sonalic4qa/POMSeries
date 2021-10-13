
	package com.qa.opencart.pages;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	import com.qa.opencart.utils.ElementUtil;

	public class LoginPage {

		private WebDriver driver;
		private ElementUtil elementUtil;

		// 1. By Locators - PO - OR
		private By emailId = By.id("input-email");
		private By password = By.id("input-password");
		private By loginButton = By.xpath("//input[@value='Login']");
		private By forgotPwdLink = By.linkText("Forgotten Password");
		private By registerLink = By.linkText("Register");
	
		// 2. page constructor:
		public LoginPage(WebDriver driver) {
			this.driver = driver;//This driver is given to element utl 
			elementUtil = new ElementUtil(driver);//bez we are using all elementUTl methods
		}

		// 3. page actions/methods/features:

		public String getLoginPageTitle() {
			return driver.getTitle();
		}

		public String getLoginPageUrl() {
			return driver.getCurrentUrl();
		}

		public boolean isForgotPwdlinkExist() {
			return elementUtil.doIsDiplayed(forgotPwdLink);
		}

		public boolean isRegisterlinkExist() {
			return elementUtil.doIsDiplayed(registerLink);
		}
		
		//concept of POM,page chaining Login page returning Account Page
		public AccountsPage doLogin(String un, String pwd) {
			elementUtil.doSendKeys(emailId, un);
			elementUtil.doSendKeys(password, pwd);
			elementUtil.doClick(loginButton);
			return new AccountsPage(driver);
		}

	}





