package ru.puzikov.SberVirtualStaj.model;

public class City {
    private final String name;
    private final String region;
    private final String district;
    private final int population;
    private final String foundation;

    public City(String name, String region, String district, int population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public static CityBuilder builder() {
        return new CityBuilder();
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public String getFoundation() {
        return foundation;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation='" + foundation + '\'' +
                '}';
    }

    public static class CityBuilder {
        private String name;
        private String region;
        private String district;
        private int population;
        private String foundation;

        CityBuilder() {
        }

        public CityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CityBuilder region(String region) {
            this.region = region;
            return this;
        }

        public CityBuilder district(String district) {
            this.district = district;
            return this;
        }

        public CityBuilder population(int population) {
            this.population = population;
            return this;
        }

        public CityBuilder foundation(String foundation) {
            this.foundation = foundation;
            return this;
        }

        public City build() {
            return new City(name, region, district, population, foundation);
        }


    }
}
