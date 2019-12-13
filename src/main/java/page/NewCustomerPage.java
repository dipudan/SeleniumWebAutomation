package page;

import core.BasePage;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Util;

public class NewCustomerPage extends BasePage {
	
	private WebDriver driver;
	private static Logger log = Logger.getLogger(NewCustomerPage.class.getName());
	
	@FindBy(id="customer_firstname")
	private WebElement txtCustomername;
	
	@FindBy(name="email_create")
	private WebElement txtCreateEmail;
	
	@FindBy(id="SubmitCreate")
	private WebElement btnCreateAccount;
	
	public NewCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@Step("Navigate to new user creation page.")
	public void navigateToCustomerCreationPage(String strJsonFileName) {
		log.info("Navigated to customer creation page.");
		txtCreateEmail.sendKeys(Util.getJsonData("emailId", strJsonFileName));
		btnCreateAccount.click();
	}

	@Step("Create customer.")
	public void createCustomer(String strJsonFileName) {
		enterTextInTextbox(txtCustomername, Util.getJsonData("customerName", strJsonFileName));
		log.info("Customer created successfully.");
		saveScreenshot(driver);
	}

}
