package com.task.selenium.utils;

import com.task.selenium.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebUtils {
    private final WebDriver driver;
    private final Utils utils;

    //Locators
    //signInUser
    private static final By INPUT_EMAIL = By.id("email");
    private static final By PASSWORD = By.id("passwd");
    private static final By SIGN_IN_BUTTON = By.id("SubmitLogin");
    private static final By USER_SIGNED_IN = By.xpath("//a[@class=\"logout\"]");
    //searchForItem
    private static final By SEARCH = By.id("search_query_top");
    //finalizeShopping
    private static final By SUMMARY_PROCEED = By.xpath("//*[@id=\"center_column\"]/p[@class=\"cart_navigation clearfix\"]/" +
            "a[@class=\"button btn btn-default standard-checkout button-medium\"]/span");
    private static final By ADDRESS_PROCEED = By.xpath("//*[@id=\"center_column\"]/form/p/button/span");
    private static final By AGREEMENT = By.id("cgv");
    private static final By SHIPPING_PROCEED = By.xpath("//*[@id=\"form\"]/p/button/span");
    private static final By PAYMENT_METHOD = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[@class=\"row\"]/div/p/a");
    private static final By CONFIRM_ORDER = By.xpath("//*[@id=\"cart_navigation\"]/button/span");
    private static final By ORDER_CONFIRMED = By.xpath("//*[@id=\"center_column\"]/div");
    //addToCartAndContinue
    private static final By CONTINUE_SHOPPING = By.xpath("//span[@title=\"Continue shopping\"]");
    //addToCartAndCheckout
    private static final By TO_CHECKOUT = By.xpath("//a[@title=\"Proceed to checkout\"]");//("//*[@id=\"layer_cart\"]/div[@class=\"clearfix\"]/div[@class=\"layer_cart_cart col-xs-12 col-md-6\"]/" +
            //"div[@class=\"button-container\"]/a/span");


    public WebUtils(final WebDriver driver) {
        this.driver = driver;
        utils = new Utils(driver);
    }

    /**
     * Opens title page and returns browser driver.
     *
     * @return driver
     */
    public static WebDriver openTitlePage(final WebDriverConfig.Browser browser) {
        WebDriver driver = WebDriverConfig.getDriver(browser);
        driver.manage().window().maximize();
        driver.get(Utils.BASE_URL);
        return driver;
    }

    /**
     * Signs in user on sign in page.
     *
     * @param email    email
     * @param password password
     */
    public void signInUser(final String email, final String password, final boolean checkSignIn) {
        driver.findElement(INPUT_EMAIL).sendKeys(email);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(SIGN_IN_BUTTON).click();

        //User signed in
        if (checkSignIn) {
            utils.waitUntilElementIsVisible(USER_SIGNED_IN, 1);
        }
    }

    /**
     * Inputs text in search prompt and submits search.
     *
     * @param text text
     */
    public void searchForItem(final String text) {
        WebElement searchPrompt = driver.findElement(SEARCH);
        searchPrompt.clear();
        searchPrompt.sendKeys(text);
        searchPrompt.submit();
    }

    /**
     * Finalizes shopping process with given email and password.
     *
     * @param email    email
     * @param password password
     */
    public void finalizeShopping(final String email, final String password) {
        //Summary
        driver.findElement(SUMMARY_PROCEED).click();
        //Sign in
        signInUser(email, password, false);
        //Address
        driver.findElement(ADDRESS_PROCEED).click();
        //Shipping
        driver.findElement(AGREEMENT).click();
        driver.findElement(SHIPPING_PROCEED).click();
        //Payment
        driver.findElement(PAYMENT_METHOD).click();
        //Confirm
        driver.findElement(CONFIRM_ORDER).click();

        //Order successful
        utils.waitUntilElementIsVisible(ORDER_CONFIRMED, 1);
    }

    /**
     * Adds item to cart.
     *
     * @param itemImage     image to hover with mouse
     * @param itemAddButton 'add to cart' button
     */
    public void addToCart(final By itemImage, final By itemAddButton) {
        Actions addBlouse = new Actions(driver);
        WebElement blouseImg = driver.findElement(itemImage);
        addBlouse.moveToElement(blouseImg).moveToElement(driver.findElement(itemAddButton)).click().build().perform();
    }

    /**
     * Adds item to cart and continue shopping.
     *
     * @param itemImage         image to hover with mouse
     * @param itemAddButton'add to cart' button
     */
    public void addToCartAndContinue(final By itemImage, final By itemAddButton) {
        addToCart(itemImage, itemAddButton);
        utils.waitUntilElementIsVisible(CONTINUE_SHOPPING, 3);
        driver.findElement(CONTINUE_SHOPPING).click();
    }

    /**
     * Adds item to cart and go to checkout.
     *
     * @param itemImage     image to hover with mouse
     * @param itemAddButton 'add to cart' button
     */
    public void addToCartAndCheckout(final By itemImage, final By itemAddButton) {
        addToCart(itemImage, itemAddButton);
        utils.waitUntilElementIsVisible(TO_CHECKOUT, 3);
        driver.findElement(TO_CHECKOUT).click();
    }
}
