public class City {

    //Output strings - to change language change this values.
    public static final String DIALOGUE_IS_MEGACITY = "It IS NOT a megacity";
    public static final String DIALOGUE_NOT_MEGACITY = "It IS a megacity";
    public static final String DIALOGUE_OUTPUT =
            "%s: has population %d and is in time zone %d. ";

    //To change the minimum population allowed in a country just change this value.
    public static final int MINIMUM_POPULATION_ALLOWED = 0;

    //To change the range of allowed timezones just change these values
    public static final int MINIMUM_TIMEZONE_ALLOWED = -12;
    public static final int MAXIMUM_TIMEZONE_ALLOWED = 11;
    public static final int FORBIDDEN_TIMEZONE = 0;

    public static final int MINIMUM_POPULATION_FOR_MEGACITY = 10000000;
    public static final int ERROR_VALUE = 0;

    private final String name;
    private int population;
    private int timezone;

    public City(String name, int population, int timezone) {
        this.name = name;
        this.population = population;
        this.timezone = timezone;
        isLegalData();
    }

    public int getPopulation() {
        return population;
    }

    public String getName() {
        return this.name;
    }

    public int timeDifference(City name) {
        return this.timezone - name.timezone;
    }

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

    @Override
    public String toString() {
        final String output = String.format(DIALOGUE_OUTPUT, name, population, timezone);
        //is a megacity?
        final String isMegaCity =
                (population <= MINIMUM_POPULATION_FOR_MEGACITY)
                        ? DIALOGUE_IS_MEGACITY : DIALOGUE_NOT_MEGACITY;
        return output + isMegaCity + '\n';
    }
}
