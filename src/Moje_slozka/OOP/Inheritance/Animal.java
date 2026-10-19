package Moje_slozka.OOP.Inheritance;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    protected String name;
    private double energy;

    public Animal(String name, double energy) {
        this.name = name;
        this.energy = energy;
    }

    public void eat() {
        energy += Math.exp(-energy);
    }

    public void makeNoise() {
        System.out.println("Make some noise");
    }
}

class Dog extends Animal {
    public String breed;

    public Dog(String name, double energy) {
        super(name, energy);
    }

    public Dog(String name, double energy, String breed) {
        super(name, energy);
        this.breed = breed;
    }

    @Override
    public void makeNoise() {
        System.out.println("Haf");
    }
}

class Cat extends Animal {
    public Cat(String name, double energy) {
        super(name, energy);
    }




    @Override
    public void makeNoise() {
        System.out.println("Moew");
    }

}

class Pig extends Animal {
    int mudLevel;

    public Pig(String name, double energy) {
        super(name, energy);
    }

    public Pig(String name, double energy, int mudLevel) {
        super(name, energy);
        this.mudLevel = mudLevel;
    }

    void wallowingInTheMud() {
        mudLevel += 10;
        mudLevel = Math.min(mudLevel, 100);
    }

    @Override
    public void makeNoise() {
        System.out.println("Chorochro");
    }
}

class Main {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/animals.txt");

        //přeskočít hlavičku
        di.readLine();

        List<Animal> animals = new ArrayList<>();
        while (di.hasNext()) {
            String line = di.readLine();
            String[] tokens = line.trim().split(";");

            if (tokens[0].equals("Dog")) {
                animals.add(new Dog(tokens[2], Double.parseDouble(tokens[1]), tokens[3]));
                break;
            }
            else if (tokens[0].equals("Cat")) {
                animals.add(new Cat(tokens[2], Double.parseDouble(tokens[1])));
                break;
            }
            else if (tokens[0].equals("Pig")) {
                animals.add(new Pig(tokens[2], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[4])));
                break;
            }

        }

        for (Animal animal : animals){
            if (animal instanceof Dog) {

            }
        }
        System.out.println(animals);
        di.finishImport();

    }
}