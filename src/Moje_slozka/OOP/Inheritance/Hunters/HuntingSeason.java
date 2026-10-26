package Moje_slozka.OOP.Inheritance.Hunters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HuntingSeason {
    static void randomJob(Hunter hunter) {
        Random rng = new Random();
        int random = rng.nextInt(1, 4);

        switch (random) {
            case 1: {
                hunter.hunt();
            }
            case 2: {
                if (hunter instanceof Soldier) {
                    ((Soldier) hunter).Bandits();
                }
                else hunter.gold -= 10;
            }
            case 3: {
                if (hunter instanceof Witcher) {
                    ((Witcher) hunter).slayMonster();
                }
                else hunter.gold -= 10;
            }

        }
    }
    public static void main(String[] args) {
        ArrayList<Hunter> hunters = new ArrayList<>();
        hunters.add(new Hunter("Theodore Roosvelt"));
        hunters.add(new Soldier("Jack Carter"));
        hunters.add(new Hunter("Ondřej Wislocki"));
        hunters.add(new Witcher("Geralt"));
        hunters.add(new Witcher("Vesemir"));

        int pocetZakazek = 100;

        Random rng = new Random();
        int randomIndex;

        for (int i = 0; i < pocetZakazek; i++) {
            randomIndex = rng.nextInt(0, hunters.size());
            randomJob(hunters.get(randomIndex));
        }

        nejlepsi(hunters);


    }

    static void nejlepsi(ArrayList<Hunter> hunters) {
        Hunter nejlepsi = new Hunter(null);

        for (int i = 0; i < hunters.size()-1; i++) {
            if (hunters.get(i).gold > hunters.get(i+1).gold){
                nejlepsi.name = hunters.get(i).name;
                nejlepsi.gold = hunters.get(i).gold;
            }
        }
        System.out.println(nejlepsi);
    }


}
