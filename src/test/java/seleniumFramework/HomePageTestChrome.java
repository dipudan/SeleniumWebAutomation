package seleniumFramework;

import core.BasePage;
import page.HomePage;
import page.LoginPage;
import page.NewCustomerPage;

import org.testng.annotations.*;

public class HomePageTestChrome extends BasePage {

    @Test
    public void homepageValidation() {
        LoginPage objLogin = new LoginPage(getDriver());
        HomePage objHome = new HomePage(getDriver());

        objLogin.navigateToSiginPage();
        objLogin.loginToApplication("userLoginDetails.json");
        objHome.verifyUsername("userLoginDetails.json");
    }

    @Test
    public void createNewCustomer() {
        LoginPage objLogin = new LoginPage(getDriver());
        HomePage objHome = new HomePage(getDriver());
        NewCustomerPage objNewCust = new NewCustomerPage(getDriver());

        objLogin.navigateToSiginPage();
        objNewCust.navigateToCustomerCreationPage("newCustomerDetails.json");
        objNewCust.createCustomer("newCustomerDetails.json");
    }

    @Test
    public void clonehomepageValidation() {
        LoginPage objLogin = new LoginPage(getDriver());
        HomePage objHome = new HomePage(getDriver());

        objLogin.navigateToSiginPage();
        objLogin.loginToApplication("userLoginDetails.json");
        objHome.verifyUsername("userLoginDetails.json");
    }

    @Test
    public void clonecreateNewCustomer() {
        LoginPage objLogin = new LoginPage(getDriver());
        HomePage objHome = new HomePage(getDriver());
        NewCustomerPage objNewCust = new NewCustomerPage(getDriver());

        objLogin.navigateToSiginPage();
        objNewCust.navigateToCustomerCreationPage("newCustomerDetails.json");
        objNewCust.createCustomer("newCustomerDetails.json");
    }
}
