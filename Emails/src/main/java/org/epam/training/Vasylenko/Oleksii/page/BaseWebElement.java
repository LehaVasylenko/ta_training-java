package org.epam.training.Vasylenko.Oleksii.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * AptekiSelenium
 * Author: Vasylenko Oleksii
 * Date: 12.04.2024
 */
@Getter
public class BaseWebElement {
    protected WebDriver driver;

    public BaseWebElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
