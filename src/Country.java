import java.util.LinkedHashMap;

public class Country {
    private final String name;
    private int population;
    private LinkedHashMap<String, City> cities = new LinkedHashMap<String, City>();

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
        isLegalData();
    }

    public void addCity(String name, int population, int timezone) {
        cities.put(name, new City(name, population, timezone));

    }

    public City getCityByName(String name) {
        return cities.get(name);
    }

    public boolean deleteCity(String name) {
        if (this.cities.containsKey(name)) {
            this.cities.remove(name);
            return true;
        } else {
            return false;
        }
    }

    public boolean isLegalData() {
        if (this.population < 0) {
            this.population = 0;
        }
        return this.population > 0;
    }

    @Override
    public String toString() {
        //Calculate the population of all cities
        int totalPopulationInAllCities =
                cities.values().stream().mapToInt(City::getPopulation).sum();
        //System.out.println("HEY " + totalPopulationInAllCities + '\n' + this.population);
        //System.out.println(this.population - totalPopulationInAllCities);

        //if (this.population == 0) {
            //totalPopulationInAllCities *= +-1;
        //}

        final String output = name
                + ": total population: " + this.population
                + ", population outside listed cities: " + (this.population - totalPopulationInAllCities)
                + ", with cities" + '\n' + cities.values().toString().replaceAll("\\[|,\\ |]", "");

        return output;
    }
}
