package com.napier.sem;

import com.napier.sem.entities.*;
import com.napier.sem.populatio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    static populatio a;

    @BeforeAll
    static void init() {
        a = new populatio(); //Initialte a new populatio object
    }

    @Test
    void testGetCity() {
        a.connect();

        City c = new City();
        c = c.getCity(1, a.con);
        assertEquals(1, c.id);
        assertEquals( "Kabul",c.name);
        assertEquals( "AFG",c.countrycode);
    }
}