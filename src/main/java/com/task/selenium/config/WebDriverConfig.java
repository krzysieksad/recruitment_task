package com.task.selenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {
    public enum Browser {
        FIREFOX("FIREFOX_DRIVER"),
        CHROME("CHROME_DRIVER");

        private String browser;

        Browser(final String browser) {
            this.browser = browser;
        }

        public String browser() {
            return browser;
        }
    }

    /**
     * Get browser driver.
     *
     * @param driver browser name
     * @return driver
     */
    public static WebDriver getDriver(final Browser driver) {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Selenium-drivers\\Firefox\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Selenium-drivers\\Chrome\\chromedriver.exe");

        if (driver.equals(Browser.FIREFOX)) {
            return new FirefoxDriver();
        } else if (driver.equals(Browser.CHROME)) {
            return new ChromeDriver();
        } else {
            return null;
        }
    }
}
