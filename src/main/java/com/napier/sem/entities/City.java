package com.napier.sem.entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class City {

    public City getCity(int ID, Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population "
                            + "FROM city "
                            + "WHERE ID = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new city if valid.
            // Check one is returned
            if (rset.next()) {
                City c = new City();
                c.id = rset.getInt("ID");
                c.name = rset.getString("Name");
                c.countrycode = rset.getString("CountryCode");
                c.district = rset.getString("District");
                c.population = rset.getInt("Population");
                return c;
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public void displayCity(City c)
    {
        if (c != null)
        {
            System.out.println(
                    c.id + " " + c.name + " " + c.countrycode + "\n" + c.district + "\n" + c.population + "\n");
        }
    }

    public int id;

    public String name;

    public String countrycode;

    public String district;

    public int population;
}
