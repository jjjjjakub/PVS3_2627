package Moje_slozka.OOP.Inheritance;

import java.util.Dictionary;

public class Hospital {
    public static void main(String[] args) {

        Doctor doctor = new Doctor("Jeff");
        System.out.println(doctor.name);
        System.out.println(doctor.salary);
        doctor.diagnose();

        Surgeon surgeon = new Surgeon("Hreff");
        System.out.println(surgeon.name);
        surgeon.diagnose();
        surgeon.surgery();
        System.out.println(surgeon.salary);

        CardiacSurgeon car = new CardiacSurgeon("Max");


    }
}
