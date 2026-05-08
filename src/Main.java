package modele;

public class Main {

    public static void main(String[] args) {

        // Creare baza militara
        BazaMilitara baza =
                new BazaMilitara(
                        "Baza NATO",
                        "Constanta"
                );

        // Adaugare vehicule
        baza.adaugaVehiculInInventar(
                "V1",
                "Transportor",
                50,
                "Disponibil"
        );

        baza.adaugaVehiculInInventar(
                "V2",
                "Tanc",
                10,
                "Disponibil"
        );

        // Adaugare armament
        baza.adaugaArmament(
                "A1",
                "Tun",
                120,
                "Functional"
        );

        // Creare utilizatori
        Comandant comandant =
                new Comandant(
                        "CMD",
                        "ID01",
                        "Popescu",
                        "Colonel"
                );

        OperatorLogistic operator =
                new OperatorLogistic(
                        "OP",
                        "ID02",
                        "Ionescu"
                );

        InginerMecanic inginer =
                new InginerMecanic(
                        "ING",
                        "ID03",
                        "Georgescu",
                        "Motoare"
                );

        // Asociere personal
        baza.adaugaPersonal(comandant);
        baza.adaugaPersonal(operator);
        baza.adaugaPersonal(inginer);

        // Operatorul raporteaza lipsa
        operator.raporteazaLipsa(
                baza,
                "Munitie",
                comandant
        );

        // Inginerul verifica vehicul
        VehiculMilitar vehicul =
                baza.getToateVehiculele().get(1);

        inginer.inspecteazaVehicul(vehicul);

        // Comandantul aproba misiunea
        boolean rezultat =
                comandant.aprobareDecizieLogistica(
                        baza
                );

        System.out.println(
                "Rezultat aprobare: "
                        + rezultat
        );

        // Generare raport
        comandant.genereazaRaport();
    }
}