package ru.puzikov.SberVirtualStaj.tools;

import ru.puzikov.SberVirtualStaj.model.City;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CitySearchEngine {
    private final List<City> cityList;

    public CitySearchEngine(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<City> cityByName() {
        return cityList.stream().sorted((x, y) -> x.getName().compareToIgnoreCase(y.getName())).collect(Collectors.toList());
    }

    public List<City> cityByDistrictAndName() {
        return cityList.stream().sorted(Comparator.comparing(City::getDistrict).thenComparing(City::getName))
                .collect(Collectors.toList());
    }

    public String cityWithMostPopulation(){
        City[] cities = cityList.toArray(new City[0]);
        int maxPopulation=Integer.MIN_VALUE;
        int maxPopulationId=0;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].getPopulation()>maxPopulation){
                maxPopulation=cities[i].getPopulation();
                maxPopulationId=i;
            }
        }
        return ("[%d] = %d".formatted(maxPopulationId, maxPopulation));
    }
    public Map<String, Integer> regionsCityNumbers(){
        Map<String,Integer> regionMap=new HashMap<>();
        for (City city : cityList) {
            String region = city.getRegion();
            regionMap.put(region, regionMap.getOrDefault(region, 0) + 1);
        }
        return regionMap;
    }
}
