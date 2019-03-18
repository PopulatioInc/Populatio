package com.napier.sem;

import com.napier.sem.entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
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

        a.disconnect();
    }

    @Test
    void testGetCountry() {
        Country c = new Country();
        c = c.getCountry("GBR", a.con);
        assertEquals("GBR", c.countrycode);
        assertEquals( "United Kingdom",c.name);
        assertEquals( "London",c.capital);
    }
}