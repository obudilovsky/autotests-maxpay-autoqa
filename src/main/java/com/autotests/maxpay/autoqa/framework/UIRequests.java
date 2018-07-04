package com.autotests.maxpay.autoqa.framework;

/**
 * Created by o.budilovsky on 04.07.2018.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.autotests.maxpay.autoqa.framework.UIPathConstants.LOGIN_BUTTON_XPATH;
import static com.autotests.maxpay.autoqa.framework.UIPathConstants.LOGIN_EMAIL_INPUT_PATH;
import static com.autotests.maxpay.autoqa.framework.UIPathConstants.LOGIN_PASSWORD_INPUT_PATH;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class UIRequests extends SetUp {

    public static void typeLoginEmailInput(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 0);
        wait.until(visibilityOfElementLocated(By.id(LOGIN_EMAIL_INPUT_PATH)));
        driver.findElement(By.id(LOGIN_EMAIL_INPUT_PATH)).sendKeys(email);
        driver.findElement(By.id(LOGIN_PASSWORD_INPUT_PATH)).sendKeys(password);
        driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).isDisplayed();
        driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).click();
    }
}