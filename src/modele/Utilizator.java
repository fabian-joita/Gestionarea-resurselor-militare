// Clasa abstracta care serveste drept radacina pentru ierarhia de generalizare
package modele;

public abstract class Utilizator {
    protected String memberName;
    protected String idUtilizator;
    protected String nume;
    protected String rol;

    public Utilizator(String memberName, String idUtilizator, String nume, String rol) {
        this.memberName = memberName;
        this.idUtilizator = idUtilizator;
        this.nume = nume;
        this.rol = rol;
    }

    // Metoda cu logica specifica pentru validarea formatului ID-ului
    public boolean autentificare(String parolaIntrodusa) {
        if (idUtilizator != null && idUtilizator.length() > 3) {
            System.out.println("Utilizatorul " + nume + " s-a autentificat cu succes.");
            return true;
        }
        return false;
    }

    public String getNume() { return nume; }
    public String getRol() { return rol; }
}