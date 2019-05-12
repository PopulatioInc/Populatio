package com.napier.sem;

import java.sql.*;
import com.napier.sem.entities.*;
import java.util.Scanner;

public class populatio {
    /**
     * Connection to MySQL database.
     */
    static populatio a;

    public static void main(String[] args) {
        // Create new Application
       a = new populatio(); //Initialte a new populatio object

        // Connect to database
            if (args.length < 1)
            {
                a.connect("localhost:3306");
            }
            else
            {
            a.connect(args[0]);
            }

        a.query2();
        a.query3();
        a.query4();
        a.query5();
        a.query6();
        a.query7();
        a.query8();
        a.query9();
        a.query10();
        a.query11();
        a.query12();
        a.query13();
        a.query14();
        a.query15();
        a.query16();
        a.query17();
        a.query27();
        a.query28();
        a.query29();
        a.query30();
        a.query31();
        a.query32();


        // Disconnect from database
        a.disconnect();
    }
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect (String location)
    {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {

                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location +"/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }

    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect ()
    {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public void query2()
    {
        System.out.println("Query2 - All the countries in the world organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Population "
                            + "FROM country "
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);


            if (resultSet.next())
            {
                Country country = new Country();
                country.Name = resultSet.getString("Name");
                country.Population = resultSet.getInt("Population");
                System.out.println("");

                while(resultSet.next()) {
                    System.out.println( ", Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population"));
                }
                System.out.println("Query2 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");

        }

    }

    public void query3()
    {
        System.out.println("Query3 - All the countries in a continent organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Population, Continent "
                            + "FROM country "
                            + "ORDER BY Continent, Population DESC";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next())
            {
                Country country = new Country();
                country.Name = resultSet.getString("Name");
                country.Population = resultSet.getInt("Population");
                country.Continent = resultSet.getString("Continent");
                System.out.println("");

                while(resultSet.next()) {
                    System.out.println( ", Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population")
                            + ", Continent- " + resultSet.getString("Continent"));
                }
                System.out.println("Query3 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");

        }

    }


    public void query4()
    {
        System.out.println("Query4 - All the countries in a region organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Population, Region "
                            + "FROM country "
                            + "ORDER BY Region, Population DESC";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next())
            {
                Country country = new Country();
                country.Name = resultSet.getString("Name");
                country.Population = resultSet.getInt("Population");
                country.Region = resultSet.getString("Region");
                System.out.println("");

                while(resultSet.next()) {
                    System.out.println( ", Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population")
                            + ", Region- " + resultSet.getString("Region"));
                }
                System.out.println("Query4 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");

        }

    }

    public void query5()
    {
        System.out.println("Query5 - The top N populated countries in the world where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print( "Enter the amount of countries you would like to see - " );
        int input = scanner.nextInt();
        input += 1;

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT Name, Population "
                            + "FROM country "
                            + "ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next()) {
                Country country = new Country();
                country.Name = resultSet.getString("Name");
                country.Population = resultSet.getInt("Population");
                System.out.println("");

                while (resultSet.next()) {
                    System.out.println(", Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population"));
                }
                System.out.println("Query5 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query6()
    {
        System.out.println("Query6 - The top N populated countries in a continent where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print( "Enter the amount of countries you would like to see - " );
        int input = scanner.nextInt();
        scanner.nextLine();
        input += 1;

        System.out.println( "Enter the continent you would like to see - " );
        String input_continent = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT Name, Population, Continent "
                            + "FROM country "
                            + "WHERE Continent = \"" + input_continent + "\" "
                            + "ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next()) {
                Country country = new Country();
                country.Name = resultSet.getString("Name");
                country.Population = resultSet.getInt("Population");
                country.Continent = resultSet.getString("Continent");
                System.out.println("");

                while (resultSet.next()) {
                    System.out.println(", Continent- " + resultSet.getString( "Continent")
                            + ", Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population"));
                }
                System.out.println("Query6 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query7()
    {
        System.out.println("Query7 - The top N populated countries in a region where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print( "Enter the amount of countries you would like to see - " );
        int input = scanner.nextInt();
        scanner.nextLine();
        input += 1;

        System.out.println( "Enter the region you would like to see - " );
        String input_region = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT Name, Population, Region "
                            + "FROM country "
                            + "WHERE Region = \"" + input_region + "\" "
                            + "ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next()) {
                Country country = new Country();
                country.Name = resultSet.getString("Name");
                country.Population = resultSet.getInt("Population");
                country.Region = resultSet.getString("Region");
                System.out.println("");

                while (resultSet.next()) {
                    System.out.println(", Region- " + resultSet.getString( "Region")
                            + ", Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population"));
                }
                System.out.println("Query7 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query8()
    {
        System.out.println("Query8 - All the cities in the world organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Population "
                            + "FROM city "
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next())
            {
                city city = new city();
                city.Name = resultSet.getString("Name");
                city.Population = resultSet.getInt("Population");
                System.out.println("");

                while(resultSet.next()) {
                    System.out.println( ", Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population"));
                }
                System.out.println("Query8 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query9()
    {
        System.out.println("Query9 - All the cities in a continent organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Continent, city.Name, city.Population "
                            + "FROM country "
                            + "JOIN city ON city.CountryCode = country.Code "
                            + "ORDER BY country.Continent, city.Population DESC ";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next())
            {
                Country country = new Country();
                city city = new city();
                city.Name = resultSet.getString("Name");
                city.Population = resultSet.getInt("Population");
                country.Continent = resultSet.getString("Continent");
                System.out.println("");

                while(resultSet.next()) {
                    System.out.println( ", Continent- " + resultSet.getString("Continent")
                            + ", City Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population"));
                }
                System.out.println("Query9 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query10()
    {
        System.out.println("Query10 - All the cities in a region organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Region, city.Name, city.Population "
                            + "FROM country "
                            + "JOIN city ON city.CountryCode = country.Code "
                            + "ORDER BY country.Region, city.Population DESC ";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next())
            {
                Country country = new Country();
                city city = new city();
                city.Name = resultSet.getString("Name");
                city.Population = resultSet.getInt("Population");
                country.Region = resultSet.getString("Region");
                System.out.println("");

                while(resultSet.next()) {
                    System.out.println( ", Region- " + resultSet.getString("Region")
                            + ", City Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population"));
                }
                System.out.println("Query10 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query11()
    {
        System.out.println("Query11 - All the cities in a country organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, city.Name, city.Population "
                            + "FROM country "
                            + "JOIN city ON city.CountryCode = country.Code "
                            + "ORDER BY country.Name, city.Population DESC ";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next())
            {
                Country country = new Country();
                city city = new city();
                city.Name = resultSet.getString("Name");
                city.Population = resultSet.getInt("Population");
                country.Name = resultSet.getString("Name");
                System.out.println("");

                while(resultSet.next()) {
                    System.out.println( ", Country Name- " + resultSet.getString("country.Name")
                            + ", City Name- " + resultSet.getString("city.Name")
                            + ", Population- " + resultSet.getInt("Population"));
                }
                System.out.println("Query11 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query12()
    {
        System.out.println("Query12 - All the cities in a district organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.District, city.Population "
                            + "FROM city "
                            + "ORDER BY city.District, city.Population DESC";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next())
            {
                city city = new city();
                city.Name = resultSet.getString("Name");
                city.District = resultSet.getString("District");
                city.Population = resultSet.getInt("Population");
                System.out.println("");

                while(resultSet.next()) {
                    System.out.println( ", District- " + resultSet.getString("District")
                            + ", Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population"));
                }
                System.out.println("Query12 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query13()
    {
        System.out.println("Query13 - The top N populated cities in the world where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print( "Enter the amount of cities you would like to see - " );
        int input = scanner.nextInt();
        input += 1;

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT Name, Population "
                            + "FROM city "
                            + "ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next()) {
                city city = new city();
                city.Name = resultSet.getString("Name");
                city.Population = resultSet.getInt("Population");
                System.out.println("");

                while (resultSet.next()) {
                    System.out.println(", Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population"));
                }
                System.out.println("Query13 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query14()
    {
        System.out.println("Query14 - The top N populated cities in a continent where N is provided by the user. \n");
        Scanner scanner = new Scanner(System.in);
        System.out.print( "Enter the amount of cities you would like to see - " );
        int input = scanner.nextInt();
        scanner.nextLine();
        input += 1;

        System.out.println( "Enter the continent you would like to see - " );
        String input_continent = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT city.Name, city.Population AS Population, country.Continent "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE Continent = \"" + input_continent + "\" "
                            + "ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next()) {
                Country country = new Country();
                city city = new city();
                city.Name = resultSet.getString("Name");
                city.Population = resultSet.getInt("Population");
                country.Continent = resultSet.getString("Continent");
                System.out.println("");

                while (resultSet.next()) {
                    System.out.println(", Continent- " + resultSet.getString( "Continent")
                            + ", Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population"));
                }
                System.out.println("Query14 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query15()
    {
        System.out.println("Query15 - The top N populated cities in a region where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print( "Enter the amount of cities you would like to see - " );
        int input = scanner.nextInt();
        scanner.nextLine();
        input += 1;

        System.out.println( "Enter the region you would like to see - " );
        String input_continent = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT city.Name, city.Population AS Population, country.Region "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE Region = \"" + input_continent + "\" "
                            + "ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next()) {
                Country country = new Country();
                city city = new city();
                city.Name = resultSet.getString("Name");
                city.Population = resultSet.getInt("Population");
                country.Region = resultSet.getString("Region");
                System.out.println("");

                while (resultSet.next()) {
                    System.out.println(", Region- " + resultSet.getString( "Region")
                            + ", Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population"));
                }
                System.out.println("Query15 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query16()
    {
        System.out.println("Query16 - The top N populated cities in a country where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print( "Enter the amount of cities you would like to see - " );
        int input = scanner.nextInt();
        scanner.nextLine();
        input += 1;

        System.out.println( "Enter the country you would like to see - " );
        String input_country = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT city.Name, city.Population AS Population, country.Name "
                            + "FROM city "
                            + "JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Name = \"" + input_country + "\" "
                            + "ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next()) {
                Country country = new Country();
                city city = new city();
                city.Name = resultSet.getString("city.Name");
                country.Name = resultSet.getString("country.Name");
                city.Population = resultSet.getInt("Population");
                System.out.println("");

                while (resultSet.next()) {
                    System.out.println(", Country Name- " + resultSet.getString( "country.Name")
                            + ", City Name- " + resultSet.getString("city.Name")
                            + ", Population- " + resultSet.getInt("Population"));
                }
                System.out.println("Query16 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query17()
    {
        System.out.println("Query17 - The top N populated cities in a district where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print( "Enter the amount of cities you would like to see - " );
        int input = scanner.nextInt();
        scanner.nextLine();
        input += 1;

        System.out.println( "Enter the district you would like to see - " );
        String input_district = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT Name, Population AS Population, District "
                            + "FROM city "
                            + "WHERE District = \"" + input_district + "\" "
                            + "ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next()) {
                city city = new city();
                city.Name = resultSet.getString("Name");
                city.District = resultSet.getString("District");
                city.Population = resultSet.getInt("Population");
                System.out.println("");

                while (resultSet.next()) {
                    System.out.println(", District- " + resultSet.getString( "District")
                            + ", City Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population"));
                }
                System.out.println("Query17 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query27()
    {
        System.out.println("Query27 - The population of the world.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) AS Population "
                            + "FROM country ";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next())
            {
                System.out.printf("Population- %.0f\n", resultSet.getDouble("Population"));
                System.out.println("Query27 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query28()
    {
        System.out.println("Query28 - The population of a continent.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Enter the continent you would like to see - " );
        String input_continent = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT SUM(country.Population) AS Population, country.Continent "
                            + "FROM country "
                            + "WHERE Continent = \"" + input_continent + "\" " ;


            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next())
            {
                Country country = new Country();
                country.Continent = resultSet.getString("Continent");
                System.out.printf("Population- %.0f\n", resultSet.getDouble("Population"));
                System.out.println("Query28 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query29()
    {
        System.out.println("Query29 - The population of a region.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Enter the region you would like to see - " );
        String input_Region = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT SUM(country.Population) AS Population, Region "
                            + "FROM country "
                            + "WHERE Region = \"" + input_Region + "\" " ;


            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next())
            {
                Country country = new Country();
                country.Region = resultSet.getString("Region");
                System.out.printf("Population- %.0f\n", resultSet.getDouble("Population"));
                System.out.println("Query29 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query30()
    {
        System.out.println("Query30 - The population of a country.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Enter the country you would like to see - " );
        String input_country = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT Name, Population "
                            + "FROM country "
                            + "WHERE Name = \"" + input_country + "\" " ;


            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next())
            {
                Country country = new Country();
                country.Name = resultSet.getString("Name");
                System.out.printf("Population- %.0f\n", resultSet.getDouble("Population"));
                System.out.println("Query30 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query31()
    {
        System.out.println("Query31 - The population of a district.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Enter the district you would like to see - " );
        String input_district = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT city.District, SUM(Population) AS Population "
                            + "FROM city "
                            + "WHERE District = \"" + input_district + "\" " ;


            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next())
            {
                city city = new city();
                city.District = resultSet.getString("District");
                System.out.printf("Population- %.0f\n", resultSet.getDouble("Population"));
                System.out.println("Query31 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query32()
    {
        System.out.println("Query32 - The population of a city.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Enter the city you would like to see - " );
        String input_city = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT city.Name, Population "
                            + "FROM city "
                            + "WHERE Name = \"" + input_city + "\" " ;


            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next())
            {
                city city = new city();
                city.Name = resultSet.getString("Name");
                System.out.printf("Population- %.0f\n", resultSet.getDouble("Population"));
                System.out.println("Query31 -finished\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

}
