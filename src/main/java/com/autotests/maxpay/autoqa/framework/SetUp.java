package com.autotests.maxpay.autoqa.framework;

/**
 * Created by o.budilovsky on 04.07.2018.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class SetUp {

    private GetEnvProperties envProperties = new GetEnvProperties();
    public static WebDriver driver;

    @BeforeGroups(groups = { "API" })
    public void setUpMethodAPI() {
        baseURI = envProperties.getEnvAddressAPI();
        useRelaxedHTTPSValidation();
        String testName = getClass().getDeclaredMethods()[0].getName();
        System.out.println(testName + " started");
    }

    @AfterGroups(groups = { "API" })
    public void tearDownMethodAPI() {
        String testName = getClass().getDeclaredMethods()[0].getName();
        System.out.println(testName + " ended");
        System.out.println("");
    }

    @BeforeGroups(groups = { "UI" })
    public void setUpMethodUI() throws InterruptedException{
        baseURI = envProperties.getEnvAddressUI();
        useRelaxedHTTPSValidation();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseURI);
        String testName = getClass().getDeclaredMethods()[0].getName();
        System.out.println(testName + " started");
    }

    @AfterGroups(groups = { "UI" })
    public void tearDownMethodUI() {
        if (driver != null) driver.quit();
        String testName = getClass().getDeclaredMethods()[0].getName();
        System.out.println(testName + " ended");
        System.out.println("");
    }
}
