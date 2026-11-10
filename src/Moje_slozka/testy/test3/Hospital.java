package Moje_slozka.testy.test3;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Comparator;

// Načtěte ze souboru hospitalData informace o doktorech
// do souboru hospital.txt vypiste nasledujici informace o vsech doktorech:

// 1. Doktora s nejvetsim vydelkem
// 2. Doktora s nejmensjim vydelkem
// 3. Prumerny plat v nemocnici
// 4. Pocet realizovanych operací srdce
// 5. Pocet udelenych penalizaci nemocnici
//     - Nemocnice je penalizovana za kazdy zakrok doktora, na ktery nema kvalifikaci

// Bonus:
//   Vypiste 5 nejlepe placenych doktoru v nemocnici
//   Procentualni zastoupeni zamestnancu. (příklad: 50% Doktoři, 35% Chirurgové, 15% Kardiochirurgové)
//   Kdo způsobil největší penalizaci nemocnici

public class Hospital {

    static void validateJob(Doctor d, String jobType) {
        // TODO: implementujte logiku validace práce:
        // Doktor může dělat práci typu `jobType` jen pokud je kvalifikovan
        // C -> cardiacSurgery
        // S -> surgery
        // D -> diagnose
        int penalization = 0;

        switch (jobType) {
            case "C":
                if (d instanceof CardiacSurgeon){
                    ((CardiacSurgeon) d).cardiacSurgery();
                }
                else {
                    penalization++;
                }
                break;
            case "S":
                if (d instanceof Surgeon){
                    ((Surgeon) d).surgery();
                }
                else {
                    penalization++;
                }
                break;
            default:
                d.diagnose();
                break;
        }
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/hospitalData.txt");
        DataExport de = new DataExport("data/salaries.txt");

        // TODO: napsat test
        while (di.hasNext()) {
            String rada = di.readLine();
            String[] tokens = rada.split(";");

            ArrayList<Doctor> doctors = new ArrayList<>();
            switch (tokens[1]){
                case "CardiacSurgeon":
                    doctors.add(new CardiacSurgeon(tokens[0]));
                    break;
                case "Surgeon":
                    doctors.add(new Surgeon(tokens[0]));
                    break;
                default:
                    doctors.add(new Doctor(tokens[0]));
            }

            for (int i = 2; i < tokens.length; i++) {
                String jobType = tokens[i];
            }


        }


        // nezapomenout na úklid
        di.finishImport();
        de.finishExport();
    }

    Doctor bestSalary(ArrayList<Doctor> doctors) {
        doctors.sort(Comparator.comparing(Doctor::getSalary));
        return doctors.getFirst();
    }

    Doctor worstSalary(ArrayList<Doctor> doctors) {
        doctors.sort(Comparator.comparing(Doctor::getSalary).reversed());
        return doctors.getFirst();
    }

    double averageSalary(ArrayList<Doctor> doctors) {
        int soucet = 0;
        double average;
        for (Doctor doctor : doctors) {
            soucet += doctor.salary;
        }
        average = (double) soucet / doctors.size();
        return average;
    }



}
