package com.autotests.maxpay.autoqa.tests.ui.negative;

/**
 * Created by o.budilovsky on 04.07.2018.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.autotests.maxpay.autoqa.framework.SetUp.driver;
import static com.autotests.maxpay.autoqa.framework.TestDataConstants.*;
import static com.autotests.maxpay.autoqa.framework.UIPathConstants.*;
import static com.autotests.maxpay.autoqa.framework.UIRequests.typeLoginEmailInput;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginInput {

    private String randomEmail = getRandomEmail();
    private String randomPassword = getRandomPassword();

    @DataProvider
    public Object[][] testDataValidOnlyEmail() {
        return new Object[][]{
                {VALID_EMAIL, INPUT_DATA_CYRILLIC},
                {VALID_EMAIL, INPUT_DATA_EMPTY},
                {VALID_EMAIL, INPUT_DATA_SPACE},
                {VALID_EMAIL, INPUT_DATA_SPECIAL_CHARACTERS},
                {VALID_EMAIL, INPUT_DATA_NEGATIVE_NUMBER},
                {VALID_EMAIL, INPUT_LONG_STRING},
                {VALID_EMAIL, INPUT_DATA_HTML},
                {VALID_EMAIL, INPUT_DATA_XSS},
                {VALID_EMAIL, INPUT_DATA_SQL},
                {VALID_EMAIL, INPUT_DATA_CONTROL_CHARACTERS},
                {VALID_EMAIL, INPUT_DATA_JAVA_KEYWORD},
                {VALID_EMAIL, INPUT_DATA_COMPLEX_SEQUENCE}
        };
    }

    @DataProvider
    public Object[][] testDataValidOnlyPassword() {
        return new Object[][]{
                {INPUT_DATA_CYRILLIC,VALID_PASSWORD},
                {INPUT_DATA_EMPTY,VALID_PASSWORD}
        };
    }

    // Negative test with random email
    @Test(groups = { "UI" })
    public void checkLoginInputRandomLogin() throws InterruptedException  {
        typeLoginEmailInput(randomEmail, randomPassword);
        Assert.assertEquals(driver.getTitle(),LOGIN_PAGE_TITLE);
        driver.findElement(By.id(LOGIN_EMAIL_INPUT_PATH)).sendKeys("");
        driver.findElement(By.id(LOGIN_PASSWORD_INPUT_PATH)).sendKeys("");
    }

    // Negative test with invalid email
    @Test(groups = { "UI" }, dataProvider = "testDataValidOnlyPassword")
    public void checkLoginInputValidOnlyPassword(String email, String password) throws InterruptedException  {
        typeLoginEmailInput(email, password);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(visibilityOfElementLocated(By.id(LOGIN_EMAIL_ERROR)));
        Assert.assertEquals(driver.getTitle(),LOGIN_PAGE_TITLE);
        driver.findElement(By.id(LOGIN_EMAIL_INPUT_PATH)).clear();
        driver.findElement(By.id(LOGIN_PASSWORD_INPUT_PATH)).clear();
    }

    // Negative test with invalid password
    @Test(groups = { "UI" }, dataProvider = "testDataValidOnlyEmail")
    public void checkLoginInputValidOnlyEmail(String email, String password) throws InterruptedException  {
        typeLoginEmailInput(email, password);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Некорректны пароль или email')]")));
        Assert.assertEquals(driver.getTitle(),LOGIN_PAGE_TITLE);
        driver.findElement(By.id(LOGIN_EMAIL_INPUT_PATH)).clear();
        driver.findElement(By.id(LOGIN_PASSWORD_INPUT_PATH)).clear();
    }
}