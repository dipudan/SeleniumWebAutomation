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
	
	private WebDriver driver;
	@FindBy(xpath="//a[@title='View my customer account']/span")
	private WebElement lblUsername;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@Step("Verify username is displayed in login page.")
	public void verifyUsername(String strJsonFileName) {
		String username = getValueFromLabel(lblUsername);
		Assert.assertEquals(username,Util.getJsonData("firstName", strJsonFileName) + " "
				+ Util.getJsonData("lastName", strJsonFileName));

	}

}
