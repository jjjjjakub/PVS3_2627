package Moje_slozka.Basics;

import fileworks.DataExport;
import fileworks.DataImport;

public class ParseFile {
    public static void main(String[] args) {
        String path = "data/countries.txt";
        DataImport di = new DataImport(path);

        //di.printFile();
        //System.out.println(di.readLine()); výpis 1 řádku

        // TODO: vypsat informace jednoho řádku


      //  while (di.hasNext()){
      //      String[] data = di.readLine().split(";");
//
      //      String name = data[0];
      //      String continent = data[1];
      //      long population = Long.parseLong(data[2]);
      //      double avgAge = Double.parseDouble(data[3]);
//
      //      System.out.println(name);
      //      System.out.println(continent);
      //      System.out.println(population);
      //      System.out.println(avgAge);
      //  }

        DataExport de = new DataExport("output.txt");
        while (di.hasNext()){
            String[] data = di.readLine().split(";");

            Country country = new Country(data[0], data[1], Long.parseLong(data[2]), Double.parseDouble(data[3]));
            if (data[1].contains("Europe")){
                de.writeLine(country.toString());
            }

        }
        //Country czechia = new Country("Czech Republic","Europe", 10000000, 85.0);

        //System.out.println(czechia);
        de.finishExport();
        di.finishImport();
    }
}
