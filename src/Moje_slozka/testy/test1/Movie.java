package Moje_slozka.testy.test1;

import fileworks.DataExport;
import fileworks.DataImport;

public class Movie {
    String name;
    int year;
    String zanr;
    double rating;

    public Movie(String name, int year, String zanr, double rating) {
        this.name = name;
        this.year = year;
        this.zanr = zanr;
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", zanr='" + zanr + '\'' +
                ", rating=" + rating +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getZanr() {
        return zanr;
    }

    public double getRating() {
        return rating;
    }

    public static void main(String[] args) {
        String path = "data/movieList.txt";
        DataImport di = new DataImport(path);
        DataExport de = new DataExport("horrors.txt");
        int pocet = 0;

        Movie bestRating = new Movie("TBT", 0, "TBT", Double.MIN_VALUE);



        while (di.hasNext()){
            String film = di.readLine();
            String[] tokens = film.split(";");

            String name = tokens[0];
            int year = Integer.parseInt(tokens[1]);
            String zanr = tokens [2];
            double rating = Double.parseDouble(tokens[3]);

            Movie movie = new Movie(name, year, zanr, rating);

            if (bestRating.rating < rating){
                bestRating.name = name;
                bestRating.year = year;
                bestRating.zanr = zanr;
                bestRating.rating = rating;
            }

            if (bestRating.year >= 2000){
                pocet +=1;
            }

            if (zanr.equals("Horror")){
                de.writeLine(movie.toString());
            }

        }
        de.finishExport();
        di.finishImport();
        //nejlepsi film
        System.out.println(bestRating);
        //pocet filmu
        System.out.println(pocet);
    }
}
