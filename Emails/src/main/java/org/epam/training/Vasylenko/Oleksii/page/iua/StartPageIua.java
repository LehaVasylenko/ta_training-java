package org.epam.training.Vasylenko.Oleksii.page.iua;

import org.epam.training.Vasylenko.Oleksii.model.User;
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
public class StartPageIua extends BaseWebElement {
    private final String baseUrl = "sender.source";

    @FindBy (xpath = "//input[@name='login']")
    private WebElement loginInput;

    @FindBy (xpath = "//input[@name='pass']")
    private WebElement passwordInput;

    @FindBy (xpath = "//input[@title='Вхід на пошту']")
    private WebElement confirmButton;

    public StartPageIua(WebDriver driver) {
        super(driver);
        this.driver.get(PropertiesUtil.get(baseUrl));
    }

    public SuccessLoginPageIua login(User sender) {

        this.loginInput.sendKeys(sender.getEmail());
        this.passwordInput.sendKeys(sender.getPassword());
        this.confirmButton.click();
        return new SuccessLoginPageIua(this.driver);
    }
}
