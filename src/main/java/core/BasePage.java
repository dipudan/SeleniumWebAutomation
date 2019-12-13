package core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BasePage {

//**********************************************************************************************************//
	//Code to run on local machine.
//**********************************************************************************************************//
//	protected static ThreadLocal<ChromeDriver> driver = new ThreadLocal<ChromeDriver>();
//	@BeforeMethod
//	public void launchBrowser() {
//		System.setProperty("webdriver.chrome.driver",Util.getConfigProperty("ChromeDriverPath"));
//		driver.set(new ChromeDriver());
//		driver.get().manage().timeouts().implicitlyWait(Integer.valueOf(Util.getConfigProperty("ImplicitWait")),TimeUnit.SECONDS);
//		driver.get().manage().window().maximize();
//		driver.get().get(Util.getConfigProperty("ApplicationURL"));
//	}
//**********************************************************************************************************//
//**********************************************************************************************************//


	protected static ThreadLocal<RemoteWebDriver> driver= new ThreadLocal<>();
	private CapabilityFactory capabilityFactory = new CapabilityFactory();

	@BeforeMethod
	@Parameters({"browser","environment"})
	public void launchBrowser (String strBrowser,String strEnvironment) throws MalformedURLException {
		if(strEnvironment.equalsIgnoreCase("Local")){
			driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
					capabilityFactory.getCapabilities(strBrowser)));
		}else {
			driver.set(new RemoteWebDriver(new URL("http://3.15.38.99:4444/wd/hub"),
					capabilityFactory.getCapabilities(strBrowser)));
		}
		driver.get().manage().timeouts().implicitlyWait(Util.getConfigPropertyAsInt("ImplicitWait"),TimeUnit.SECONDS);
		driver.get().manage().window().maximize();
		driver.get().get(Util.getConfigPropertyAsString("ApplicationURL"));
	}
	
	protected WebDriver getDriver() {return driver.get();}
	
	public BasePage() {
		
	}
	
	protected void clickOnElement(WebElement wElement) {
		wElement.click();
		Reporter.log("Clicked on link.");
	}

	protected void enterTextInTextbox(WebElement wElement,String strValue) {
		wElement.clear();
		wElement.sendKeys(strValue);
		Reporter.log("Entered text "+strValue+" in textbox.");
	}

	protected String getValueFromLabel(WebElement wElement) {return wElement.getText();}

	protected void selectByVisibleText(WebElement wElement,String strValue) {
		Select dropdown = new Select(wElement) ;
		dropdown.selectByVisibleText(strValue);
		Reporter.log("Selected value  "+strValue+" in dropdown.");
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	@Attachment
	protected byte[] saveScreenshot(WebDriver driver){
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

}
