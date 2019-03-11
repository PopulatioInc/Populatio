package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("db");
    }

    @Test
    void testGetECity() {
        city c = app.getCity(1);
        assertEquals(c.ID, 1);
        assertEquals(c.Name, "Kabul");
        assertEquals(c.countryCode, "AFG");
        assertEquals(c.District, "Kabol");
        assertEquals(c.Population, "1780000");
    }
}
