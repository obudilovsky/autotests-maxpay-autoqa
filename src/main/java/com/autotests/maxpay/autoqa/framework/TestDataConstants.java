package com.autotests.maxpay.autoqa.framework;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by o.budilovsky on 04.07.2018.
 */

public class TestDataConstants {

    // POSITIVE INPUT DATA LIST
    public static final String VALID_EMAIL = "qa+test+user@maxpay.com";
    public static final String VALID_PASSWORD = "21TSeWbq";

    // NEGATIVE INPUT DATA LIST
    public static String getRandomEmail() {
        return RandomStringUtils.randomAlphanumeric(12) + "@maxpay.com";
    }

    public static String getRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(12);
    }

    public static final String INPUT_DATA_EMPTY = "";
    public static final String INPUT_DATA_SPACE = " ";
    public static final String INPUT_DATA_SPECIAL_CHARACTERS = "~!@#$%^&*()?_-+{}[]:;\"'<.>,/\\";
    public static final String INPUT_DATA_NEGATIVE_NUMBER = "-1";
    public static final String INPUT_LONG_STRING = "longStringlongStringlongStringlongStringlongStringlongStringlongStringlongStringlongStringlongString";
    public static final String INPUT_DATA_HTML = "<form action=”http://live.hh.ru”><input type=”submit”></form>";
    public static final String INPUT_DATA_XSS = "<script>alert(123)</script>";
    public static final String INPUT_DATA_SQL = "‘ or ‘a’ = ‘a’; DROP TABLE user; SELECT * FROM blog WHERE code LIKE ‘a%’;";
    public static final String INPUT_DATA_CONTROL_CHARACTERS = "\\n ^Z \\0 0x00 CR U+0000 <control-001A>";
    public static final String INPUT_DATA_JAVA_KEYWORD = "break";
    public static final String INPUT_DATA_COMPLEX_SEQUENCE = "“♣☺♂©₱ﭹ  ∑\uF000”";

}
