package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{

    @Test(retryAnalyzer = Retry.class, description = "Login as existing user")
    public void successfulLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
                {"", "", "Epic sadface: Username is required"},
                {"standard_user", "secret_sauce1", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test(dataProvider = "loginData", description = "All negative login cases")
    public void negativeLogin(String user, String password, String expectedError) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(), expectedError);
    }

    @Test(description = "Login with empty values - error message")
    public void emptyFields() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test(description = "Login with the wrong password - error message")
    public void wrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce1");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(description = "Login as locked user - error message")
    public void lockedUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
