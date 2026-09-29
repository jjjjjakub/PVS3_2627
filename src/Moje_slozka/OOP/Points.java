package Moje_slozka.OOP;

public class Points {


    public static void main(String[] args) {
        Point a = new Point(44.3,33.2);
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
