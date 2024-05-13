package org.epam.learning.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Google
 * Author: Vasylenko Oleksii
 * Date: 08.05.2024
 */
public class FireFoxDriverWrapper extends BaseDriver{

    public FireFoxDriverWrapper() {
        WebDriverManager.firefoxdriver().setup();
    }

    public FirefoxDriver getDriver() {
        return new FirefoxDriver();
    }
}
