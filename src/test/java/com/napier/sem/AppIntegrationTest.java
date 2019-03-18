package com.napier.sem;

import com.napier.sem.entities.City;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static populatio a;

    @BeforeAll
    static void init()
    {
        a = new populatio();
        a.connect("localhost:33060");
    }

    @Test
    void testGetEmployee()
    {
        City c = new City();
        c = c.getCity(1, a.con);
        assertEquals(1, c.id);
        assertEquals( "Kabul",c.name);
        assertEquals( "AFG",c.countrycode);

        a.disconnect();
    }
}