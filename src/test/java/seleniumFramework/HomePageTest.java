package seleniumFramework;

import core.BasePage;
import org.testng.annotations.Test;
import page.AsUser;
import io.qameta.allure.*;

/**
 * Test written in the form of scenarios after scenarios using '.' operator.
 * This is achieved  by creating a factory class
 * and defining all the methods in this class.
 * AsUser is the factory class.
 */

public class HomePageTest extends BasePage {

    /**
     * Test to validate the test fails when a wrong username/password is used.
     * '@Severity,@Story annotations are used for allure reporting.
     * Test data is fetched from 'userLoginDetails.json' file placed in location resource/data.
     */
    @Severity(SeverityLevel.BLOCKER)
    @Story("User login to application and verify username in homepage.")
    @Test(description = "Wrong username is given in input file to fail the test script.")
    public void homepageValidationWithWrongCredential() {
        AsUser objUser = new AsUser(getDriver());

        objUser.navigateToSiginPage().loginToApplication("userLoginDetails.json")
                .verifyUsername("dummyUserLoginDetails.json");
    }


    /**
     * Test to validate the user is able to login successfully.
     * '@Severity,@Story annotations are used for allure reporting.
     * Test data is fetched from 'userLoginDetails.json' file placed in location resource/data.
     */
    @Severity(SeverityLevel.BLOCKER)
    @Story("User login to application and verify the username is displayed.")
    @Test(description = "Verify Login.")
    public void homepageValidation() {
        AsUser objUser = new AsUser(getDriver());

        objUser.navigateToSiginPage().loginToApplication("userLoginDetails.json")
                .verifyUsername("userLoginDetails.json");
    }


    /**
     * Test to create a new user.
     * '@Severity,@Story annotations are used for allure reporting.
     * Test data is fetched from 'userLoginDetails.json' file placed in location resource/data.
     */

    @Severity(SeverityLevel.CRITICAL)
    @Story("Creates a new user to login.")
    @Test(description = "User creation.")
    public void createNewCustomer() {
        AsUser objUser = new AsUser(getDriver());

        objUser.navigateToSiginPage().navigateToCustomerCreationPage("newCustomerDetails.json")
                .createCustomer("newCustomerDetails.json");
    }

}
