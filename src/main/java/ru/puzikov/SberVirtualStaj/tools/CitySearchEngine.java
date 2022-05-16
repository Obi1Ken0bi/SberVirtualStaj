package ru.puzikov.SberVirtualStaj.tools;

import ru.puzikov.SberVirtualStaj.model.City;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CitySearchEngine {
    private final List<City> cityList;

    public CitySearchEngine(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<City> cityByName() {
        return cityList.stream().sorted(Comparator.comparing(City::getName)).collect(Collectors.toList());
    }

    public List<City> cityByDistrictAndName() {
        return cityList.stream().sorted(Comparator.comparing(City::getDistrict).thenComparing(City::getName))
                .collect(Collectors.toList());
    }
}
