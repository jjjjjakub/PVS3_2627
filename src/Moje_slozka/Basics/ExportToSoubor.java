package Moje_slozka.Basics;

import fileworks.DataExport;
import fileworks.DataImport;
//načíst ze souboru
//rozdělit
public class ExportToSoubor {
    public static void main(String[] args) {
        String path = "data/countries.txt";
        DataImport di = new DataImport(path);


        Country bestAge = new Country("TBD", "TBD", 42, Double.MIN_VALUE);
        Country worstPopulation = new Country("TBD", "TBD", Long.MAX_VALUE, 42);

        while (di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split(";");

            String name = tokens[0];
            String continent = tokens[1];
            long population = Long.parseLong(tokens[2]);
            double averageAge = Double.parseDouble(tokens[3]);

            if (bestAge.avgAge < averageAge) {
                bestAge.name = name;
                bestAge.continent = continent;
                bestAge.population = population;
                bestAge.avgAge = averageAge;
            }

            if(worstPopulation.population > population){
                worstPopulation.name = name;
                worstPopulation.continent = continent;
                worstPopulation.population = population;
                worstPopulation.avgAge = averageAge;
            }

        }
        System.out.println("------");
        System.out.println("Nejhorsi populace: " + worstPopulation);
        System.out.println("Nejlepsi doba doziti: " + bestAge);
        di.finishImport();
    }
}
