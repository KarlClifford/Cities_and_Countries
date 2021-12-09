/*
FEEDBACK RESPONSE FROM CW1:
- Improved comment layouts. For example, ensured that multi-line comments start on
  a new line.
- Improved comment explanations. They are now shorter, more to the point and
  precise for better readability and to better explain what the code is achieving.

 */

import java.util.LinkedHashMap;

/*
The Country class allows the name, population and an array of cities in a country
to be stored. Legal data such as a minimum population size is checked during
initialisation.
 */
public class Country {

    //Output string - to change language change this value.
    public static final String DIALOGUE_OUTPUT =
            "%s: total population: %d, population outside listed cities: %d, with cities\n%s";

    //To change the minimum population allowed in a country just change these values.
    public static final int MINIMUM_POPULATION_ALLOWED = 0;
    public static final int ERROR_VALUE = 0;

    //Declare instance variables here.
    private final String name;
    private int population;
    private final LinkedHashMap<String, City> citiesMap = new LinkedHashMap<>();

    //Primary constructor. Checks for legal data on initialisation.
    public Country(String name, int population) {
        this.name = name;
        this.population = population;
        isLegalData();
    }

    //Call to add a new city object to the citiesMap.
    public void addCity(String name, int population, int timezone) {
        citiesMap.put(name, new City(name, population, timezone));

    }

    /*
    Returns a City object from citiesMap by its key value and Makes sure that the
    key value exists first.
     */
    public City getCityByName(String name) {
        return citiesMap.containsKey(name)
                ? citiesMap.get(name) : new City(" ", 0, 0);
    }

    /*
    Returns a boolean, true if the city was removed correctly or false if
    the city doesn't exist.
     */
    public boolean deleteCity(String name) {
        if (this.citiesMap.containsKey(name)) {
            this.citiesMap.remove(name);
            return true;
        } else {
            return false;
        }
    }

    /*
    Returns a boolean, true if the population is greater than the minimum population
    permitted.
     */
    public boolean isLegalData() {
        if (this.population < MINIMUM_POPULATION_ALLOWED) {
            this.population = ERROR_VALUE;
        }
        return this.population > MINIMUM_POPULATION_ALLOWED;
    }

    //Returns a formatted String of the name and population of the country and all city objects.
    @Override
    public String toString() {
        //Calculate the population in all cities by adding them together.
        int totalPopulationInAllCities =
                citiesMap.values().stream().mapToInt(City::getPopulation).sum();

        return String.format(DIALOGUE_OUTPUT, name, this.population,
                this.population - totalPopulationInAllCities,
                citiesMap.values().toString().replaceAll("\\[|, |]", ""));
    }
}
