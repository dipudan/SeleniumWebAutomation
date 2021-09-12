package page;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Util;
import org.testng.Assert;

public class HomePage extends BasePage {

	@FindBy(xpath="//a[@title='View my customer account']/span")
	private WebElement lblUsername;

	/**
	 * Initialise the driver object.
	 * @param driver : Webdriver object
	 */
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Verify once the user login, the username is getting displayed in the home page.
	 * @param strJsonFileName : Testdata file.
	 * '@Step' is used for logging the result to allure report.
	 */
	@Step("Verify username is displayed in login page.")
	public void verifyUsername(String strJsonFileName) {
		String username = getValueFromLabel(lblUsername);
		Assert.assertEquals(username,Util.getJsonData("firstName", strJsonFileName) + " "
				+ Util.getJsonData("lastName", strJsonFileName));
	}

}
