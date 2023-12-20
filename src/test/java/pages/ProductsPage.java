package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector(".title");
    private final String ADD_TO_CART_PATTERN = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private final String REMOVE_FROM_CART_PATTERN = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private final By CART_LINK = By.id("shopping_cart_container");
    public static final By LIST_PRODUCTS = By.cssSelector(".cart_item");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening ProductsPage")
    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    @Step("Getting title of ProductsPage")
    public String getTitle() {
        log.info("Getting title of ProductsPage");
        return driver.findElement(TITLE).getText();
    }

    @Step("Add product to cart by '{product}'")
    public void addToCart(String product) {
        log.info("Add product to cart by '{product}'");
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCartButton).click();
    }

    @Step("Open Cart Page by click")
    public void openCart() {
        log.info("Opening Cart Page by click");
        driver.findElement(CART_LINK).click();
    }

    @Step("Remove product from Cart")
    public void removeFromCart(String itemName) {
        log.info("Removing product from Cart");
        By removeButton = By.xpath(String.format(REMOVE_FROM_CART_PATTERN, itemName));
        driver.findElement(removeButton).click();
    }
}
