package com.autotests.maxpay.autoqa.tests.ui.positive;

/**
 * Created by o.budilovsky on 04.07.2018.
 */

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.autotests.maxpay.autoqa.framework.SetUp.driver;
import static com.autotests.maxpay.autoqa.framework.TestDataConstants.VALID_EMAIL;
import static com.autotests.maxpay.autoqa.framework.TestDataConstants.VALID_PASSWORD;
import static com.autotests.maxpay.autoqa.framework.UIPathConstants.*;
import static com.autotests.maxpay.autoqa.framework.UIRequests.typeLoginEmailInput;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public class LoginInput {

    @Test (groups = { "UI" })
    public void checkStatusCode() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(driver.getCurrentUrl());
        try {
            HttpResponse response = client.execute(request);
            Assert.assertEquals(200,response.getStatusLine().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test (groups = { "UI" })
    public void checkLoginInputValidValues() throws InterruptedException {
        typeLoginEmailInput(VALID_EMAIL, VALID_PASSWORD);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(invisibilityOfElementLocated(By.id(LOGIN_EMAIL_INPUT_PATH)));
        Assert.assertEquals(driver.getTitle(),"Dashboard — Merchant portal");
        Thread.sleep(2000);
    }
}