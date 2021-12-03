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

    @Override
    public String toString() {
        final String output = name
                + ": has population " + population
                + " and is in time zone " + timezone + " ";
        //is a megacity?
        final String isMegaCity =
                (population >= 10000000)?"It Is NOT a megacity":"It Is a megacity";
        return output + isMegaCity + '\n';
    }
}
