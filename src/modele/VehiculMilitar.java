package modele;

/**
 * CONCEPT: MOSTENIRE (INHERITANCE) - Clasa Abstracta
 * De ce: Definește un șablon comun pentru toate vehiculele, obligand subclasele
 * sa implementeze logica specifica (pragul de combustibil).
 */
public abstract class VehiculMilitar {
    protected String id;
    protected String model;
    protected double nivelCombustibil;
    protected String stare;

    public VehiculMilitar(String id, String model, double nivelCombustibil, String stare) {
        this.id = id;
        this.model = model;
        this.nivelCombustibil = nivelCombustibil;
        this.stare = stare;
    }

    // Metode abstracte: forteaza polimorfismul în subclase
    public abstract double getPragMinimCombustibil();

    public String getStare() { return stare; }

    public void actualizareStare(String stareDorita) {
        // Logica decizionala bazata pe propritatile specifice obiectului curent
        if (nivelCombustibil < getPragMinimCombustibil()) {
            this.stare = "Indisponibil_Lipsa_Combustibil";
        } else {
            this.stare = stareDorita;
        }
    }

    public void alimenteaza(double cantitate) {
        this.nivelCombustibil += cantitate;
    }
}