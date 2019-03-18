package com.napier.sem.entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Country {

    public Country getCountry(String code, Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement(); //Create mySQL statement placeholder
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital " //Statement takes in SQL request
                            + "FROM country "
                            + "WHERE Code = " + code; //currently based on ID provided by getCity
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect); //Executes the SQL query and saves it to rset
            // Return new city if valid.
            // Check one is returned
            if (rset.next()) {
                Country c = new Country(); //Create placeholder for City
                c.countrycode = rset.getString("Code"); //Get ID and put into City
                c.name = rset.getString("Name"); //Get Name and put into City
                c.continent = rset.getString("Continent"); //and so on.
                c.capital = rset.getString("Capital");
                c.population = rset.getInt("Population");
                return c;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public String countrycode;

    public String name;

    public String continent;

    public String region;

    public int population;

    public String capital;

}
