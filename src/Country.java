/*
.........
 */
import java.util.LinkedHashMap;

public class Country {

    //To change the minimum population allowed in a country just change these values
    public static final int MINIMUM_POPULATION_ALLOWED = 0;
    public static final int ERROR_VALUE = 0;

    //Output strings - to change language change this values
    public static final String DIALOGUE_OUTPUT =
            "%s: total population: %d, population outside listed cities: %d, with cities\n%s";

    //Declare instance variables here
    private final String name;
    private int population;
    private final LinkedHashMap<String, City> citiesMap = new LinkedHashMap<>();

    //Primary constructor. Checks for legal data on class initialisation.
    public Country(String name, int population) {
        this.name = name;
        this.population = population;
        isLegalData();
    }

    //Call to add a new city object to the citiesMap
    public void addCity(String name, int population, int timezone) {
        citiesMap.put(name, new City(name, population, timezone));

    }

    //Returns a City object requested based on the name parameter entered
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
        //Calculate the population of all cities combined
        int totalPopulationInAllCities =
                citiesMap.values().stream().mapToInt(City::getPopulation).sum();

        return DIALOGUE_OUTPUT.formatted(name, this.population,
                this.population - totalPopulationInAllCities,
                citiesMap.values().toString().replaceAll("\\[|, |]", ""));
    }
}
