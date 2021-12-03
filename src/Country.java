import java.util.LinkedHashMap;

public class Country {
    private final String name;
    private final int population;
    private LinkedHashMap<String, City> cities = new LinkedHashMap<String, City>();

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public void addCity(String name, int population, int timezone) {
        cities.put(name, new City(name, population, timezone));

    }

    public City getCityByName(String name) {
        return cities.get(name);
    }

    @Override
    public String toString() {
        //Calculate the population of all cities
        int totalPopulationInAllCities =
                cities.values().stream().mapToInt(City::getPopulation).sum();

        final String output = name
                + ": total population: " + population
                + ", population outside listed cities: " + (population - totalPopulationInAllCities)
                + ", with cities" + '\n' + cities.values().toString().replaceAll("\\[|,\\ |]", "");

        return output;
    }
}
