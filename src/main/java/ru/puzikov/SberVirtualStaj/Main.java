package ru.puzikov.SberVirtualStaj;

import ru.puzikov.SberVirtualStaj.model.City;
import ru.puzikov.SberVirtualStaj.tools.CityParser;
import ru.puzikov.SberVirtualStaj.tools.CitySearchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("city_ru.csv");
        CityParser cityParser = new CityParser(file);
        try {
            List<City> cities = cityParser.parse();
            print(cities);
            CitySearchEngine citySearchEngine = new CitySearchEngine(cities);
            System.out.println("sorted by name:");
            print(citySearchEngine.cityByName());
            System.out.println("sorted by district and name:");
            print(citySearchEngine.cityByDistrictAndName());
            System.out.println(citySearchEngine.cityWithMostPopulation());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void print(List<City> cities) {
        for (City city : cities) {
            System.out.println(city);
        }
    }
}
