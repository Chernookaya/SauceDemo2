package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class ProductsTest extends BaseTest {

    @Test(description = "Check if any products can be bought")
    public void buyProduct() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        assertEquals(cartPage.getItemName(), "Sauce Labs Bike Light");
        assertEquals(cartPage.getItemPrice(), "$9.99");
    }
    @Test(description = "Check if any product can be removed")
    public void removeProductFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.removeFromCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        assertEquals(cartPage.getNumberOfProducts(),0, "Wrong amount of products");
    }
}