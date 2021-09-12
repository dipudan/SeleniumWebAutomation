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

	private static Logger log = Logger.getLogger(BasePage.class.getName());

	@FindBy(name = "email")
	private WebElement txtUsername;
	
	@FindBy(name = "passwd")
	private WebElement txtPassword;
	
	@FindBy(id = "SubmitLogin")
	private WebElement btnLogin;
	
	@FindBy(partialLinkText = "Sign in")
	private WebElement lnkSignIn;

	/**
	 * Initialise the driver object.
	 * @param driver : WebDriver Object
	 */
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Navigate to login page by clicking on the login link.
	 * '@Step' is used for logging the result to allure report.
	 */
    @Step("Navigate to the login page.")
	public void navigateToSiginPage() {
		clickOnElement(lnkSignIn);
		log.info("Navigated to the Sigin page.");
	}

	/**
	 * Login after entering the username and password.
	 * @param strJsonFileName : Testdata file.
	 */
    @Step("Login to the application.")
	public void loginToApplication(String strJsonFileName) {
		enterTextInTextbox(txtUsername, Util.getJsonData("username", strJsonFileName));
		enterTextInTextbox(txtPassword, Util.getJsonData("password", strJsonFileName));
		clickOnElement(btnLogin);
	}
}
