package modele;

// Subclasa de rezerva (Fallback)
public class VehiculGeneric extends VehiculMilitar {
    public VehiculGeneric(String id, String mod, double comb, String st) {
        super(id, mod, comb, st);
    }

    @Override
    public double getPragMinimCombustibil() { return 10.0; }
}
