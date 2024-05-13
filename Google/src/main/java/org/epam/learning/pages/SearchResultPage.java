package org.epam.learning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Google
 * Author: Vasylenko Oleksii
 * Date: 09.05.2024
 */
public class SearchResultPage extends BaseWebElement{

    @FindBy(xpath = "//a[@href='https://cloud.google.com/products/calculator-legacy']")
    private WebElement calculatorLink;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage goToCalculator() {

        Wait<WebDriver> wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        wait.until(w -> this.calculatorLink.isDisplayed());

        new Actions(driver)
                .scrollToElement(this.calculatorLink)
                .perform();

        this.calculatorLink.click();
        return new CalculatorPage(this.driver);
    }
}
