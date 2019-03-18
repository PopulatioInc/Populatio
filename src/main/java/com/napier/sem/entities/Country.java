package com.napier.sem.entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Country {

    public Country getCountry(String code, Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement(); //Create mySQL statement placeholder
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, Continent, Region, Population, Capital " //Statement takes in SQL request
                            + "FROM country "
                            + "WHERE country.Code = '" + code + "'"; //currently based on ID provided by getCity
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect); //Executes the SQL query and saves it to rset
            // Return new city if valid.
            // Check one is returned
            if (rset.next()) {
                return countryFetch(rset);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public HashMap<String,Country> getCountryList(Connection con) {
        HashMap<String,Country> countryList = new HashMap<String,Country>();
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT country.Code, country.Name, Continent, Region, Population, Capital " //Statement takes in SQL request
                            + "FROM country ";
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()) {
                int numColumns = rset.getMetaData().getColumnCount();
                for(int i = 1; i <= numColumns; i++) {
                    countryList.put(countryFetch(rset).countrycode, countryFetch(rset));
                }
            }
            return countryList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    private Country countryFetch(ResultSet rset) throws SQLException {
        Country c = new Country(); //Create placeholder for City
        c.countrycode = rset.getString("Code"); //Get ID and put into City
        c.name = rset.getString("Name"); //Get Name and put into City
        c.continent = rset.getString("Continent"); //and so on.
        c.capitalCode = rset.getInt("Capital");
        c.population = rset.getInt("Population");
        return(c);
    }

    public String countrycode;

    public String name;

    public String continent;

    public String region;

    public int population;

    public int capitalCode;

}
