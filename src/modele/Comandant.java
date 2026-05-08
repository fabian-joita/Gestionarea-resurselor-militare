package modele;

import java.util.ArrayList;
import java.util.List;

public class Comandant extends Utilizator {

    private String gradMilitar;
    private List<String> notificari;

    public Comandant(String memberName,
                     String idUtilizator,
                     String nume,
                     String gradMilitar) {

        super(memberName,
                idUtilizator,
                nume,
                "Comandant");

        this.gradMilitar = gradMilitar;
        this.notificari = new ArrayList<>();
    }

    public boolean aprobareDecizieLogistica(BazaMilitara baza) {

        System.out.println(
                "Comandantul verifica vehiculele disponibile...");

        int disponibile =
                baza.getVehiculDisponibile().size();

        if (disponibile > 0) {

            System.out.println(
                    "Misiune aprobata.");

            return true;

        } else {

            primesteNotificare(
                    "Nu exista vehicule disponibile.");

            return false;
        }
    }

    public void primesteNotificare(String mesaj) {

        notificari.add(mesaj);

        System.out.println(
                "Notificare comandant: " + mesaj);
    }

    public void genereazaRaport() {

        System.out.println(
                "===== RAPORT COMANDANT =====");

        if (notificari.isEmpty()) {

            System.out.println(
                    "Nu exista notificari.");

        } else {

            for (String notificare : notificari) {

                System.out.println(
                        notificare);
            }
        }
    }
}