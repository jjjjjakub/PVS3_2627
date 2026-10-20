package Moje_slozka.OOP.Inheritance;

public class CardiacSurgeon extends Surgeon{
    final static int CS_BONUS = 35000;

    public CardiacSurgeon(String name) {
        super(name);
        salary += CS_BONUS;
    }

    void cardiacSurgury() {
        System.out.println("Out of my heart into pieces");
        salary += 30000;
    }
}
