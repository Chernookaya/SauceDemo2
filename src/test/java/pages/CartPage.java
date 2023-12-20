package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
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
        log.info("Opening CartPage");
        driver.get(BASE_URL + "/cart.html");
    }

    @Step("Getting name of item")
    public String getItemName() {
        log.info("Getting name of item");
        return driver.findElement(ITEM_NAME).getText();
    }

    @Step("Getting price of item")
    public String getItemPrice() {
        log.info("Getting price of item");
        return driver.findElement(ITEM_PRICE).getText();
    }

    @Step("Click on Checkout button")
    public void clickOnCheckout() {
        log.info("Clicking on Checkout button");
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("Click on Continue shopping button")
    public void continueShopping() {
        log.info("Clicking on Continue shopping button");
        driver.findElement(CONTINUE_SHOPPING).click();
    }

    @Step("Remove product from Cart")
    public void deleteProduct(String productName) {
        log.info("Removing product from cart");
        By removeButtonLocator = By.xpath(String.format(DELETE_PRODUCT_PATTERN, productName));
        driver.findElement(removeButtonLocator).click();
    }

    @Step("Getting size of product list")
    public int getNumberOfProducts() {
        log.info("Getting size of product list");
        return driver.findElements(LIST_PRODUCTS).size();
    }
}
