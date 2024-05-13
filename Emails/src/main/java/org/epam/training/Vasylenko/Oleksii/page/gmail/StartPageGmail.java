package org.epam.training.Vasylenko.Oleksii.page.gmail;

import org.epam.training.Vasylenko.Oleksii.page.BaseWebElement;
import org.epam.training.Vasylenko.Oleksii.util.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Emails
 * Author: Vasylenko Oleksii
 * Date: 10.05.2024
 */
public class StartPageGmail extends BaseWebElement {
    private final String baseUrl = "receiver.source";

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement nextButton;

    public StartPageGmail(WebDriver driver) {
        super(driver);
        this.driver.get(PropertiesUtil.get(baseUrl));
    }

    public PasswordPage setLogin(String login) {
        this.emailInput.sendKeys(login);
        this.nextButton.click();
        return new PasswordPage(this.driver);
    }


}
