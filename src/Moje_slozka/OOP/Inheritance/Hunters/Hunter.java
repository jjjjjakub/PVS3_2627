package Moje_slozka.OOP.Inheritance.Hunters;

public class Hunter {
    String name;
    int gold;

    public Hunter(String name) {
        this.name = name;
        this.gold = 10;
    }

    public int hunt() {
        System.out.println(name + " is hunting a beast.");
        gold += 10;
        return gold;
    }

    @Override
    public String toString() {
        return "Hunter{" +
                "name='" + name + '\'' +
                ", gold=" + gold +
                '}';
    }
}
