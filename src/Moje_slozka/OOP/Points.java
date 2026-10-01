package Moje_slozka.OOP;

import fileworks.DataImport;

import java.util.ArrayList;

public class Points {
    public static void main(String[] args) {

        ArrayList<Point> points = new ArrayList<>();
        DataImport di = new DataImport("data/points.txt");

        while (di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split(",");

            switch (tokens.length){
                case 2:
                    points.add(new Point(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1])));
                    break;
                case 3:
                    points.add(new Point(tokens[0] ,Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
                    break;
                case 4:
                    points.add(new Point(tokens[0] ,Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3])));
                    break;
            }
        }
        di.finishImport();
        System.out.println(points);
    }
}
class Point {
    private String name;
    private Double x, y, z;
    private static int pointsCreated = 1;

    final double DEFAULT_Z = 0;

    public Point(String name, Double x, Double y, Double z) {
        this (name, x, y);
        this.z = z;
    }

    public Point(String name, Double x, Double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        z = DEFAULT_Z;
    }

    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
        z = DEFAULT_Z;
        name = "Points#" + pointsCreated;
        pointsCreated++;
    }

    @Override
    public String toString() {
        return name + x + y + z;
    }
}
