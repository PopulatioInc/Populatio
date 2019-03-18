package com.napier.sem.entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class City {

    public City getCity(int ID, Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement(); //Create mySQL statement placeholder
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population " //Statement takes in SQL request
                            + "FROM city "
                            + "WHERE ID = " + ID; //currently based on ID provided by getCity
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect); //Executes the SQL query and saves it to rset
            // Return new city if valid.
            // Check one is returned
            if (rset.next()) {
                return cityFetch(rset);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public static HashMap<Integer,City> getCityList(Connection con) {
        HashMap<Integer,City> cityList = new HashMap<Integer, City>();
        try {
            for (int i = 1; i < 4079; i++) {
                Statement stmt = con.createStatement();
                String strSelect =
                        "SELECT ID, Name, CountryCode, District, Population " //Statement takes in SQL request
                                + "FROM city "
                                + "WHERE ID = " + i;
                ResultSet rset = stmt.executeQuery(strSelect);
                if (rset.next()) {
                    cityList.put(i, cityFetch(rset));
                } else {
                    return null;
                }
            }
            return cityList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    private static City cityFetch(ResultSet rset) throws SQLException {
        City c = new City(); //Create placeholder for City
        c.id = rset.getInt("ID"); //Get ID and put into City
        c.name = rset.getString("Name"); //Get Name and put into City
        c.countrycode = rset.getString("CountryCode"); //and so on.
        c.district = rset.getString("District");
        c.population = rset.getInt("Population");
        return c;
    }


    public void displayCity(City c) //Displays the city data.
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
