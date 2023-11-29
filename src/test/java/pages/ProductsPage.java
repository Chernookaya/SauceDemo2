package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        return driver.findElement(TITLE).getText();
    }

    @Step("Add product to cart by '{product}'")
    public void addToCart(String product) {
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCartButton).click();
    }

    @Step("Open Cart Page by click")
    public void openCart() {
        driver.findElement(CART_LINK).click();
    }

    @Step("Remove product from Cart")
    public void removeFromCart(String itemName) {
        By removeButton = By.xpath(String.format(REMOVE_FROM_CART_PATTERN, itemName));
        driver.findElement(removeButton).click();
    }
}