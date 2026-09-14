package Moje_slozka.Basics;

public class Country {
    String name, continent;
    long population;
    double avgAge;

    // alt+ insert

    public Country(String name, String continent, long populatin, double avgAge) {
        this.name = name;
        this.continent = continent;
        this.population = populatin;
        this.avgAge = avgAge;
        setAvgAge(avgAge);
    }

    public Country(String name, long population, double avgAge) {
        this.name = name;
        this.population = population;
        this.continent = "Not specified";
        this.avgAge = avgAge;
        setAvgAge(avgAge);
    }

    public void setAvgAge(double avgAge) {
        this.avgAge = avgAge;
        if (avgAge >= 20 && avgAge <= 100){
            this.avgAge = avgAge;
        }
        else {
            this.avgAge = 0.0d;
        }
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", avgAge=" + avgAge +
                '}';
    }
}
