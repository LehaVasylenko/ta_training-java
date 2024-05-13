package org.epam.learning.activities;

import org.epam.learning.browser.BrowserFactory;
import org.epam.learning.pages.CalculatorPage;
import org.epam.learning.pages.StartPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Google
 * Author: Vasylenko Oleksii
 * Date: 09.05.2024
 */
public class CalculatorActivities {

    @BeforeTest
    public void init() {
        System.setProperty("browser", "chrome");
    }

    @Test
    public void test1() {
        CalculatorPage calculator = new StartPage(BrowserFactory.INSTANCE.getDriver())
                .searchCalculator()
                .goToCalculator()
                .setInstancesNumber()
                .setSeries();
    }
}
