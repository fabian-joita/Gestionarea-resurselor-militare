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

        System.out.println(
                "Vehicul adaugat in inventar.");
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

        System.out.println(
                "Armament adaugat in baza.");
    }

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

    public List<VehiculMilitar> getVehiculDefecte() {

        List<VehiculMilitar> defecte =
                new ArrayList<>();

        for (VehiculMilitar v : inventarVehicule) {

            if (!v.verificaDisponibilitate()) {
                defecte.add(v);
            }
        }

        return defecte;
    }

    public List<VehiculMilitar> getToateVehiculele() {
        return inventarVehicule;
    }

    public void adaugaPersonal(Utilizator utilizator) {

        personal.add(utilizator);

        System.out.println(
                "Membru adaugat in baza.");
    }
}