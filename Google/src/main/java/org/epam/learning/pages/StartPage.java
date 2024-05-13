package org.epam.learning.pages;

import lombok.Getter;
import org.epam.learning.util.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Google
 * Author: Vasylenko Oleksii
 * Date: 09.05.2024
 */
@Getter
public class StartPage extends BaseWebElement{
    private final String searchKey = "test.search";

    @FindBy(xpath = "//div[@jsname='Ohx1pb']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='i4']")
    private WebElement searchInput;

    @FindBy(xpath = "//i[@aria-label='Search']")
    private WebElement searchSubmitButton;

    public StartPage(WebDriver driver) {
        super(driver);
        this.driver.get(PropertiesUtil.get("test.base"));
    }

    public SearchResultPage searchCalculator() {
        this.searchButton.click();
        this.searchInput.sendKeys(PropertiesUtil.get(searchKey));
        this.searchSubmitButton.click();
        return new SearchResultPage(this.driver);
    }

}
