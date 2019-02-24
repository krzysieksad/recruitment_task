package com.task.selenium;

import com.task.selenium.config.WebDriverConfig;
import com.task.selenium.utils.WebUtils;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static com.task.selenium.locators.Locators.*;
import static com.task.selenium.utils.WebUtils.openTitlePage;

public class NewOrder {
    @Test
    public void newOrder() {
        WebDriver driver = openTitlePage(WebDriverConfig.Browser.CHROME);
        WebUtils webUtils = new WebUtils(driver);

        webUtils.searchForItem("blouse");
        webUtils.addToCartAndContinue(BLOUSE_IMG, ADD_BLOUSE);
        webUtils.searchForItem("dress");
        webUtils.addToCartAndCheckout(DRESS_IMG, ADD_DRESS);
        webUtils.finalizeShopping("fistlastname@gmail.com", "password");

        //Close window
        driver.close();
    }
}
