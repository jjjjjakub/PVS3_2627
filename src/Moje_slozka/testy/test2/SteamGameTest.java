package Moje_slozka.testy.test2;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.List;

// Soubor má 4 sloupečky oddělené znakem "\t" - tabulátor
// name	price	num_reviews_total	short_description
// Některé řádky nemusí obsahovat krátký popisek

// Naimplementujte třídu reprezentující 1 hru/řádek
// Načtěte soubor
// Naimplementujte jednotlivé metody
class Game{
    String name;
    double price;
    int num_reviews_total;
    String short_description;

    public Game(String name, double price, int num_reviews_total, String short_description) {
        this.name = name;
        this.price = price;
        this.num_reviews_total = num_reviews_total;
        this.short_description = short_description;
    }

    public Game(String name, double price, int num_reviews_total) {
        this.name = name;
        this.price = price;
        this.num_reviews_total = num_reviews_total;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getNum_reviews_total() {
        return num_reviews_total;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNum_reviews_total(int num_reviews_total) {
        this.num_reviews_total = num_reviews_total;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", num_reviews_total=" + num_reviews_total +
                ", short_description='" + short_description + '\'' +
                '}';
    }
}
public class SteamGameTest {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/steam_games.txt");
        List<Game> games = new ArrayList<>();

        while (di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split("\t");

            switch (tokens.length){
                case 4:
                    games.add(new Game(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]));
                    break;
                case 3:
                    games.add(new Game(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2])));
                    break;
            }
        }
        di.finishImport();


        System.out.println("Games total loaded: " + games.size());

        System.out.println("Number of free games: " + totalFreeGames(games));
        System.out.println("Average number of reviews per game: " + avgReviewPerGame(games));
        System.out.println("The most expensive game is: " + mostExpansive(games));

        System.out.println(games.get(0));                   // zdarma
        System.out.println(games.get(games.size() / 2));    // placené
    }

    private static Game mostExpansive(List<Game> games) {
        // TODO: vrátit nejdražší hru
        Game mostExpensive = new Game("TBT", 0.0, 0, "");
        int i = 0;
        for (Game a : games) {

            if (mostExpensive.price <= games.get(i).price) {
                mostExpensive.name = games.get(i).name;
                mostExpensive.price = games.get(i).price;
                mostExpensive.num_reviews_total = games.get(i).num_reviews_total;
                mostExpensive.short_description = games.get(i).short_description;
            }
            i++;
        }

        return mostExpensive;
    }

    private static long totalFreeGames(List<Game> games) {
        // TODO: vrátit počet her, které jsou zdarma
        int a = 0;
        for (Game g:games) {
            if (g.price == 0.0) {
                a++;
            }
        }
        return a;
    }
    private static double avgReviewPerGame(List<Game> games) {
        // TODO: vrátit průměrný počet hodnocení
        return 0.0; // tento řádek smažte
    }
}

