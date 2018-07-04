package com.autotests.maxpay.autoqa.framework;

/**
 * Created by o.budilovsky on 04.07.2018.
 */

class APIRestConstants {

    public static final String GET_ALL_PEOPLE_RESOURCES_REST = "/people/";
    public String getPeopleResourcesById(int index) {
        return GET_ALL_PEOPLE_RESOURCES_REST + index + "/";
    }

}