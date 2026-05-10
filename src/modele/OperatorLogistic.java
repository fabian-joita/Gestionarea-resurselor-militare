package modele;

public class OperatorLogistic extends Utilizator {

    public OperatorLogistic(String memberName,
                            String idUtilizator,
                            String nume) {

        super(memberName,
                idUtilizator,
                nume,
                "Operator Logistic");
    }

    public void adaugaVehicul(BazaMilitara baza,
                              String id,
                              String model,
                              double combustibil,
                              String stare) {

        baza.adaugaVehiculInInventar(
                id,
                model,
                combustibil,
                stare
        );

        System.out.println(
                "Vehicul adaugat in inventar.");
    }

    public void actualizeazaStoc(VehiculMilitar vehicul,
                                 double cantitate) {

        vehicul.alimenteaza(cantitate);

        System.out.println(
                "Stoc combustibil actualizat.");
    }

    public void raporteazaLipsa(
            String resursa,
            Comandant comandant) {

        if (resursa == null || resursa.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Denumirea resursei nu poate fi goala."
            );
        }

        if (comandant == null) {
            throw new IllegalArgumentException(
                    "Comandantul nu poate fi null."
            );
        }

        System.out.println(
                "Lipsa raportata: "
                        + resursa);

        comandant.primesteNotificare(
                "Lipsa resursa: "
                        + resursa
                        + " raportata de "
                        + this.nume);
    }
}