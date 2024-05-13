package org.epam.training.Vasylenko.Oleksii.page.iua;

import org.epam.training.Vasylenko.Oleksii.model.Email;
import org.epam.training.Vasylenko.Oleksii.page.BaseWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Emails
 * Author: Vasylenko Oleksii
 * Date: 10.05.2024
 */
public class CreateMessagePage extends BaseWebElement {
    @FindBy(xpath = "//textarea[@id = 'to']")
    private WebElement receiverInput;

    @FindBy (xpath = "//input[@name='subject']")
    private WebElement subjectInput;

    @FindBy (xpath = "//textarea[@id = 'text']")
    private WebElement bodyInput;

    @FindBy (xpath = "//input[@name='send']")
    private WebElement sendButton;

    public CreateMessagePage(WebDriver driver) {
        super(driver);
    }

    public SuccessSendEmail sendMessage(Email emailToSend) {
        this.receiverInput.sendKeys(emailToSend.getReceiver());
        this.subjectInput.sendKeys(emailToSend.getSubject());
        this.bodyInput.sendKeys(emailToSend.getBody());

        this.sendButton.click();
        return new SuccessSendEmail(this.driver);
    }
}
