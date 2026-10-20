package Moje_slozka.OOP.Inheritance;

public class Doctor {
    final static int BASE_SALARY = 50000;
    String name;
    int salary;

    Doctor(String name){
        this.name = name;
        salary = BASE_SALARY;
    }

    void diagnose() {
        System.out.println("Figuring out whats wrong whith you...");
        salary += 10000;
    }

}
