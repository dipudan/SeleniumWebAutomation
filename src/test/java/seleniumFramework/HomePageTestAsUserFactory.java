package seleniumFramework;

import core.BasePage;
import org.testng.annotations.Test;
import page.AsUser;
import io.qameta.allure.Step;
import io.qameta.allure.*;

public class HomePageTestAsUserFactory extends BasePage {

    @Severity(SeverityLevel.BLOCKER)
    @Story("User login to application and verify username in homepage.")
    @Test(description = "Wrong username is given in input file to fail the test script.")
    public void homepageValidationClone() {
        AsUser objUser = new AsUser(getDriver());

        objUser.navigateToSiginPage().loginToApplication("userLoginDetails.json")
                .verifyUsername("dummyUserLoginDetails.json");
    }

    @Severity(SeverityLevel.BLOCKER)
    @Story("User login to application and verify the username is displayed.")
    @Test(description = "Verify Login.")
    public void homepageValidation() {
        AsUser objUser = new AsUser(getDriver());

        objUser.navigateToSiginPage().loginToApplication("userLoginDetails.json")
                .verifyUsername("userLoginDetails.json");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("User creates a new user and login to application")
    @Test(description = "User creation.")
    public void createNewCustomer() {
        AsUser objUser = new AsUser(getDriver());

        objUser.navigateToSiginPage().navigateToCustomerCreationPage("newCustomerDetails.json")
                .createCustomer("newCustomerDetails.json");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("User creates a new user.")
    @Test(description = "New User creation.")
    public void createNewCustomerClone() {
        AsUser objUser = new AsUser(getDriver());

        objUser.navigateToSiginPage().navigateToCustomerCreationPage("newCustomerDetails.json")
                .createCustomer("newCustomerDetails.json");
    }

    @Severity(SeverityLevel.BLOCKER)
    @Story("User login to application and verify username in homepage.")
    @Test(description = "Wrong username is given in input file to fail the test script.")
    public void homepageValidationClone_1() {
        AsUser objUser = new AsUser(getDriver());

        objUser.navigateToSiginPage().loginToApplication("userLoginDetails.json")
                .verifyUsername("userLoginDetails.json");
    }

    @Severity(SeverityLevel.BLOCKER)
    @Story("User login to application and verify the username is displayed.")
    @Test(description = "Verify Login.")
    public void homepageValidation_1() {
        AsUser objUser = new AsUser(getDriver());

        objUser.navigateToSiginPage().loginToApplication("userLoginDetails.json")
                .verifyUsername("userLoginDetails.json");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("User creates a new user and login to application")
    @Test(description = "User creation.")
    public void createNewCustomer_1() {
        AsUser objUser = new AsUser(getDriver());

        objUser.navigateToSiginPage().navigateToCustomerCreationPage("newCustomerDetails.json")
                .createCustomer("newCustomerDetails.json");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("User creates a new user.")
    @Test(description = "New User creation.")
    public void createNewCustomerClone_1() {
        AsUser objUser = new AsUser(getDriver());

        objUser.navigateToSiginPage().navigateToCustomerCreationPage("newCustomerDetails.json")
                .createCustomer("newCustomerDetails.json");
    }
}
