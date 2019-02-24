package com.task.selenium;

import com.task.selenium.config.WebDriverConfig;
import com.task.selenium.utils.WebUtils;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static com.task.selenium.locators.Locators.SIGN_IN;
import static com.task.selenium.utils.WebUtils.openTitlePage;

public class SignInUser {
    @Test
    public void signInUser() {
        WebDriver driver = openTitlePage(WebDriverConfig.Browser.CHROME);
        WebUtils webUtils = new WebUtils(driver);

        driver.findElement(SIGN_IN).click();
        webUtils.signInUser("fistlastname@gmail.com", "password", true);

        //Close window
        driver.close();
    }
}
