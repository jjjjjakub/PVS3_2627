package Plechovka.Basics;

public class Country {
    String name, continent;
    long populatin;
    double avgAge;

    // alt+ insert

    public Country(String name, String continent, long populatin, double avgAge) {
        this.name = name;
        this.continent = continent;
        this.populatin = populatin;
        this.avgAge = avgAge;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", populatin=" + populatin +
                ", avgAge=" + avgAge +
                '}';
    }
}
