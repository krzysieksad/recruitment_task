package com.task.selenium.locators;

import org.openqa.selenium.By;

public class Locators {
    //Log in
    public static final By SIGN_IN = By.xpath("//*[@id=\"header\"]/div[@class=\"nav\"]/div/div/nav/div/a");

    //Register user
    public static final By INPUT_EMAIL = By.id("email_create");
    public static final By CREATE_BUTTON = By.id("SubmitCreate");
    public static final By TITLE = By.id("id_gender1");
    public static final By FIRST_NAME = By.id("customer_firstname");
    public static final By LAST_NAME = By.id("customer_lastname");
    public static final By PASSWORD = By.id("passwd");
    public static final By BIRTH_DAY = By.id("days");
    public static final By BIRTH_MONTH = By.id("months");
    public static final By BIRTH_YEAR = By.id("years");
    public static final By NEWSLETTER = By.id("newsletter");
    public static final By ADDRESS_LINE_1 = By.id("address1");
    public static final By ADDRESS_LINE_2 = By.id("address2");
    public static final By CITY = By.id("city");
    public static final By STATE = By.id("id_state");
    public static final By POST_CODE = By.id("postcode");
    public static final By MOBILE_PHONE = By.id("phone_mobile");
    public static final By ALIAS = By.id("alias");
    public static final By REGISTER = By.id("submitAccount");
    public static final By USER_REGISTERED = By.xpath("//*[@id=\"center_column\"]/p");

    //New order
    public static final By BLOUSE_IMG = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[@class=\"left-block\"]/div/a[@class=\"product_img_link\"]/img");
    public static final By ADD_BLOUSE = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[@class=\"right-block\"]/div[@class=\"button-container\"]/" +
            "a[@class=\"button ajax_add_to_cart_button btn btn-default\"]/span");
    public static final By DRESS_IMG = By.xpath("//*[@id=\"center_column\"]/ul/li[@class=\"ajax_block_product col-xs-12 col-sm-6 col-md-4 " +
            "first-in-line last-item-of-tablet-line first-item-of-mobile-line\"]/div/div[@class=\"left-block\"]/div/a[@class=\"product_img_link\"]/img");
    public static final By ADD_DRESS = By.xpath("//*[@id=\"center_column\"]/ul/li[@class=\"ajax_block_product col-xs-12 col-sm-6 col-md-4 " +
            "first-in-line last-item-of-tablet-line first-item-of-mobile-line\"]/div/div[@class=\"right-block\"]/div[@class=\"button-container\"]/" +
            "a[@class=\"button ajax_add_to_cart_button btn btn-default\"]/span");
}
