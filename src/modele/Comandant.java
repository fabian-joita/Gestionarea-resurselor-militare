// Implementeaza relatia de generalizare si functionalitati de decizie ierarhica
package modele;

import java.util.ArrayList;
import java.util.List;

public class Comandant extends Utilizator {
    private String gradMilitar;
    private List<String> notificari;

    public Comandant(String memberName, String idUtilizator, String nume, String gradMilitar) {
        super(memberName, idUtilizator, nume, "Comandant");
        this.gradMilitar = gradMilitar;
        this.notificari = new ArrayList<>();
    }

    // Metoda care analizeaza starea bazei inainte de a aproba
    public boolean aprobareDecizieLogistica(BazaMilitara baza) {
        System.out.println("Comandantul verifica resursele disponibile...");
        int vehiculeGata = baza.getVehiculDisponibile().size();

        if (vehiculeGata > 0) {
            System.out.println("Aprobare acordata pentru " + vehiculeGata + " vehicule.");
            return true;
        } else {
            primesteNotificare("ALERTA: Nu sunt resurse pentru misiune!");
            return false;
        }
    }

    public void primesteNotificare(String mesaj) {
        this.notificari.add(mesaj);
        System.out.println("Notificare receptionata de Comandant: " + mesaj);
    }
}