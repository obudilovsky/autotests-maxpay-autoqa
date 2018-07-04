package com.autotests.maxpay.autoqa.framework;

/**
 * Created by o.budilovsky on 04.07.2018.
 */

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIRequests extends SetUp {

    private APIRestConstants pathConstants = new APIRestConstants();

    public Response getCustomUrl(String url) {
        Map<String, String> json = new HashMap<>();

        return given().
                    header("Content-Type", "application/json").
                    body(json).
                when().
                    log().all().
                    get(url).
                then().
                    log().all().
                extract().
                    response();
    }

    public Response getPeopleResources(int id) {
        Map<String, String> json = new HashMap<>();

        return given().
                        header("Content-Type", "application/json").
                        body(json).
                when().
                        log().all().
                        get(pathConstants.getPeopleResourcesById(id)).
                then().
                        log().all().
                extract().
                        response();
    }

}