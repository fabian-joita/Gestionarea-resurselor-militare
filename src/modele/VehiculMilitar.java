package modele;

public class VehiculMilitar {

    private String id;
    private String model;
    private double nivelCombustibil;
    private String stare;


    public VehiculMilitar(){
        id = "n/a";
        model = "n/a";
        nivelCombustibil = 0.0;
        stare = "n/a";
    }
    public VehiculMilitar(String id,
                          String model,
                          double nivelCombustibil,
                          String stare) {

        this.id = id;
        this.model = model;
        this.nivelCombustibil = nivelCombustibil;
        this.stare = stare;
    }

    public void actualizareStare(String stareDorita) {
        this.stare = stareDorita;

        System.out.println("Starea vehiculului a fost actualizata.");
    }

    public void alimenteaza(double cantitate) {

        if (cantitate > 0) {

            this.nivelCombustibil += cantitate;

            System.out.println(
                    "Vehicul alimentat.");
        }
    }

    public boolean verificaDisponibilitate() {

        return "Disponibil".equals(stare);
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public double getNivelCombustibil() {
        return nivelCombustibil;
    }

    public String getStare() {
        return stare;
    }

    public void setNivelCombustibil(int nivel){ this.nivelCombustibil = nivel;}
}