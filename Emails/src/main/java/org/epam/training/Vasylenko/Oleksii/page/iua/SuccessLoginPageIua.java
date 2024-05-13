package org.epam.training.Vasylenko.Oleksii.page.iua;

import org.epam.training.Vasylenko.Oleksii.page.BaseWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Emails
 * Author: Vasylenko Oleksii
 * Date: 10.05.2024
 */
public class SuccessLoginPageIua extends BaseWebElement {
    @FindBy (xpath = "//p[@class='make_message']/a")
    private WebElement makeLetterLink;

    public SuccessLoginPageIua(WebDriver driver) {
        super(driver);
    }

    public CreateMessagePage createNewLetter() {
        this.makeLetterLink.click();
        return new CreateMessagePage(this.driver);
    }
}
