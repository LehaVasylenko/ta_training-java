package org.epam.training.Vasylenko.Oleksii.page.iua;

import org.epam.training.Vasylenko.Oleksii.page.BaseWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Emails
 * Author: Vasylenko Oleksii
 * Date: 10.05.2024
 */
public class SuccessSendEmail extends BaseWebElement {
    @FindBy (xpath = "//div[@class='content clear']")
    private WebElement successMessage;

    @FindBy (xpath = "//input[@type='checkbox']")
    private WebElement iAmHuman;

    public SuccessSendEmail(WebDriver driver) {
        super(driver);
    }

    public String getResult() {
        if (this.driver.getCurrentUrl().contains("https://mbox2.i.ua/send_status/")) {
            Wait<WebDriver> wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
            wait.until(w -> this.iAmHuman.isDisplayed());
            this.iAmHuman.click();
        }

        Wait<WebDriver> wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        wait.until(w -> this.successMessage.isDisplayed());

        return this.successMessage.getText();
    }
}
