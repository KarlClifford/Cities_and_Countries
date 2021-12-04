import java.util.LinkedHashMap;

public class Country {
    public static final int MINIMUM_POPULATION_ALLOWED = 0;
    public static final int ERROR_VALUE = 0;
    public static final String DIALOGUE_OUTPUT =
            "%s: total population: %d, population outside listed cities: %d, with cities\n%s";

    private final String name;
    private int population;
    private final LinkedHashMap<String, City> citiesMap = new LinkedHashMap<>();

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
        isLegalData();
    }

    public void addCity(String name, int population, int timezone) {
        citiesMap.put(name, new City(name, population, timezone));

    }

    public City getCityByName(String name) {
        return citiesMap.get(name);
    }

    public boolean deleteCity(String name) {
        if (this.citiesMap.containsKey(name)) {
            this.citiesMap.remove(name);
            return true;
        } else {
            return false;
        }
    }

    public boolean isLegalData() {
        if (this.population < MINIMUM_POPULATION_ALLOWED) {
            this.population = ERROR_VALUE;
        }
        return this.population > 0;
    }

    @Override
    public String toString() {
        //Calculate the population of all cities
        int totalPopulationInAllCities =
                citiesMap.values().stream().mapToInt(City::getPopulation).sum();

        return DIALOGUE_OUTPUT.formatted(name, this.population,
                this.population - totalPopulationInAllCities,
                citiesMap.values().toString().replaceAll("\\[|, |]", ""));
    }
}
