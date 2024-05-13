package org.epam.training.Vasylenko.Oleksii.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Google
 * Author: Vasylenko Oleksii
 * Date: 08.05.2024
 */
public class ChromeDriverWrapper extends BaseDriver{

    public ChromeDriverWrapper() {
        WebDriverManager.chromedriver().setup();
    }

    public ChromeDriver getDriver() {
        this.driver = new ChromeDriver();
//        this.driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        this.driver.manage().window().maximize();
        return (ChromeDriver) this.driver;
    }
}
