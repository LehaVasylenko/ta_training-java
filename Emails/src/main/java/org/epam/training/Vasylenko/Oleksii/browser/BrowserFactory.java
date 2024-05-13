package org.epam.training.Vasylenko.Oleksii.browser;

import org.openqa.selenium.WebDriver;

/**
 * Google
 * Author: Vasylenko Oleksii
 * Date: 08.05.2024
 */
public enum BrowserFactory {
    INSTANCE;
    private WebDriver driver;

    BrowserFactory() {
        switch (System.getProperty("browser").toLowerCase()) {
            case "chrome": this.driver = (new ChromeDriverWrapper()).getDriver(); break;
            case "firefox": this.driver = (new FireFoxDriverWrapper()).getDriver(); break;
            default: throw new IllegalArgumentException(System.getProperty("browser") + " not allowed!");
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
            this.driver = null;
        }
    }
}
