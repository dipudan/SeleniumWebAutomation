package page;

import org.openqa.selenium.WebDriver;

public class AsUser {

    private LoginPage objLogin;
    private HomePage objHome;
    private NewCustomerPage objNewCust;

    public AsUser(WebDriver driver) {
        objLogin = new LoginPage(driver);
        objHome = new HomePage(driver);
        objNewCust = new NewCustomerPage(driver);
    }

    public AsUser verifyUsername(String strJsonFileName) {
        objHome.verifyUsername(strJsonFileName);
        return this;
    }
    public AsUser navigateToSiginPage() {
        objLogin.navigateToSiginPage();
        return this;
    }
    public AsUser loginToApplication(String strJsonFileName) {
        objLogin.loginToApplication(strJsonFileName);
        return this;
    }
    public AsUser navigateToCustomerCreationPage(String strJsonFileName) {
        objNewCust.navigateToCustomerCreationPage(strJsonFileName);
        return this;
    }
    public AsUser createCustomer(String strJsonFileName) {
        objNewCust.createCustomer(strJsonFileName);
        return this;
    }
}
