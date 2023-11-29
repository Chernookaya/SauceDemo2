package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutInfoPage extends BasePage {

    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By POSTAL_CODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By CANCEL_BUTTON = By.id("cancel");
    public static final By TITLE = By.cssSelector(".title");
    public static final By ERROR = By.cssSelector(".error-message-container");
    public static final String FIRST_NAME_INPUT = "Antonina";
    public static final String LAST_NAME_INPUT = "Chernookaya";
    public static final String POSTAL_CODE_INPUT = "22080";


    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting title of CheckoutInfoPage")
    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Login on checkout info page")
    public void setCheckoutData(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Cancel button clicking")
    public void cancelButtonClick() {
        driver.findElement(CANCEL_BUTTON).click();
    }


    public String getError() {
        return driver.findElement(ERROR).getText();
    }
}