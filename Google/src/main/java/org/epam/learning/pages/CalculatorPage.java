package org.epam.learning.pages;

import lombok.Getter;
import org.epam.learning.service.StorageFiller;
import org.openqa.selenium.By;
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
@Getter
public class CalculatorPage extends BaseWebElement{

    @FindBy (xpath = "//article[@id = 'cloud-site']//iframe")
    private WebElement mainFrame;

    @FindBy (xpath = "//iframe[@id = 'myFrame']")
    private WebElement smallFrame;

    @FindBy(id = "input_100")
    private WebElement instanceInput;

    @FindBy(xpath = "//md-select[@id='select_125']")
    private WebElement selectSeries;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage setInstancesNumber() {
        this.driver.switchTo().frame(this.mainFrame);
        this.driver.switchTo().frame(this.smallFrame);

        Wait<WebDriver> waitInstance = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        waitInstance.until(w -> this.instanceInput.isDisplayed());

        new Actions(this.driver)
                .scrollToElement(this.instanceInput)
                .perform();

        this.instanceInput.click();

        this.instanceInput
                .sendKeys(StorageFiller
                .INSTANCE
                .getData()
                .getNumberOfInstances());

        this.driver.switchTo().defaultContent();
        return this;
    }

    public CalculatorPage setSeries() {
        this.driver.switchTo().frame(this.mainFrame);
        this.driver.switchTo().frame(this.smallFrame);

        Wait<WebDriver> waitSelect = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        waitSelect.until(w -> this.selectSeries.isDisplayed());

        new Actions(this.driver)
                .scrollToElement(this.selectSeries)
                .perform();

        this.selectSeries.click();

        String value = StorageFiller.INSTANCE.getData().getSeries().toLowerCase();
        WebElement needToClick = this.driver.findElement(By.xpath("//md-option[@value='" + value + "']"));
        System.out.println("//md-option[@value='" + value + "']");

        Wait<WebDriver> waitForDropDown = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        waitForDropDown.until(w -> needToClick.isDisplayed());

        needToClick.click();

        this.driver.switchTo().defaultContent();
        return this;
    }
}
