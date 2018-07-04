package com.autotests.maxpay.autoqa.tests.api;

/**
 * Created by o.budilovsky on 04.07.2018.
 */

import com.autotests.maxpay.autoqa.framework.APIRequests;
import com.autotests.maxpay.autoqa.framework.SetUp;
import com.autotests.maxpay.autoqa.framework.APIPathConstants;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.autotests.maxpay.autoqa.framework.APIPathConstants.*;

public class TestsAPI extends SetUp {

    private APIRequests apiRequests = new APIRequests();
    private APIPathConstants apiPathConstants = new APIPathConstants();
    public String homeworld, peopleUrl;
    public Response responsePlanetInfoByHomeworld;


    @Test (groups = { "API" }, priority = 1)
    public void searchPeopleById() {
        Response responsePeopleInfoByID = apiRequests.getPeopleResources(1);
        homeworld = responsePeopleInfoByID.jsonPath().get(HOMEWORLD_PATH);
        peopleUrl = responsePeopleInfoByID.jsonPath().get(URL_PATH);
        Assert.assertNotNull(homeworld);
    }

    @Test (groups = { "API" }, priority = 2)
    public void searchPlanetByHomeworld() {
        responsePlanetInfoByHomeworld = apiRequests.getCustomUrl(homeworld);
        String namePlanet = responsePlanetInfoByHomeworld.jsonPath().get(NAME_PLANET_PATH);
        Assert.assertEquals(namePlanet, "Tatooine");
        String populationPlanet = responsePlanetInfoByHomeworld.jsonPath().get(POPULATION_PLANET_PATH);
        Assert.assertEquals(populationPlanet, "200000");
    }

    @Test (groups = { "API" }, priority = 3)
    public void getTitleFilmForPlanet() {

        String filmUrlFirst = responsePlanetInfoByHomeworld.jsonPath().get(apiPathConstants.getFilmByIndex(0));

        Response responseFilmInfoById = apiRequests.getCustomUrl(filmUrlFirst);
        String titleFilmForPlanet = responseFilmInfoById.jsonPath().get(TITLE_PATH);
        Assert.assertEquals(titleFilmForPlanet, "Attack of the Clones");

        ArrayList<String> planetsList = responseFilmInfoById.jsonPath().getJsonObject(PLANETS_PATH);
        if (planetsList.contains(homeworld));
        else  Assert.fail("Planet of Luke Skywalker does not belong to the film");

        ArrayList<String> charactersList = responseFilmInfoById.jsonPath().getJsonObject(CHARACTERS_PATH);
        if (charactersList.contains(peopleUrl));
        else  Assert.fail("Luke Skywalker does not belong to the film");
    }
}