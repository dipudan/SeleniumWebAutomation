package page;

import core.BasePage;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Util;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	private static Logger log = Logger.getLogger(BasePage.class.getName());

	@FindBy(name = "email")
	private WebElement txtUsername;
	
	@FindBy(name = "passwd")
	private WebElement txtPassword;
	
	@FindBy(id = "SubmitLogin")
	private WebElement btnLogin;
	
	@FindBy(partialLinkText = "Sign in")
	private WebElement lnkSignIn;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

    @Step("Navigate to the login page.")
	public void navigateToSiginPage() {
		clickOnElement(lnkSignIn);
		try {
			Thread.sleep(5000);
		}catch(Exception e) {
			//log.error("Exception in thread sleep.");
		}
		log.info("Navigated to the Sigin page.");
	}

    @Step("Login to the application.")
	public void loginToApplication(String strJsonFileName) {
		enterTextInTextbox(txtUsername, Util.getJsonData("username", strJsonFileName));
		enterTextInTextbox(txtPassword, Util.getJsonData("password", strJsonFileName));
		clickOnElement(btnLogin);
		try {
			Thread.sleep(5000);
		}catch(Exception e) {
			//log.error("Failed in thread sleep.");
		}
	}
}
