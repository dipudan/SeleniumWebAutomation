package core;

import java.time.Duration;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {


	/**
	 * Use below methods when we don't need to execute in the grid/remote infrastructure.
	 */
	protected static ThreadLocal<ChromeDriver> driver = new ThreadLocal<ChromeDriver>();

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",Util.getConfigPropertyAsString("ChromeDriverPath"));
		driver.set(new ChromeDriver());
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.getConfigPropertyAsInt("ImplicitWait")));
		driver.get().manage().window().maximize();
		driver.get().get(Util.getConfigPropertyAsString("ApplicationURL"));
	}


//	protected static ThreadLocal<RemoteWebDriver> driver= new ThreadLocal<>();
//	private CapabilityFactory capabilityFactory = new CapabilityFactory();
//
//	//Below values are used to run the test in BrowserStack.
//	public static final String USERNAME = "dipukrishnan1";
//	public static final String AUTOMATE_KEY = "";
//	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
//
//	/**
//	 * Executes the test in the remote machine.
//	 * @param browser : Browser on which test run happens.
//	 * @param environment : Environment on which test execution happens.
//	 * @throws MalformedURLException
//	 */
//	@BeforeMethod
//	@Parameters({"browser","environment"})
//	public void launchBrowser (String browser,String environment) throws MalformedURLException {
//		if(environment.equalsIgnoreCase("Local")){
//			driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
//					capabilityFactory.getCapabilities(browser)));
//		}else {
//			driver.set(new RemoteWebDriver(new URL("http://3.15.38.99:4444/wd/hub"),
//					capabilityFactory.getCapabilities(browser)));
//		}
//		driver.get().manage().timeouts().implicitlyWait(Util.getConfigPropertyAsInt("ImplicitWait"),TimeUnit.SECONDS);
//		driver.get().manage().window().maximize();
//		driver.get().get(Util.getConfigPropertyAsString("ApplicationURL"));
//	}

	/**
	 * No argument constructor. Explicitly mentioned as child classes
	 * has different argument constructors.
	 */
	public BasePage() {
		
	}

	/**
	 * Getter method for retrieving the driver object.
	 * @return WebDriver : Driver Object.
	 */
	protected WebDriver getDriver() {return driver.get();}

	/**
	 * Perform the operation of clicking webpage element supplied as parameter.
	 * @param wElement : Locator of webelement.
	 */
	protected void clickOnElement(WebElement wElement) {
		wElement.click();
		Reporter.log("Clicked on link.");
	}

	/**
	 * Perform the operation of entering value to a textbox.
	 * @param wElement : Locator of webelement.
	 * @param value : Value to be entered in the text box.
	 */
	protected void enterTextInTextbox(WebElement wElement,String value) {
		wElement.clear();
		wElement.sendKeys(value);
		Reporter.log("Entered text "+value+" in textbox.");
	}

	/**
	 * Perform the operation of retrieving the text of the webelement.
	 * @param wElement : Locator of webelement.
	 * @return : The text of the webelement.
	 */
	protected String getValueFromLabel(WebElement wElement) {
		return wElement.getText();}

	/**
	 * Perform the operation of selecting a value from dropdown using dropdown values.
	 * @param wElement : Locator of webelement.
	 * @param value : Value to be selected.
	 */
	protected void selectByVisibleText(WebElement wElement,String value) {
		Select dropdown = new Select(wElement) ;
		dropdown.selectByVisibleText(value);
		Reporter.log("Selected value  "+value+" in dropdown.");
	}

	/**
	 * Killing the driver object once the execution is completed.
	 */
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	/**
	 * Take the screenshot of webpage.
	 * @param driver : WebDriver instance
	 * @return byte : Screenshot file as a byte array.
	 */
	@Attachment
	protected byte[] saveScreenshot(WebDriver driver){
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

}