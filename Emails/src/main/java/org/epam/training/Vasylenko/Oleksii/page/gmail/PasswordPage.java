package org.epam.training.Vasylenko.Oleksii.page.gmail;

import org.epam.training.Vasylenko.Oleksii.page.BaseWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Emails
 * Author: Vasylenko Oleksii
 * Date: 10.05.2024
 */
public class PasswordPage extends BaseWebElement {
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@id='passwordNext']//button")
    private WebElement nextButton;

    public PasswordPage(WebDriver driver) {
        super(driver);
    }

    public SuccessLoginPageGmail setPassword(String password) {
        this.passwordInput.sendKeys(password);
        this.nextButton.click();
        return new SuccessLoginPageGmail(this.driver);
    }
}
