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

        this.notificari =
                new ArrayList<>();
    }

    public boolean aprobareDecizieLogistica(
            BazaMilitara baza) {

        System.out.println(
                "Initiere verificare vehicule disponibile...");

        List<VehiculMilitar> disponibile =
                baza.getVehiculDisponibile();

        if (disponibile.isEmpty()) {

            pregatireNotificareLipsaVehicule();

            return false;
        }

        System.out.println(
                "Vehicule disponibile identificate.");

        boolean combustibilSuficient =
                baza.verificaCombustibilVehicule();

        if (!combustibilSuficient) {

            System.out.println(
                    "Solicitare realimentare vehicule...");

            baza.realimentareVehicule();

            boolean confirmare =
                    baza.confirmareRealimentare();

            if (!confirmare) {

                primesteNotificare(
                        "Realimentarea a esuat.");

                return false;
            }
        }

        System.out.println(
                "Misiune aprobata.");

        genereazaRaport();

        return true;
    }

    public void pregatireNotificareLipsaVehicule() {

        primesteNotificare(
                "Nu exista vehicule disponibile.");
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