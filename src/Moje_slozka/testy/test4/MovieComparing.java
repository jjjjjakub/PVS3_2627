package Moje_slozka.testy.test4;
//Doplnte atributy pro Film
//
//Jsou jimi:
//Název filmu,
//Rok vydani,
//rating (4.5, 7.8... vyssi = lepsi)
//doba trvani ve vterinach
//
//Vypis do konzole:
//Vypsano serazene dle data vydani od nejstarsich
//Vypsano serazeno dle jmena
//TOP 10 filmu dle ratingu

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Comparator;

//Link na odevzdani GIST:
//https://forms.cloud.microsoft/Pages/ResponsePage.aspx?id=f_BDFfkwekCetYp67EGP_1pSNPXTVBFPg7PGychWGEdUM040WFhKVFpJQ1RBUVZYVUU2MUYxS0hETCQlQCNjPTEu
public class MovieComparing {

    public static ArrayList<Movie> sortYear(ArrayList<Movie> movies) {
        movies.sort(Comparator.comparingInt(Movie::getYear));

        return movies;
    }

    public static ArrayList<Movie> sortName(ArrayList<Movie> movies) {
        movies.sort(Comparator.comparing(Movie::getName));
        return movies;
    }

    public static void topTen(ArrayList<Movie> movies) {
        movies.sort(Comparator.comparingDouble(Movie::getRating).reversed());
        for (int i = 0; i < 10; i++) {
            System.out.println(movies.get(i).toString());
        }
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/Movies.txt");
        ArrayList<Movie> movies = new ArrayList<>();

        while (di.hasNext()) {
            String line = di.readLine();
            String[] tokens = line.split(";");

            Movie movie = new Movie(tokens[0],
                    Integer.parseInt(tokens[1]),
                    Double.parseDouble(tokens[2]),
                    Integer.parseInt(tokens[3]));

            movies.add(movie);
        }
        System.out.println(sortYear(movies).toString());
        System.out.println(sortName(movies).toString());
        topTen(movies);
        di.finishImport();
    }
}
class Movie {
    String name;
    int year;
    double rating;
    int length;

    public Movie(String name, int year, double rating, int length) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", length=" + length +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public int getLength() {
        return length;
    }
}