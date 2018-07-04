package com.autotests.maxpay.autoqa.framework;

/**
 * Created by o.budilovsky on 04.07.2018.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetEnvProperties {

    private Properties prop = new Properties();

    public GetEnvProperties() {

        File file = new File(System.getProperty("user.dir") + "/src/main/resources/properties/env.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEnvAddressAPI() {
        return prop.getProperty("ENV_API");
    }

    public String getEnvAddressUI() {
        return prop.getProperty("ENV_UI");
    }
}