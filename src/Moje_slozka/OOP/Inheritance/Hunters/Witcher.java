package Moje_slozka.OOP.Inheritance.Hunters;

public class Witcher extends Soldier{

    public Witcher(String name) {
        super(name);
        gold += 50;
    }

    public int slayMonster() {
        System.out.println(name + " is hunting for a monsters");
        gold += 250;
        return gold;
    }

    @Override
    public int hunt() {
        System.out.println(name + " is hunting a beast.");
        gold += 50;
        return gold;
    }
}
