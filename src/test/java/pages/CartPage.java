package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    public static final By ITEM_NAME = By.cssSelector(".inventory_item_name");
    public static final By ITEM_PRICE = By.cssSelector(".inventory_item_price");
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By CONTINUE_SHOPPING = By.id("continue-shopping");
    public static final String DELETE_PRODUCT_PATTERN = "//*[text()='%s']/ancestor::*[contains(@class, 'cart_item_label')]//button";
    public static final By LIST_PRODUCTS = By.cssSelector(".cart_item");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening CartPage")
    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    @Step("Getting name of item")
    public String getItemName() {
        return driver.findElement(ITEM_NAME).getText();
    }

    @Step("Getting price of item")
    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }

    @Step("Click on checkout button")
    public void clickOnCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("Click on Continue shopping button")
    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING).click();
    }

    @Step("Delete product from Cart")
    public void deleteProduct(String productName) {
        By removeButtonLocator = By.xpath(String.format(DELETE_PRODUCT_PATTERN, productName));
        driver.findElement(removeButtonLocator).click();
    }

    @Step("Getting size of product list")
    public int getNumberOfProducts() {
        return driver.findElements(LIST_PRODUCTS).size();
    }
}
