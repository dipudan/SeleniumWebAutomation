package core;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class CapabilityFactory {
    private Capabilities capabilities;

    /**
     * Setting the browser capabilities.
     * @param browser : Browser for which capabilities need to be set.
     * @return Capabilities of browser.
     */
    public Capabilities getCapabilities (String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", Util.getConfigPropertyAsString("ChromeDriverPath"));
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");

            options.setCapability("os", "Windows");
            options.setCapability("os_version", "10");
            options.setCapability("browser", "Chrome");
            options.setCapability("browser_version", "81");
            options.setCapability("name", "dipukrishnan1's First Test");

            capabilities = options;
        } else {
            FirefoxOptions options = new FirefoxOptions();
            FirefoxProfile profile = new FirefoxProfile();
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
            profile.setPreference("network.proxy.type", 0);
            options.setCapability(FirefoxDriver.PROFILE, profile);
            capabilities = options;
        }
        return capabilities;
    }
}
