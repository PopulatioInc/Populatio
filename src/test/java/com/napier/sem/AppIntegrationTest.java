/** package com.napier.sem;
 import org.junit.jupiter.api.BeforeAll;
 import org.junit.jupiter.api.Test;
 import java.util.ArrayList;
 public class AppIntegrationTest
 {
 static App app;
 @BeforeAll
 static void init()
 {
 app = new App();
 }
 @Test
 void getCountryTest()
 {
 ArrayList<Country> countries  = new ArrayList<Country>();
 Country myCountry = new Country();
 myCountry.Code = "ABW";
 myCountry.Name = "Aruba";
 myCountry.Continent = "North America";
 myCountry.Region = "Caribbean";
 }
 @Test
 void getCitiesTest()
 {
 ArrayList<city> cities  = new ArrayList<city>();
 city mycity = new city();
 mycity.Name = "Kabul";
 mycity.CountryCode = "AFG";
 mycity.Population = 1780000;
 }
 @Test
 void getCountrylanguagesTest()
 {
 ArrayList<countrylanguage> countrylanguages  = new ArrayList<countrylanguage>();
 countrylanguage myCountrylanguage = new countrylanguage();
 myCountrylanguage.CountryCode = "ABW";
 myCountrylanguage.Language = "Dutch";
 }
 }    */