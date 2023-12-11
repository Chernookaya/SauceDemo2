package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static pages.CheckoutInfoPage.*;


public class CheckoutInfoPageTest extends BaseTest {

    @Test(description = "")
    public void goCheckoutInfoPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        cartPage.clickOnCheckout();
    }

    @Test(description = "Firstname is required")
    public void errorEmptyFirstName() {
        goCheckoutInfoPage();
        checkoutInfoPage.setCheckoutData("", LAST_NAME_INPUT, POSTAL_CODE_INPUT);
        String error = driver.findElement(ERROR).getText();
        assertEquals(error, "Error: First Name is required", "Wrong error message");
    }

    @Test(description = "Lastname is required")
    public void errorEmptyLastName() {
        goCheckoutInfoPage();
        checkoutInfoPage.setCheckoutData(FIRST_NAME_INPUT, "", POSTAL_CODE_INPUT);
        String error = driver.findElement(ERROR).getText();
        assertEquals(error, "Error: Last Name is required", "Wrong error message");
    }

    @Test(description = "PostalCode is required")
    public void errorEmptyPostalCode() {
        goCheckoutInfoPage();
        checkoutInfoPage.setCheckoutData(FIRST_NAME_INPUT, LAST_NAME_INPUT, "");
        String error = driver.findElement(ERROR).getText();
        assertEquals(error, "Error: Postal Code is required", "Wrong error message");
    }

    @Test(description = "Check if user successful checkout")
    public void successCheckOutPage() {
        goCheckoutInfoPage();
        checkoutInfoPage.setCheckoutData(FIRST_NAME_INPUT, LAST_NAME_INPUT, POSTAL_CODE_INPUT);
        String getTitle = productsPage.getTitle();
        assertEquals(getTitle, "Checkout: Overview", "Wrong page title");
    }

    @Test(description = "Cancel button on checkout page clicking")
    public void cancelCheckOutPage() {
        goCheckoutInfoPage();
        checkoutInfoPage.cancelButtonClick();
        String getTitle = productsPage.getTitle();
        assertEquals(getTitle, "Your Cart", "Wrong page title");
    }
}