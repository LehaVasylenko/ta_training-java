package org.epam.training.Vasylenko.Oleksii.page.gmail;

import org.epam.training.Vasylenko.Oleksii.page.BaseWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

/**
 * Emails
 * Author: Vasylenko Oleksii
 * Date: 10.05.2024
 */
public class SuccessLoginPageGmail extends BaseWebElement {
    @FindBy (xpath = "//a[@href='https://mail.google.com/mail/u/0/#inbox']")
    private WebElement checkMailButton;

    @FindBys({
            @FindBy(xpath = "//span[@data-hovercard-owner-id='28']")
    })
    private List<WebElement> messages;

    @FindBys({
            @FindBy(xpath = "//div[@id]/div[@id]")
    })
    private List<WebElement> text;

    public SuccessLoginPageGmail(WebDriver driver) {
        super(driver);
    }

    public SuccessLoginPageGmail checkMail(String sender) {
        this.checkMailButton.click();
        WebElement result = null;

        for (WebElement message: messages) {
            if (message.getAttribute("email").equals(sender)) {
                result = message;
                break;
            }
        }

        result.click();
        return this;
    }

    public boolean verifyMailText(String compareTo) {
        String message = text.get(text.size() - 1).getText();
        return message.contains(compareTo);
    }
}
