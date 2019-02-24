package com.task.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    public static final String BASE_URL = "http://automationpractice.com/index.php";
    private final WebDriver driver;

    public Utils(final WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilElementIsVisible(final By locator, final long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
