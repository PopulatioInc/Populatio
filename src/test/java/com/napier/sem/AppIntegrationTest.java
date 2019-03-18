package com.napier.sem;

import com.napier.sem.entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppIntegrationTest {
    static populatio a;

    @BeforeAll
    static void init() {
        a = new populatio(); //Initialte a new populatio object
        a.connect("localhost:33060");
    }

    @Test
    void testGetCity() {
        City c = new City();
        c = c.getCity(1, a.con);
        assertEquals(1, c.id);
        assertEquals( "Kabul",c.name);
        assertEquals( "AFG",c.countrycode);
    }

    @Test
    void testGetCountry() {
        Country c = new Country();
        c = c.getCountry("GBR", a.con);
        assertEquals("GBR", c.countrycode);
        assertEquals( "United Kingdom",c.name);
        assertEquals( 456,c.capitalCode);
    }

    @Test
    void testCityMap() {
        HashMap<Integer, City> cityList = City.getCityList(a.con);
        City c = new City();
        c = cityList.get(1);
        assertEquals(1, c.id);
        assertEquals( "Kabul",c.name);
        assertEquals( "AFG",c.countrycode);
    }

    @Test
    void testCountryMap() {
        HashMap<String, Country> countryList = Country.getCountryList(a.con);
        Country c = new Country();
        c = countryList.get("GBR");
        assertEquals("GBR", c.countrycode);
        assertEquals( "United Kingdom",c.name);
        assertEquals( 456,c.capitalCode);
    }
}