package modele;

public class VehiculMilitar {

    private String id;
    private String model;
    private double nivelCombustibil;
    private String stare;

    public VehiculMilitar(String id,
                          String model,
                          double nivelCombustibil,
                          String stare) {

        this.id = id;
        this.model = model;
        this.nivelCombustibil =
                nivelCombustibil;

        this.stare = stare;
    }

    public void actualizareStare(
            String stareDorita) {

        if (nivelCombustibil < 20) {

            this.stare =
                    "Indisponibil_Lipsa_Combustibil";

        } else {

            this.stare = stareDorita;
        }
    }

    public void alimenteaza(double cantitate) {

        if (cantitate < 0) {

            throw new IllegalArgumentException(
                    "Cantitatea nu poate fi negativa."
            );
        }

        this.nivelCombustibil += cantitate;
    }

    public boolean verificaDisponibilitate() {

        return "Disponibil".equals(stare);
    }

    public double getNivelCombustibil() {
        return nivelCombustibil;
    }

    public String getStare() {
        return stare;
    }

    public String getModel() {
        return model;
    }

    public String getId() {
        return id;
    }
}