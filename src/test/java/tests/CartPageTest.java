package tests;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class CartPageTest extends BaseTest {
    String checkTitle;

    @Step("Login main page, add products to cart, cart page opening")
    public void goToCartPage() {
        log.info("Login main page, add products to cart, cart page opening");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
    }

    @Test(description = "Check if title match")
    public void checkTitleCartPage() {
        goToCartPage();
        checkTitle = productsPage.getTitle();
        assertEquals(checkTitle, "Your Cart", "Wrong page title");
    }

    @Test(description = "Check if products delete from cart")
    public void deleteProduct() {
        goToCartPage();
        cartPage.deleteProduct("Sauce Labs Bike Light");
        assertEquals(cartPage.getNumberOfProducts(), 0, "Product not deleted");
    }

    @Test(description = "Check title on 'Checkout' button click")
    public void checkoutButtonClick() {
        goToCartPage();
        cartPage.clickOnCheckout();
        checkTitle = productsPage.getTitle();
        assertEquals(checkTitle, "Checkout: Your Information", "Wrong page title");
    }
    @Test(description = "Check title on 'Continue' button click")
    public void continueButtonClick() {
        goToCartPage();
        cartPage.continueShopping();
        checkTitle = productsPage.getTitle();
        assertEquals(checkTitle, "Products", "Wrong page title");
    }
}
