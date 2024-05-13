package org.epam.learning.browser;

import org.openqa.selenium.WebDriver;

/**
 * Google
 * Author: Vasylenko Oleksii
 * Date: 08.05.2024
 */
public abstract class BaseDriver {
    protected WebDriver driver;

    public abstract WebDriver getDriver();

}
