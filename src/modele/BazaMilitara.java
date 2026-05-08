package modele;

import java.util.ArrayList;
import java.util.List;

public class BazaMilitara {

    private String numeBaza;
    private String locatie;

    private List<VehiculMilitar> inventarVehicule;
    private List<Armament> inventarArmament;
    private List<Utilizator> personal;

    public BazaMilitara(String numeBaza,
                        String locatie) {

        this.numeBaza = numeBaza;
        this.locatie = locatie;

        this.inventarVehicule =
                new ArrayList<>();

        this.inventarArmament =
                new ArrayList<>();

        this.personal =
                new ArrayList<>();
    }

    /**
     * Adaugare vehicul
     */
    public void adaugaVehiculInInventar(String id,
                                        String model,
                                        double combustibil,
                                        String stare) {

        VehiculMilitar vehicul =
                new VehiculMilitar(
                        id,
                        model,
                        combustibil,
                        stare
                );

        inventarVehicule.add(vehicul);
    }

    /**
     * Returneaza vehicule disponibile
     */
    public List<VehiculMilitar> getVehiculDisponibile() {

        List<VehiculMilitar> disponibile =
                new ArrayList<>();

        for (VehiculMilitar v : inventarVehicule) {

            if (v.verificaDisponibilitate()) {
                disponibile.add(v);
            }
        }

        return disponibile;
    }

    /**
     * Verificare combustibil suficient
     */
    public boolean verificaCombustibilVehicule() {

        for (VehiculMilitar v : inventarVehicule) {

            if (v.getNivelCombustibil() >= 20) {
                return true;
            }
        }

        return false;
    }

    /**
     * Realimentare vehicule
     */
    public void realimentareVehicule() {

        System.out.println(
                "Programare realimentare vehicule...");

        for (VehiculMilitar v : inventarVehicule) {

            if (v.getNivelCombustibil() < 20) {

                v.alimenteaza(50);

                v.actualizareStare("Disponibil");
            }
        }

        System.out.println(
                "Realimentare finalizata.");
    }

    /**
     * Confirmare realimentare
     */
    public boolean confirmareRealimentare() {

        return verificaCombustibilVehicule();
    }

    public void adaugaPersonal(Utilizator utilizator) {

        personal.add(utilizator);
    }

    public List<VehiculMilitar> getToateVehiculele() {

        return inventarVehicule;
    }

    public void adaugaArmament(String idArmament,
                               String model,
                               double calibru,
                               String stare) {

        Armament armament =
                new Armament(
                        idArmament,
                        model,
                        calibru,
                        stare
                );

        inventarArmament.add(armament);
    }
}