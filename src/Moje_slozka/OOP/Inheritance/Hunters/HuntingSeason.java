package Moje_slozka.OOP.Inheritance.Hunters;

import fileworks.DataImport;

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

    static void processeTask(Hunter hunter, String lineParams, String[] taskList) {
        for (int i = 2; i < taskList.length; i++) {
            switch (taskList[i]) {
                case "K":
                    break;
                case "M":
                    break;

            }
        }
    }

    static void loadData(String filePath, ArrayList<Hunter> hunters) {
        DataImport di = new DataImport("data/hunter.txt");

        while (di.hasNext()) {
            String line = di.readLine();
            String[] lineParams = line.split(",");

            Hunter currentHunter;

            switch (lineParams[1]) {
                case "Soldier":
                    currentHunter = new Soldier(lineParams[0]);
                    break;
                case "Witcher":
                    currentHunter = new Witcher(lineParams[0]);
                    break;
                default:
                    currentHunter = new Hunter(lineParams[0]);
                    break;
            }
        }
        di.finishImport();
    }

    public static void main(String[] args) {
        ArrayList<Hunter> hunters = new ArrayList<>();

        if (hunters.isEmpty()) {


            return;
        }

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
