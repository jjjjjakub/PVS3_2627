package Moje_slozka.OOP.Inheritance.Hunters;

public class Soldier extends Hunter{

    public Soldier(String name) {
        super(name);
        gold += 40;
    }

    public int Bandits() {
        gold += 100;
        System.out.println(name + " is going to againts bandits.");
        return gold;
    }
}
