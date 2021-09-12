package page;

import org.openqa.selenium.WebDriver;

/**
 * Factory class which is used to convert all the method in the page classes return a similar object they
 * so that we don't need to create each page object in our test.
 */
public class AsUser {

    private final LoginPage objLogin;
    private final HomePage objHome;
    private final NewCustomerPage objNewCust;

    public AsUser(WebDriver driver) {
        objLogin = new LoginPage(driver);
        objHome = new HomePage(driver);
        objNewCust = new NewCustomerPage(driver);
    }

    /**
     * Used for making the page object class methods return a similar object type.
     * @param strJsonFileName : Json file in which the testdata is stored.
     * @return AsUser object
     */
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
