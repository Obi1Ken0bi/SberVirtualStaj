package ru.puzikov.SberVirtualStaj.tools;

import ru.puzikov.SberVirtualStaj.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityParser {
    private final File file;

    public CityParser(File file) {
        this.file = file;
    }

    public List<City> parse() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<City> cities = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] params = line.split(";");
            System.out.println(params[0]);
            City city = City.builder()
                    .name(params[1])
                    .region(params[2])
                    .district(params[3])
                    .population(Integer.parseInt(params[4]))
                    .foundation(params.length < 6 ? null : params[5])
                    .build();
            cities.add(city);

        }
        return cities;
    }
}
