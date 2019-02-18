package com.napier.sem.entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
                City c = new City(); //Create placeholder for City
                c.id = rset.getInt("ID"); //Get ID and put into City
                c.name = rset.getString("Name"); //Get Name and put into City
                c.countrycode = rset.getString("CountryCode"); //and so on.
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
