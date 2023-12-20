package tests;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.CheckoutInfoPage.*;
import static pages.CheckoutOverviewPage.*;

@Log4j2
public class CheckoutOverviewPageTest extends BaseTest {
    double totalProductsPrice, summaryTax, summaryTotal, total, calculatedTax;
    double scale = Math.pow(10, 2);

    @Step("Login main page, add products to cart, checkout info page opening")
    public void goToCheckoutOverviewPage() {
        log.info("Login main page, add products to cart, checkout info page opening");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        cartPage.clickOnCheckout();
        checkoutInfoPage.setCheckoutData(FIRST_NAME_INPUT, LAST_NAME_INPUT, POSTAL_CODE_INPUT);
    }

    @Test(description = "Finish button clicking")
    public void buttonFinishClick() {
        goToCheckoutOverviewPage();
        checkoutOverviewPage.buttonFinishClick();
        String str = productsPage.getTitle();
        assertEquals(str, "Checkout: Complete!", "Wrong Title");
    }
}
