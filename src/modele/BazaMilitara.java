package modele;

import java.util.ArrayList;
import java.util.List;

public class BazaMilitara {
    private String numeBaza;

    /**
     * CONCEPT: COMPOZITIE
     * De ce: BazaMilitara creeaza si gestioneaza direct ciclul de viata al vehiculelor.
     * Dacă baza este distrusa, si inventarul de vehicule dispare.
     */
    private List<VehiculMilitar> inventarVehicule;

    /**
     * CONCEPT: ASOCIERE (Aggregation/Simple Association)
     * De ce: Personalul (Utilizatorii) exista independent de baza.
     * Ei sunt doar "alocati" bazei, nu creati de ea.
     */
    private List<Utilizator> personal;

    public BazaMilitara(String numeBaza) {
        this.numeBaza = numeBaza;
        this.inventarVehicule = new ArrayList<>();
        this.personal = new ArrayList<>();
    }

    /**
     * DESIGN PATTERN: FACTORY METHOD (Simple Factory)
     * DE CE: Pentru a elimina hardcodarea tipurilor de obiecte în codul client.
     * Metoda decide CE obiect sa creeze bazat pe un parametru (tip),
     * respectand în acelasi timp principiul Compozitiei.
     */
    public void adaugaVehiculInInventar(String id, String tip, double comb, String st) {
        VehiculMilitar v;

        if (tip.equalsIgnoreCase("Tanc")) {
            v = new Tanc(id, comb, st);
        } else if (tip.equalsIgnoreCase("Motocicleta")) {
            v = new Motocicleta(id, comb, st);
        } else {
            v = new VehiculGeneric(id, tip, comb, st);
        }

        this.inventarVehicule.add(v);
    }

    /**
     * ALGORITM: Filtrare Polimorfică
     * De ce: Folosește metoda getStare() fără a-i păsa dacă obiectul e Tanc sau Moto.
     */
    public List<VehiculMilitar> getVehiculDisponibile() {
        List<VehiculMilitar> disponibile = new ArrayList<>();
        for (VehiculMilitar v : inventarVehicule) {
            if ("Disponibil".equals(v.getStare())) {
                disponibile.add(v);
            }
        }
        return disponibile;
    }

    public List<VehiculMilitar> getToateVehiculele() {
        return this.inventarVehicule;
    }

    public void adaugaMembruPersonal(Utilizator u) {
        this.personal.add(u); // ASOCIERE: Obiectul vine din exterior
    }
}