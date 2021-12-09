/*
The City class allows the name, population and timezone of a city to be stored.
Legal data such as a minimum population size and time zone range is checked during
initialisation.
 */
public class City {

    //Output strings - to change language change these values.
    public static final String DIALOGUE_IS_MEGACITY = "It IS NOT a megacity";
    public static final String DIALOGUE_NOT_MEGACITY = "It IS a megacity";
    public static final String DIALOGUE_OUTPUT =
            "%s: has population %d and is in time zone %d. ";

    //To change the minimum population allowed in a City just change these values.
    public static final int MINIMUM_POPULATION_ALLOWED = 0;
    public static final int ERROR_VALUE = 0;

    /*
    To change the minimum population for a city to be classed as a MegaCity
    just change these values.
     */
    public static final int MINIMUM_POPULATION_FOR_MEGACITY = 10000000;

    //To change the "safe" range of allowed timezones just change these values.
    public static final int MINIMUM_TIMEZONE_ALLOWED = -12;
    public static final int MAXIMUM_TIMEZONE_ALLOWED = 11;
    public static final int FORBIDDEN_TIMEZONE = 0;

    //Declare instance variables here.
    private final String name;
    private int population;
    private int timezone;

    //Primary constructor. Checks for legal data on initialisation.
    public City(String name, int population, int timezone) {
        this.name = name;
        this.population = population;
        this.timezone = timezone;
        isLegalData();
    }

    //Returns an Integer value of the population stored in a given city.
    public int getPopulation() {
        return population;
    }

    //Returns a String value of the name stored in a given city.
    public String getName() {
        return this.name;
    }

    /*
    Returns an Integer value of the difference between the timezone of this city
    and another given City.
     */
    public int timeDifference(City name) {
        return this.timezone - name.timezone;
    }

    /*
    Returns a boolean, true if the population is greater than the minimum population
    permitted and the timezone is within the "safe" range of timezones.
     */
    public boolean isLegalData() {
        if ((this.population > MINIMUM_POPULATION_ALLOWED)
                && (this.timezone >= MINIMUM_TIMEZONE_ALLOWED)
                && (this.timezone <= MAXIMUM_TIMEZONE_ALLOWED)
                && (this.timezone != FORBIDDEN_TIMEZONE)) {
            return true;
        } else {

            if (this.population <= MINIMUM_POPULATION_ALLOWED){
                this.population = ERROR_VALUE;
            }
            if ((this.timezone < MINIMUM_TIMEZONE_ALLOWED)
                    || (this.timezone > MAXIMUM_TIMEZONE_ALLOWED)
                    || (this.timezone == FORBIDDEN_TIMEZONE)) {
                this.timezone = ERROR_VALUE;
            }
            return false;
        }
    }

    /*
    Returns a boolean, true if the city meets the minimum population required
    to be classed as a megacity.
     */
    public boolean isMegaCity() {
        return population <= MINIMUM_POPULATION_FOR_MEGACITY;
    }

    //Returns a formatted String of the data stored in the city object.
    @Override
    public String toString() {
        final String output = String.format(DIALOGUE_OUTPUT, name, population, timezone);

        final String isMegaCity = (isMegaCity())? DIALOGUE_IS_MEGACITY: DIALOGUE_NOT_MEGACITY;

        return output + isMegaCity + '\n';
    }
}
