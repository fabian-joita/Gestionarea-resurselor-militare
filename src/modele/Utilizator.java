package modele;

public abstract class Utilizator {

    protected String memberName;
    protected String idUtilizator;
    protected String nume;
    protected String rol;

    public Utilizator(String memberName,
                      String idUtilizator,
                      String nume,
                      String rol) {

        this.memberName = memberName;
        this.idUtilizator = idUtilizator;
        this.nume = nume;
        this.rol = rol;
    }

    public boolean autentificare(String parola) {

        if (idUtilizator != null
                && idUtilizator.length() > 3
                && parola != null
                && parola.length() >= 4) {

            System.out.println(
                    "Utilizator autentificat: " + nume);

            return true;
        }

        return false;
    }

    public String getNume() {
        return nume;
    }

    public String getRol() {
        return rol;
    }
}