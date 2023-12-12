package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutOverviewPage extends BasePage {
    public static final By TITLE = By.cssSelector(".title");
    public static final By SUMMARY_TAX = By.cssSelector(".summary_tax_label");
    public static final By TOTAL_PRICE = By.cssSelector(".summary_subtotal_label");
    public static final By TOTAL = By.cssSelector(".summary_total_label");
    public static final By FINISH_BUTTON = By.id("finish");
    public static final String productPriceXpath = "//*[text()='%s']/ancestor::*[contains(@class, 'cart_item')]//div[@class='inventory_item_price']";


    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step ("Getting title of CheckoutOverviewPage")
    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Finish button clicking")
    public void buttonFinishClick() {
        log.info("Clicking on Finish button");
        driver.findElement(FINISH_BUTTON).click();
    }
}
