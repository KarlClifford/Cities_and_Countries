public class City {
    private final String name;
    private final int population;
    private final int timezone;

    public City(String name, int population, int timezone) {
        this.name = name;
        this.population = population;
        this.timezone = timezone;
    }

    public int getPopulation() {
        return population;
    }

    public String getName() { return this.name; }

    public int timeDifference(City name) {
        return this.timezone - name.timezone;
    }

    public boolean isLegalData() {
        return (this.population < 0) && (this.timezone > -12) || (this.timezone < 11);
    }

    @Override
    public String toString() {
        final String output = name
                + ": has population " + population
                + " and is in time zone " + timezone + ". ";
        //is a megacity?
        final String isMegaCity =
                (population <= 10000000)?"It IS NOT a megacity":"It IS a megacity";
        return output + isMegaCity + '\n';
    }
}
