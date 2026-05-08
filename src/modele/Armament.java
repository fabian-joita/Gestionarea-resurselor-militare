package modele;

public class Armament {

    private String idArmament;
    private String model;
    private double calibru;
    private String stare;

    public Armament(String idArmament,
                    String model,
                    double calibru,
                    String stare) {

        this.idArmament = idArmament;
        this.model = model;
        this.calibru = calibru;
        this.stare = stare;
    }

    public void actualizareStare(String stareNoua) {

        this.stare = stareNoua;

        System.out.println(
                "Starea armamentului a fost actualizata.");
    }

    public boolean verificaStoc() {

        if ("Functional".equals(stare)) {

            System.out.println(
                    "Armamentul este functional.");

            return true;
        }

        System.out.println(
                "Armamentul necesita verificare.");

        return false;
    }

    public String getIdArmament() {
        return idArmament;
    }

    public String getModel() {
        return model;
    }

    public double getCalibru() {
        return calibru;
    }

    public String getStare() {
        return stare;
    }
}