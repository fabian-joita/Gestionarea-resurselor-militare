package modele;

// Subclasa pentru Tanc
public class Tanc extends VehiculMilitar {
    public Tanc(String id, double comb, String st) {
        super(id, "Tanc", comb, st); // Apel constructor parinte
    }

    @Override
    public double getPragMinimCombustibil() { return 50.0; } // Regula specifica tanc
}
