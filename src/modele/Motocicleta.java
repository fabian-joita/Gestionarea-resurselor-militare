package modele;

// Subclasa pentru Motocicleta
public class Motocicleta extends VehiculMilitar {
    public Motocicleta(String id, double comb, String st) {
        super(id, "Motocicleta", comb, st);
    }

    @Override
    public double getPragMinimCombustibil() { return 5.0; } // Regulă specifica moto
}

