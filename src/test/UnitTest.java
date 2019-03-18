import com.napier.sem.entities.*;
import com.napier.sem.populatio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest
{
    private Connection con = null;

    @BeforeAll
    static void init()
    {
        populatio a = new populatio(); //Initialte a new populatio object
        a.connect();
    }

    //Test city
    @Test
    void testGetCity()
    {
        populatio a = new populatio(); //Initialte a new populatio object

        a.connect();

        City c = new City();
        c = c.getCity(1, a.con);
        assertEquals(1, c.id);
        assertEquals( "Kabul",c.name);
        assertEquals( "AFG",c.countrycode);
    }

    //Test country
    @Test
    void testGetCountry()
    {
        populatio a = new populatio();
        a.connect();

        Country c = new Country();
        c = c.getCountry(1, a.con);
        assertEquals(1, c.id);
        assertEquals( "China",c.name);
        assertEquals( "CHN",c.countrycode);
    }

    //Test languages
    @Test
    void testGetLang()
    {
        populatio a = new populatio();
        a.connect();

        Country c = new Country();
        c = c.getLanguage("AUS", a.con);
        assertEquals("AUS", c.countrycode);
    }
}

