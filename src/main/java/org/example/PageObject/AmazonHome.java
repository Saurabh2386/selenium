package org.example.PageObject;

import org.example.Constants.Locators;
import org.example.Util.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AmazonHome {
    public static void search() {
        WebElement element = Config.element(By.xpath(Locators.SEARCH_BAR));
        element.click();
        element.sendKeys("Laptop");
    }

    public static void search_button() {
        WebElement element = Config.element(By.xpath(Locators.SEARCH_BUTTON));
        element.click();
    }
}