import modele.*;

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
                "Transportor Blindat",
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

        // Asociere personal la baza
        baza.adaugaPersonal(comandant);
        baza.adaugaPersonal(operator);
        baza.adaugaPersonal(inginer);

        System.out.println(
                "\n===== RAPORTARE LIPSA =====");

        // Raportare lipsa resurse
        operator.raporteazaLipsa(
                baza,
                "Munitie",
                comandant
        );

        System.out.println(
                "\n===== INSPECTIE VEHICUL =====");

        // Selectare vehicul pentru inspectie
        VehiculMilitar vehicul =
                baza.getToateVehiculele().get(1);

        // Inspectie tehnica
        inginer.inspecteazaVehicul(
                vehicul
        );

        System.out.println(
                "\n===== APROBARE MISIUNE =====");

        // Aprobare logistica
        boolean rezultat =
                comandant.aprobareDecizieLogistica(
                        baza
                );

        System.out.println(
                "\nRezultat aprobare: "
                        + rezultat
        );

        System.out.println(
                "\n===== RAPORT FINAL =====");

        // Generare raport final
        comandant.genereazaRaport();
    }
}