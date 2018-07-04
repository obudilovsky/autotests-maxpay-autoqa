package com.autotests.maxpay.autoqa.framework;

/**
 * Created by o.budilovsky on 04.07.2018.
 */

public class APIPathConstants {

    public static final String HOMEWORLD_PATH = "homeworld";
    public static final String URL_PATH = "url";
    public static final String NAME_PLANET_PATH = "name";
    public static final String POPULATION_PLANET_PATH = "population";
    public static final String FILMS_PATH = "films";
    public static final String TITLE_PATH = "title";
    public static final String PLANETS_PATH = "planets";
    public static final String CHARACTERS_PATH = "characters";

    public String getFilmByIndex (int index) {
        return FILMS_PATH + "[" + index + "].";
    }
}