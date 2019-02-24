package com.task.selenium;

import com.task.selenium.config.WebDriverConfig;
import com.task.selenium.utils.Utils;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static com.task.selenium.locators.Locators.*;
import static com.task.selenium.utils.WebUtils.openTitlePage;

public class RegisterUser {
    @Test
    public void registerUser() {
        WebDriver driver = openTitlePage(WebDriverConfig.Browser.CHROME);
        Utils utils = new Utils(driver);
        Random random = new Random();

        //Title page
        driver.findElement(SIGN_IN).click();

        //Sign in page
        driver.findElement(INPUT_EMAIL).sendKeys("task_user_" + System.currentTimeMillis() + "@gmail.com");
        driver.findElement(CREATE_BUTTON).click();

        //Personal data input page
        utils.waitUntilElementIsVisible(FIRST_NAME, 3);

        driver.findElement(TITLE).click();
        driver.findElement(FIRST_NAME).sendKeys("Firstname");
        driver.findElement(LAST_NAME).sendKeys("Lastname");
        driver.findElement(PASSWORD).sendKeys("password");
        Select dayOfBirth = new Select(driver.findElement(BIRTH_DAY));
        dayOfBirth.selectByValue("5");
        Select monthOfBirth = new Select(driver.findElement(BIRTH_MONTH));
        monthOfBirth.selectByValue("6");
        Select yearOfBirth = new Select(driver.findElement(BIRTH_YEAR));
        yearOfBirth.selectByValue("1988");
        driver.findElement(NEWSLETTER).click();
        driver.findElement(ADDRESS_LINE_1).sendKeys("New Street");
        driver.findElement(ADDRESS_LINE_2).sendKeys("33, apt. 7");
        driver.findElement(CITY).sendKeys("Los Angeles");
        Select state = new Select(driver.findElement(STATE));
        state.selectByValue("5");
        driver.findElement(POST_CODE).sendKeys("16755");
        driver.findElement(MOBILE_PHONE).sendKeys("+48509666363");
        driver.findElement(ALIAS).sendKeys("ipf_alias");
        driver.findElement(REGISTER).click();

        //User registered
        utils.waitUntilElementIsVisible(USER_REGISTERED, 1);

        //Close window
        driver.close();
    }
}
